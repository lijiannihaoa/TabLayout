package com.lijian.ui.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lijian.ui.R;

/**
 * 作者  lijian 日期 16/2/8.
 * 邮箱 2316125950@qq.com
 * 类名称 MyButtom
 * 类备注
 */
public class MyButtom extends LinearLayout
{
    private View view = null;
    private LayoutInflater inflater = null;
    private RelativeLayout main = null;
    private RelativeLayout found = null;
    private RelativeLayout order = null;
    private RelativeLayout person = null;

    public MyButtom(Context context)
    {
        super(context);
    }

    public MyButtom(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        initView();
    }

    public MyButtom(Context context, AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }

    //把我们刚才定义的mybuttom的布局文件填充到这个自定义的容器中去
    private void initView()
    {
        inflater = LayoutInflater.from(getContext());
        view = inflater.inflate(R.layout.mybuttom, this);

        //找到每个tab对应的RelativeLayout容器
        main = (RelativeLayout) view.findViewById(R.id.main_tab);
        found = (RelativeLayout) view.findViewById(R.id.found_tab);
        order = (RelativeLayout) view.findViewById(R.id.order_tab);
        person = (RelativeLayout) view.findViewById(R.id.person_tab);

        //初始化每个tab
        initTab();
        //设置tab的点击事件
        initEvent();
        //设置第一个tab默认选中
        initTabSelect();
    }

    //设置第一个tab默认选中
    private void initTabSelect()
    {
        setTabChang(0);
    }

    //设置tab的点击事件
    private void initEvent()
    {
        main.setOnClickListener(lijian);
        found.setOnClickListener(lijian);
        order.setOnClickListener(lijian);
        person.setOnClickListener(lijian);
    }

    OnClickListener lijian = new OnClickListener()
    {
        @Override
        public void onClick(View v)
        {
            switch (v.getId())
            {
                case R.id.main_tab:
                    changTabStyle(main, R.mipmap.shopping_home_tab_take_out_selected);
                    break;
                case R.id.found_tab:
                    changTabStyle(found, R.mipmap.shopping_home_tab_found_selected);
                    break;
                case R.id.order_tab:
                    changTabStyle(order, R.mipmap.shopping_home_tab_order_selected);
                    break;
                case R.id.person_tab:
                    changTabStyle(person, R.mipmap.shopping_home_tab_personal_selected);
                    break;
            }
            //对外公布一个接口,让用户知道我点击了哪个tab按钮
            onTabClick.onTabClick(v.getId());
        }
    };

    //改变Tab的img图片和字体的样式
    private void changTabStyle(RelativeLayout layout, int imgId)
    {
        initTab();
        ImageView img = (ImageView) layout.findViewById(R.id.tabImg);
        img.setBackgroundResource(imgId);
        TextView txt = (TextView) layout.findViewById(R.id.tabTxt);
        txt.setTextColor(Color.BLUE);
    }

    //初始化每个tab
    private void initTab()
    {
        setTabValue(main, R.mipmap.shopping_home_tab_take_out, "首页");
        setTabValue(found, R.mipmap.shopping_home_tab_found, "发现");
        setTabValue(order, R.mipmap.shopping_home_tab_order, "点单");
        setTabValue(person, R.mipmap.shopping_home_tab_personal, "我的");
    }

    private void setTabValue(RelativeLayout layout, int imgId, String text)
    {
        ImageView img = (ImageView) layout.findViewById(R.id.tabImg);
        img.setBackgroundResource(imgId);

        TextView txt = (TextView) layout.findViewById(R.id.tabTxt);
        txt.setText(text);
        txt.setTextColor(Color.WHITE);
    }


    //定义一个接口
    public interface OnTabClick
    {
        public void onTabClick(int id);
    }

    public OnTabClick onTabClick;

    public void setOnTabClick(OnTabClick onTabClick)
    {
        this.onTabClick = onTabClick;
    }


    //对外公布一个方法来改变tab的选中状态
    public void setTabChang(int position)
    {
        initTab();
        switch (position)
        {
            case 0:
                changTabStyle(main, R.mipmap.shopping_home_tab_take_out_selected);
                break;
            case 1:
                changTabStyle(found, R.mipmap.shopping_home_tab_found_selected);
                break;
            case 2:
                changTabStyle(order, R.mipmap.shopping_home_tab_order_selected);
                break;
            case 3:
                changTabStyle(person, R.mipmap.shopping_home_tab_personal_selected);
                break;
        }
    }

}
