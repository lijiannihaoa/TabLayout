package com.lijian.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.lijian.ui.fragment.FoundFragment;
import com.lijian.ui.fragment.MainFragment;
import com.lijian.ui.fragment.OrderFragment;
import com.lijian.ui.fragment.PersonFragment;
import com.lijian.ui.widget.MyButtom;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private MyButtom mainButtom = null;
    private ViewPager mainViewPager = null;
    private  Toolbar toolbar = null;

    //viewpager所需的数据源(Fragment的集合)
    private List<Fragment> mList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        initView();

        //设置当前的ActionBar为toolbar
        setSupportActionBar(toolbar);
        //为toolbar设置标题(这里是动态的设置标题,当你不需要动态设置标题,可以直接在toolbar里面设置它的title属性)
        toolbar.setTitle("首页");

        //给viewpager设置数据源
        initData();
        //把viewpager和底部的buttom相关联
        initConnection();
    }

    private void initConnection()
    {
        //底部的四个按钮和viewpager关联
        mainButtom.setOnTabClick(new MyButtom.OnTabClick()
        {
            @Override
            public void onTabClick(int id)
            {
                switch (id)
                {
                    case R.id.main_tab:
                        mainViewPager.setCurrentItem(0);
                        toolbar.setTitle("首页");
                        break;
                    case R.id.found_tab:
                        mainViewPager.setCurrentItem(1);
                        toolbar.setTitle("发现");
                        break;
                    case R.id.order_tab:
                        mainViewPager.setCurrentItem(2);
                        toolbar.setTitle("点单");
                        break;
                    case R.id.person_tab:
                        mainViewPager.setCurrentItem(3);
                        toolbar.setTitle("我的");
                        break;
                }
            }
        });
        //viewpager和底部的四个按钮关联(通过viewpager的滑动监听事件)
        mainViewPager.addOnPageChangeListener(lijian);
    }

    ViewPager.OnPageChangeListener lijian = new ViewPager.OnPageChangeListener()
    {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
        {

        }

        @Override
        public void onPageSelected(int position)
        {
            mainButtom.setTabChang(position);
            switch (position)
            {
                case 0:
                    toolbar.setTitle("首页");
                    break;
                case 1:
                    toolbar.setTitle("发现");
                    break;
                case 2:
                    toolbar.setTitle("点单");
                    break;
                case 3:
                    toolbar.setTitle("我的");
                    break;
            }
        }

        @Override
        public void onPageScrollStateChanged(int state)
        {

        }
    };

    private void initView()
    {
        //拿到布局文件中的toolbar控件
        toolbar = (Toolbar) this.findViewById(R.id.toolbar);

        mainViewPager = (ViewPager) this.findViewById(R.id.main_viewpager);
        mainButtom = (MyButtom) this.findViewById(R.id.main_buttom);
    }

    private void initData()
    {
        mList = new ArrayList<>();
        mList.add(new MainFragment());
        mList.add(new FoundFragment());
        mList.add(new OrderFragment());
        mList.add(new PersonFragment());
        mainViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter
    {

        public MyViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return mList.get(position);
        }

        @Override
        public int getCount()
        {
            return mList.size();
        }
    }
}
