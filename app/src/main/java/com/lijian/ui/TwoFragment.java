package com.lijian.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者  lijian 日期 16/2/3.
 * 邮箱 2316125950@qq.com
 * 类名称 OneFragment
 * 类备注
 */
public class TwoFragment extends Fragment
{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.two,container,false);
        return view;
    }
}
