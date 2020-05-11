package com.wsy.jd2.model.login;

import android.util.Log;

import com.wsy.jd2.base.BaseModel;
import com.wsy.jd2.net.NetWorkFactory;
import com.wsy.jd2.net.ParamsUtils;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.net.api.URLConstants;
import com.wsy.jd2.ui.contract.RegisterMSMContract;

import java.util.HashMap;

public class RegisterMSMModel extends BaseModel implements RegisterMSMContract.IRegisterMSMMode {
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
    public <T> void checkSmsCode(String phoneNum, String smsCode, String type, ResultCallBack<T> iNetCallBack) {


        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("type",type);
        commonParams.put("sms_code",smsCode);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        Log.e("TAG", "checkSmsCode:—— checkSmsCode" );
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.CHECKSMSCODE,commonParams,iNetCallBack);


    }
}
