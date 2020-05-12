package com.wf.jd.login.presenter;

import com.wf.jd.base.BasePresenter;
import com.wf.jd.login.bean.AffirmRegisterBean;
import com.wf.jd.login.contract.PassWordLoginContract;
import com.wf.jd.login.model.PassWordLoginModel;
import com.wf.jd.net.INetCallBack;

public class PassWordLoginPresenter extends BasePresenter<PassWordLoginContract.IPassWordLoginView> implements PassWordLoginContract.IPassWordLoginPresenter {

    private PassWordLoginContract.IPassWordLoginMode iPassWordLoginMode;

    public PassWordLoginPresenter() {
        iPassWordLoginMode = new PassWordLoginModel();
    }

    @Override
    public void passWordLogin(String username, String password) {

        iPassWordLoginMode.passWordLogin(username, password, new INetCallBack<AffirmRegisterBean>() {
            @Override
            public void onSuccess(AffirmRegisterBean affirmRegisterBean) {

                mview.getPWLoginResult(affirmRegisterBean);

            }
            @Override
            public void onError(Throwable throwable) {

//                这里去通知V层刷新失败得结果


            }
        });

    }
}
