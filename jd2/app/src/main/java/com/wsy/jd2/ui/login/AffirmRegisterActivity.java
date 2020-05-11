package com.wsy.jd2.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseActivity;
import com.wsy.jd2.bean.login.AffirmRegisterBean;
import com.wsy.jd2.presenter.login.AffirmRegisterPresenter;
import com.wsy.jd2.ui.contract.AffirmContract;
import com.wsy.jd2.ui.main.MainActivity;
import com.wsy.jd2.util.ToastUtil;

/**
 * 确认注册
 */
public class AffirmRegisterActivity extends BaseActivity<AffirmRegisterPresenter> implements AffirmContract.IAffirmView {

    private EditText affreg_passward;
    private EditText affreg_affirmpassword;
    private Button arrirm_regbug;
    private String phoneNum;

    @Override
    protected AffirmRegisterPresenter initPresenter() {
        return new AffirmRegisterPresenter();
    }

    @Override
    public void initView() {

          affreg_passward = findViewById(R.id.affreg_passward);
          affreg_affirmpassword = findViewById(R.id.affreg_affirmpassword);
          arrirm_regbug  = findViewById(R.id.arrirm_regbug);
          initListener();
    }

    @Override
    protected void initDate() {
//获取传过来的手机号
        Intent intent = getIntent();
        phoneNum = intent.getStringExtra("phoneNum");
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_register_affirm;
    }

    //todo 调用注册接口
    private void initListener() {
        arrirm_regbug.setOnClickListener(v -> {
//            判断两个密码是否为空，是否相同，如果相同，调用注册接口
//            判断密码长度是否大于6位，两次密码输入是否相同
//            如果是，调用接口
            String passW = affreg_passward.getText().toString().trim();
            String affirmPass = affreg_affirmpassword.getText().toString().trim();
            // 判断两个密码是否为空，
            if(!TextUtils.isEmpty(passW) && !TextUtils.isEmpty(affirmPass)){
                //判断两个密码是否相同
                if(passW.equals(affirmPass)){
                    mPresenter.register(phoneNum,passW,affirmPass);
                }
            }else {
                ToastUtil.showToastShort("密码不能为空");
            }
        });
    }
    @Override
    public void registerResult(AffirmRegisterBean registerBean) {

        Log.e("TAG","注册成功返回值="+registerBean.toString());
        if(registerBean.getCode().equals("1")){
            ToastUtil.showToastShort( "注册成功返回数据，且code等于1");
            //token不等于空
            String value = registerBean.getData().getToken().getValue();
            if(null !=value &&value!="" ){
                Intent it = new Intent(AffirmRegisterActivity.this, MainActivity.class);
                startActivity(it);
            }

        }else {
            ToastUtil.showToastShort( registerBean.getMessage());
        }

    }
}
