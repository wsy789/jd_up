package com.wsy.jd2.ui.mine;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseFragment;
import com.wsy.jd2.presenter.MinePresenter;
import com.wsy.jd2.view.MineView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineView {
    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    protected MinePresenter initPresenter() {
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
