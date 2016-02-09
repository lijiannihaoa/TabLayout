package com.lijian.ui;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private TabLayout mTabLayout = null;

    private ViewPager mViewPager = null;

    private List<Fragment> mLsTabContent = null;

    private List<String> mLsTabTitle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        initView();

        initData();
    }

    private void initData()
    {
        mLsTabTitle = new ArrayList<>();
        mLsTabTitle.add("one");
        mLsTabTitle.add("two");
        mLsTabTitle.add("three");

        mLsTabContent = new ArrayList<>();
        mLsTabContent.add(new OneFragment());
        mLsTabContent.add(new TwoFragment());
        mLsTabContent.add(new ThreeFragment());

        //添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mLsTabTitle.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mLsTabTitle.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mLsTabTitle.get(2)));

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        //给ViewPager设置适配器
        mViewPager.setAdapter(adapter);

        //设置tab模式，当前为系统默认模式
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        //设置tab的样式
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //设置tab指示器的高度
        mTabLayout.setSelectedTabIndicatorHeight(3);

        //将TabLayout和ViewPager关联起来。
        mTabLayout.setupWithViewPager(mViewPager);

        //给Tabs设置适配器
        mTabLayout.setTabsFromPagerAdapter(adapter);

    }

    private void initView()
    {
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
    }

    private class MyAdapter extends FragmentStatePagerAdapter
    {

        public MyAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mLsTabContent.get(position);
        }

        @Override
        public int getCount()
        {
            return mLsTabContent.size();
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            return mLsTabTitle.get(position);
        }
    }
}
