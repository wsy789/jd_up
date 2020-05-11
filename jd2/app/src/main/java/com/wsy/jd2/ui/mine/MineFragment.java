package com.wsy.jd2.ui.mine;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseFragment;
import com.wsy.jd2.presenter.MinePresenter;
import com.wsy.jd2.ui.login.LoginActivity;
import com.wsy.jd2.view.MineView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment<MinePresenter> implements MineView, View.OnClickListener {
    private ImageView mLoginIvMine;
    private TextView mLoginStateMine;
    private TextView mLoginWelcomeMine;
    private ConstraintLayout mLoginClMine;
    private Button mLoginBtMine;

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
    protected void initView(View itemView) {

        mLoginIvMine = (ImageView) itemView.findViewById(R.id.mine_login_iv);
        mLoginStateMine = (TextView) itemView.findViewById(R.id.mine_login_state);
        mLoginWelcomeMine = (TextView) itemView.findViewById(R.id.mine_login_welcome);
        mLoginClMine = (ConstraintLayout) itemView.findViewById(R.id.mine_login_cl);
        mLoginBtMine = (Button) itemView.findViewById(R.id.mine_login_bt);
        mLoginBtMine.setOnClickListener(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_login;
//        return R.layout.fragment_register;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mine_login_bt:
                // TODO 我的fragment跳转到login
                Intent intent = new Intent(getActivity(),LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
