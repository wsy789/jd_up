package com.wsy.jd2.ui.contract;

import com.wsy.jd2.base.BaseView;
import com.wsy.jd2.bean.login.AffirmRegisterBean;
import com.wsy.jd2.net.ResultCallBack;

/**
 * 注册获取短信验证码
 */
public class AffirmContract {

        public interface IAffirmView extends BaseView {
            void registerResult(AffirmRegisterBean registerBean);
        }
        public interface IAffirmMode{
            <T> void register(String phoneNum, String password, String affirm_password, ResultCallBack<T> iNetCallBack);
        }
        public interface IAffirmPresenter{
            void register(String phoneNum, String password, String affirm_password);

        }
}
