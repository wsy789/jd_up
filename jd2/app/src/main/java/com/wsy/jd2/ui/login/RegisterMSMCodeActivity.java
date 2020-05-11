package com.wsy.jd2.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseActivity;
import com.wsy.jd2.bean.login.VerfiedBean;
import com.wsy.jd2.presenter.login.RegisterMSMPresenter;
import com.wsy.jd2.ui.contract.RegisterMSMContract;
import com.wsy.jd2.util.ToastUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMSMCodeActivity extends BaseActivity<RegisterMSMPresenter> implements RegisterMSMContract.IRegisterMSMView {

    private EditText reg_phone_num;
    private EditText reg_verfied;
    private Button reg_send_verfied_bug;
    private Button reg_bug;
    private String reg_edit_phone_num;
    private String reg_edit_sms_code;

    @Override
    protected RegisterMSMPresenter initPresenter() {
        return new RegisterMSMPresenter();
    }

    @Override
    public void initView() {
        reg_phone_num = findViewById(R.id.affreg_passward);
        reg_verfied= findViewById(R.id.affreg_affirmpassword);
        reg_send_verfied_bug= findViewById(R.id.send_verfied_bug);
        reg_bug= findViewById(R.id.arrirm_regbug);
        initLinstener();
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_smscode_affirm;
    }

    private void initLinstener() {
//        获取验证码
        reg_send_verfied_bug.setOnClickListener(v->{

            String phonenum = reg_phone_num.getText().toString();
            if( !TextUtils.isEmpty(phonenum) && isMobileNO(phonenum)){
//                  表示可以发送验证码  type 1表示注册发送验证码
                mPresenter.getVerified(phonenum,"1");
            }else Toast.makeText(RegisterMSMCodeActivity.this, "请输入正确得手机号", Toast.LENGTH_SHORT).show();
        });


//        注册
        reg_bug.setOnClickListener(v -> {

            reg_edit_phone_num = reg_phone_num.getText().toString();
            reg_edit_sms_code = reg_verfied.getText().toString();

            if(!TextUtils.isEmpty(reg_edit_phone_num) && isMobileNO(reg_edit_phone_num)){

                if (!TextUtils.isEmpty(reg_edit_sms_code)){

                    Pattern pattern = Pattern.compile("\\d{6}");
                    boolean matches = pattern.matcher(reg_edit_sms_code).matches();
                    if(matches){
                        //type 1表示注册发送验证码
                        mPresenter.checkSmsCode(reg_edit_phone_num,reg_edit_sms_code,"1");
                    }
                }
            }
        });
    }



//    验证码返回获取
    @Override
    public void getVerified(VerfiedBean s) {

        if(s.getCode()==1)
            ToastUtil.showToastShort("验证码发送成功");
        else
            ToastUtil.showToastShort("验证码发送失败");

    }

    @Override
    public void getLoginResult(String string) {

    }
//檢查验证码
    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {
        if(verfiedBean.getCode()==1){
//            跳转另一个页面了
            Intent intent = new Intent(this,AffirmRegisterActivity.class);
           //传手机号
            intent.putExtra("phoneNum",reg_edit_phone_num);
            startActivity(intent);
        }
    }


    /**
     * 验证手机号码
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){
//      验证手机号码错误
            Log.e("TAG","手机号错误"+e.getMessage());
            flag = false;
        }
        return flag;
    }

}
