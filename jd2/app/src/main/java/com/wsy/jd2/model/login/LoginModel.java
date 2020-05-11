package com.wsy.jd2.model.login;

import android.util.Log;

import com.wsy.jd2.base.BaseModel;
import com.wsy.jd2.net.NetWorkFactory;
import com.wsy.jd2.net.ParamsUtils;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.net.api.URLConstants;
import com.wsy.jd2.ui.contract.LoginContract;

import java.util.HashMap;

public class LoginModel extends BaseModel implements LoginContract.ILoginMode {
    //    获取验证码接口   /发送短信验证码
    @Override
    public <T> void getVerified(String phoneNum, String type, ResultCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("type",type);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.SENDVERIFIED,commonParams,iNetCallBack);
    }

    @Override
    public <T> void login(String mobile, String smsCode, ResultCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",mobile);
        commonParams.put("sms_code",smsCode);

        for (String key: commonParams.keySet()) {
            Log.e("TAG_login","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.LOGIN,commonParams,iNetCallBack);
    }


    @Override
    public <T> void checkSmsCode(String phoneNum, String smsCode, String type, ResultCallBack<T> iNetCallBack) {
        Log.e("TAG",phoneNum+"验证m层码值："+smsCode);

        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("type",type);
        commonParams.put("sms_code",smsCode);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().post(URLConstants.CHECKSMSCODE,commonParams,iNetCallBack);
    }
}
