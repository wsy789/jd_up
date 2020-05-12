package com.wf.jd.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wf.jd.R;
import com.wf.jd.base.BaseActivity;
import com.wf.jd.base.BasePresenter;
import com.wf.jd.login.bean.AffirmRegisterBean;
import com.wf.jd.login.contract.PassWordLoginContract;
import com.wf.jd.login.presenter.PassWordLoginPresenter;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PassWordLoginActivity extends BaseActivity<PassWordLoginPresenter> implements PassWordLoginContract.IPassWordLoginView {

    private EditText cell_phone_num;
    private EditText import_pass;


    private TextView forget_pass;//忘记密码按钮


    private Button pass_login;//登录按钮

    private TextView verification_login;//验证码登录按钮

    private TextView go_register;


    @Override
    protected PassWordLoginPresenter initPresenter() {
        return new PassWordLoginPresenter();
    }

    @Override
    public void initView() {
        cell_phone_num = findViewById(R.id.cell_phone_num);
        import_pass = findViewById(R.id.import_pass);

        forget_pass = findViewById(R.id.forget_pass);

        pass_login = findViewById(R.id.pass_login);//登录按钮

        verification_login = findViewById(R.id.verification_login);

        go_register = findViewById(R.id.go_register);//跳转注册按钮

    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {

        forget_pass.setOnClickListener(v -> {

            String phone_str = cell_phone_num.getText().toString().trim();

            if(!TextUtils.isEmpty(phone_str) && isMobileNO(phone_str)){
                Intent it = new Intent(PassWordLoginActivity.this,ForgetPassWordActivity.class);

                it.putExtra("phoneNum",phone_str);
                startActivity(it);
            }

        });//忘记密码
        pass_login.setOnClickListener(v -> {

             String phone_str = cell_phone_num.getText().toString().trim();
             String pass_str= import_pass.getText().toString().trim();


             if (!TextUtils.isEmpty(phone_str) && !TextUtils.isEmpty(pass_str)){
//                 手机号是不是正确得
                 if(isMobileNO(phone_str)){

                     mPresenter.passWordLogin(phone_str,pass_str);


                 }else Toast.makeText(this, "请输入正确得手机号", Toast.LENGTH_SHORT).show();
             }else Toast.makeText(this, "手机号和密码不能为空", Toast.LENGTH_SHORT).show();



        });//登录按钮
        verification_login.setOnClickListener(v -> {});//验证码登录按钮
        go_register.setOnClickListener(v -> {});
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_pasword_login;
    }

    @Override
    public void getPWLoginResult(AffirmRegisterBean bean) {
        if(bean.getCode() ==1){
        }else Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
        
    }

    /**
     * 验证手机号码----工具类
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
//            LOG.error("验证手机号码错误", e);
            Log.e("TAG","手机号错误"+e.getMessage());
            flag = false;
        }
        return flag;
    }

}
