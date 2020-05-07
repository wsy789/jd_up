package com.wsy.jd2.ui.topic;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseFragment;
import com.wsy.jd2.presenter.MinePresenter;
import com.wsy.jd2.presenter.TopicPresenter;
import com.wsy.jd2.view.MineView;
import com.wsy.jd2.view.TopicView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopicFragment extends BaseFragment<TopicPresenter> implements TopicView {
    public static TopicFragment newInstance() {
        TopicFragment fragment = new TopicFragment();
        return fragment;
    }


    @Override
    protected TopicPresenter initPresenter() {
        return null;
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_mine;
    }

}
