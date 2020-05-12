package com.wsy.jd2.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wf.jd.R;
import com.wf.jd.base.BaseActivity;
import com.wf.jd.base.BasePresenter;
import com.wf.jd.login.bean.AffirmRegisterBean;
import com.wf.jd.login.bean.VerfiedBean;
import com.wf.jd.login.contract.AffirmPassWordContract;
import com.wf.jd.login.contract.ForgetPWContract;
import com.wf.jd.login.presenter.AffirmPaswPresenter;
import com.wf.jd.login.presenter.ForgetPWPresenter;

public class AffirmPassWordActivity extends BaseActivity<AffirmPaswPresenter> implements AffirmPassWordContract.IAffirmPaswView {

    private EditText cell_password;//密码
    
    private EditText affirm_psw;//确认密码
    
    private Button update_but;//完成
    private String phoneNum;
    private String verified_str;
    
    @Override
    protected AffirmPaswPresenter initPresenter() {
        return new AffirmPaswPresenter();
    }

    @Override
    public void initView() {


        Intent intent = getIntent();
        phoneNum = intent.getStringExtra("phoneNum");
        verified_str = intent.getStringExtra("verified_str");

        cell_password = findViewById(R.id.cell_password);
        affirm_psw = findViewById(R.id.affirm_psw);
        update_but = findViewById(R.id.update_but);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {
        update_but.setOnClickListener(v -> {
            String pasw_str = cell_password.getText().toString().trim();
            String apw = affirm_psw.getText().toString().trim();
            
            if(!TextUtils.isEmpty(pasw_str) && !TextUtils.isEmpty(apw)){
//                当前页面只有哦验证码，手机号和密码需要上个页面传递过来
//                phoneNum;
//                private String verified_str;

                if(pasw_str.equals(apw)){
                    mPresenter.forgetPasw(phoneNum,verified_str,pasw_str);
                }


            }else Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
            
            
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_affirmpassword;
    }

    @Override
    public void registerResult(VerfiedBean bean) {

        if(bean.getCode()==1){//短信验证码正确，且密码修改成功
            Intent it = new Intent(AffirmPassWordActivity.this,LoginActivity.class);
            startActivity(it);
        }else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
