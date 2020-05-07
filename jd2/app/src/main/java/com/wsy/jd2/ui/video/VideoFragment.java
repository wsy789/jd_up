package com.wsy.jd2.ui.video;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseFragment;
import com.wsy.jd2.presenter.MinePresenter;
import com.wsy.jd2.presenter.VideoPresenter;
import com.wsy.jd2.view.MineView;
import com.wsy.jd2.view.VideoView;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends BaseFragment<VideoPresenter> implements VideoView {

    public static VideoFragment newInstance() {
        VideoFragment fragment = new VideoFragment();
        return fragment;
    }


    @Override
    protected VideoPresenter initPresenter() {
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
