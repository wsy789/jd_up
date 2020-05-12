package com.wsy.jd2.model.login;

import android.util.Log;

import com.wf.jd.login.contract.ForgetPWContract;
import com.wf.jd.net.INetCallBack;
import com.wf.jd.net.NetWorkFactory;
import com.wf.jd.net.ParamsUtils;
import com.wf.jd.net.api.URLConstants;

import java.util.HashMap;

public class ForgetPWModel implements ForgetPWContract.IForgetPWMode{
    @Override
    public <T> void getVerified(String phoneNum, String type, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("type",type);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }

        NetWorkFactory.getInstance().getNetWork().post(URLConstants.SENDVERIFIED,commonParams,iNetCallBack);

    }

    @Override
    public <T> void checkSmsCode(String phoneNum, String smsCode, String type, INetCallBack<T> iNetCallBack) {
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
