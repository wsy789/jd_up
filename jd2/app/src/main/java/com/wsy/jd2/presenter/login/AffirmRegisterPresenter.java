package com.wsy.jd2.presenter.login;

import com.wsy.jd2.base.BasePresenter;
import com.wsy.jd2.bean.login.AffirmRegisterBean;
import com.wsy.jd2.model.login.AffirmRegisterModel;
import com.wsy.jd2.model.login.LoginModel;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.ui.contract.AffirmContract;

public class AffirmRegisterPresenter extends BasePresenter<AffirmContract.IAffirmView> implements AffirmContract.IAffirmPresenter {
    private AffirmRegisterModel affirmRegisterModel;

    @Override
    protected void initModel() {
        affirmRegisterModel = new AffirmRegisterModel();
        addModel(affirmRegisterModel);
    }
    @Override
    public void register(String phoneNum, String password, String affirm_password) {
        affirmRegisterModel.register(phoneNum, password, affirm_password, new ResultCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean registerBean) {
                mView.registerResult(registerBean);
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
