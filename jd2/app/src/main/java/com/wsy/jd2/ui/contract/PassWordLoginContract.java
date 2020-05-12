package com.wf.jd.login.contract;

import com.wf.jd.base.BaseView;
import com.wf.jd.login.bean.AffirmRegisterBean;
import com.wf.jd.login.bean.VerfiedBean;
import com.wf.jd.net.INetCallBack;

/**
 * 契约类
 * 契约     约定
 */
public class PassWordLoginContract {

        public interface IPassWordLoginView extends BaseView {
            void  getPWLoginResult(AffirmRegisterBean string);
        }
        public interface IPassWordLoginMode{
            <T> void passWordLogin(String username, String password, INetCallBack<T> iNetCallBack);
        }
        public interface IPassWordLoginPresenter{
            void passWordLogin(String username, String password);
        }
}
