package com.wsy.jd2.ui.contract;

import com.wf.jd.base.BaseView;
import com.wf.jd.login.bean.AffirmRegisterBean;
import com.wf.jd.login.bean.VerfiedBean;
import com.wf.jd.net.INetCallBack;

public class AffirmPassWordContract {


    public interface IAffirmPaswView extends BaseView {

        //            逻辑判断在P层判断--为了简单一点，扔道Acitivty
        void registerResult(VerfiedBean bean);
    }
    public interface IAffirmPaswMode{
        <T> void forgetPasw(String mobile, String sms_code, String password, INetCallBack<T> iNetCallBack);
    }
    public interface IAffirmPaswPresenter{
        void forgetPasw(String mobile, String sms_code, String password);

    }
}
