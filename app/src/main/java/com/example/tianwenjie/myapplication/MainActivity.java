package com.example.tianwenjie.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.tianwenjie.myapplication.adap.MainFragmentPagerAdapter;
import com.example.tianwenjie.myapplication.conFig.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @Bind(R.id.toolbar)
    Toolbar mToolbar;
    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.viewpager)
    ViewPager mViewPager;
    @Bind(R.id.tabs)
    TabLayout mTabLayout;
    @Bind(R.id.nav_view)
    NavigationView mNavigationView;
    @Bind(R.id.fab)
    FloatingActionButton mFABtn;

    private MainFragmentPagerAdapter mPagerAdapter;

     private BenefitListFragment mBenefitListFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.mipmap.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(mNavigationView);

        setupViewPager();
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void setupViewPager() {

         mBenefitListFragment = new BenefitListFragment();
        mPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
          mPagerAdapter.addFragment(CommonGoodsListFragment.newFragment("Android"), "Android");
          mPagerAdapter.addFragment(CommonGoodsListFragment.newFragment("IOS"), "IOS");
          mPagerAdapter.addFragment(mBenefitListFragment, "福利");
        mViewPager.setAdapter(mPagerAdapter);
    }


    //点击menu弹出的菜单
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:

                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        menuItem.setChecked(true);
                        mDrawerLayout.closeDrawers();
                        disposeMenuAction(menuItem);
                        return true;
                    }
                });
    }
    private void disposeMenuAction(MenuItem item){
        switch (item.getItemId()){
            case R.id.nav_collect:
            case R.id.nav_time:
                Toast.makeText(this,"功能开发中",Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_code:
                callWebView(Constants.GITHUB_URL);
                break;
            case R.id.nav_author:
                callWebView(Constants.AUTHOR_URL);
                break;
        }
    }

    private void callWebView(String url){
        Intent intent= new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        startActivity(intent);
    }
}
