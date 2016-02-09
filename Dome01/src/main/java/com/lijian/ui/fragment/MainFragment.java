package com.lijian.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lijian.ui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者  lijian 日期 16/2/8.
 * 邮箱 2316125950@qq.com
 * 类名称 MainFragment
 * 类备注
 */
public class MainFragment extends Fragment
{
    private View view = null;
    private TabLayout mTabLayout = null;
    private ViewPager mViewPager = null;

    private List<String> mLsTabTitle = null;

    private List<Fragment> mLsTabContent = null;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.main_fragment, container, false);
        initView();
        initTabData();
        return view;
    }

    //初始化tab的数据
    private void initTabData()
    {
        mLsTabTitle = new ArrayList<>();
        mLsTabTitle.add("小吃类");
        mLsTabTitle.add("家居类");
        mLsTabTitle.add("电器类");

        mLsTabContent = new ArrayList<>();
        mLsTabContent.add(new OneFragment());
        mLsTabContent.add(new TwoFragment());
        mLsTabContent.add(new ThreeFragment());

        //添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mLsTabTitle.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mLsTabTitle.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mLsTabTitle.get(2)));

        MyAdapter adapter = new MyAdapter(getChildFragmentManager());

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

    //初始化控件
    private void initView()
    {
        mTabLayout = (TabLayout) view.findViewById(R.id.tabs);
        mViewPager = (ViewPager) view.findViewById(R.id.mainfragment_viewpager);
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
