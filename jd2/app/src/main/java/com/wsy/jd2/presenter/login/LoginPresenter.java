package com.wsy.jd2.presenter.login;

import android.util.Log;

import com.wsy.jd2.base.BasePresenter;
import com.wsy.jd2.base.Constants;
import com.wsy.jd2.bean.ColunmBean;
import com.wsy.jd2.bean.login.VerfiedBean;
import com.wsy.jd2.model.RecommendModel;
import com.wsy.jd2.model.login.LoginModel;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.ui.contract.LoginContract;

import java.io.IOException;

import okhttp3.ResponseBody;

public class LoginPresenter extends BasePresenter<LoginContract.ILoginView> implements LoginContract.ILoginPresenter {
    private LoginModel loginModel;

    @Override
    protected void initModel() {
        loginModel = new LoginModel();
        addModel(loginModel);
    }
    @Override
    public void getVerified(String phoneNum, String type) {

        loginModel.getVerified(phoneNum, type, new ResultCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean s) {

                mView.getVerified(s);
            }
            @Override
            public void onFail(String msg) {

            }

        });

    }

    @Override
    public void login(String mobile, String smsCode) {
        loginModel.login(mobile, smsCode, new ResultCallBack<ResponseBody>() {
            @Override
            public void onSuccess(ResponseBody responseBody) {
                try {//code 4  需要完善密码
                    Log.e("TAG","登录成功返回值："+responseBody.string());
//                    mView.getLoginResult(responseBody.string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFail(String msg) {
            }
        });
    }
        @Override
    public void checkSmsCode(String phoneNum, String smsCode, String type) {

            Log.e("TAG", phoneNum + "验证p层码值：" + smsCode);

            loginModel.checkSmsCode(phoneNum, smsCode, type, new ResultCallBack<VerfiedBean>() {
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
