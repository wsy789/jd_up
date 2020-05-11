package com.wsy.jd2.model.login;

import android.util.Log;

import com.wsy.jd2.base.BaseModel;
import com.wsy.jd2.net.NetWorkFactory;
import com.wsy.jd2.net.ParamsUtils;
import com.wsy.jd2.net.ResultCallBack;
import com.wsy.jd2.net.api.URLConstants;
import com.wsy.jd2.ui.contract.AffirmContract;

import java.util.HashMap;

public class AffirmRegisterModel extends BaseModel implements AffirmContract.IAffirmMode {
    @Override
    public <T> void register(String phoneNum, String password, String affirm_password, ResultCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("password",password);
        commonParams.put("affirm_password",affirm_password);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.USERREGISTER,commonParams,iNetCallBack);


    }
}
