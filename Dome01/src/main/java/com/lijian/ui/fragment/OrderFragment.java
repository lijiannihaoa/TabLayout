package com.lijian.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lijian.ui.R;

/**
 * 作者  lijian 日期 16/2/8.
 * 邮箱 2316125950@qq.com
 * 类名称 MainFragment
 * 类备注
 */
public class OrderFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.order_fragment,container,false);
    }
}
