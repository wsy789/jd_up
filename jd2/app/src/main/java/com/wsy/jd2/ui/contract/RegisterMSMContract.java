package com.wsy.jd2.ui.contract;

import com.wsy.jd2.base.BaseView;
import com.wsy.jd2.bean.login.VerfiedBean;
import com.wsy.jd2.net.ResultCallBack;

/**
 * 注册获取短信验证码
 */
public class RegisterMSMContract {

        public interface IRegisterMSMView extends BaseView {

            void getVerified(VerfiedBean s);
            void  getLoginResult(String string);
            void checkSmsCodeResult(VerfiedBean verfiedBean);

        }
        public interface IRegisterMSMMode{
            <T> void getVerified(String phoneNum, String type, ResultCallBack<T> iNetCallBack);
            <T> void checkSmsCode(String phoneNum, String smsCode, String type, ResultCallBack<T> iNetCallBack);
        }
        public interface IRegisterMSMPresenter{
            void getVerified(String string, String type);

            void checkSmsCode(String phoneNum, String smsCode, String type);
        }
}
