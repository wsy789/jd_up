package com.wsy.jd2.presenter.login;

import com.wsy.jd2.base.BasePresenter;
import com.wsy.jd2.bean.login.VerfiedBean;
import com.wsy.jd2.model.login.LoginModel;
import com.wsy.jd2.model.login.RegisterMSMModel;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.ui.contract.RegisterMSMContract;

public class RegisterMSMPresenter extends BasePresenter<RegisterMSMContract.IRegisterMSMView> implements RegisterMSMContract.IRegisterMSMPresenter {
    private RegisterMSMModel registerMSMModel;

    @Override
    protected void initModel() {
        registerMSMModel = new RegisterMSMModel();
        addModel(registerMSMModel);
    }

    @Override
    public void getVerified(String string, String type) {
        registerMSMModel.getVerified(string, type, new ResultCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mView.getVerified(verfiedBean);
            }
            @Override
            public void onFail(String msg) {

            }
        });
    }
//檢查验证码
    @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {
        registerMSMModel.checkSmsCode(phoneNum, smsCode, type, new ResultCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean verfiedBean) {
                mView.checkSmsCodeResult(verfiedBean);
            }
            @Override
            public void onFail(String msg) {

            }
        });
    }

}
