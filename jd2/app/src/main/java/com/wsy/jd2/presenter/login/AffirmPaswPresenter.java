package com.wf.jd.login.presenter;

import com.wf.jd.base.BasePresenter;
import com.wf.jd.login.bean.VerfiedBean;
import com.wf.jd.login.contract.AffirmContract;
import com.wf.jd.login.contract.AffirmPassWordContract;
import com.wf.jd.login.model.AffirmPaswMode;
import com.wf.jd.net.INetCallBack;

public class AffirmPaswPresenter extends BasePresenter<AffirmPassWordContract.IAffirmPaswView> implements AffirmPassWordContract.IAffirmPaswPresenter {

    private AffirmPassWordContract.IAffirmPaswMode iAffirmPaswMode;

    public AffirmPaswPresenter() {

        iAffirmPaswMode = new AffirmPaswMode();

    }

    @Override
    public void forgetPasw(String phoneNum, String sms, String password) {

        iAffirmPaswMode.forgetPasw(phoneNum, sms, password, new INetCallBack<VerfiedBean>() {
            @Override
            public void onSuccess(VerfiedBean bean) {

                mview.registerResult(bean);
            }

            @Override
            public void onError(Throwable throwable) {

            }
        });

    }
}
