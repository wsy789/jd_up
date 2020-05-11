package com.wsy.jd2.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wsy.jd2.R;
import com.wsy.jd2.base.BaseActivity;
import com.wsy.jd2.bean.login.VerfiedBean;
import com.wsy.jd2.presenter.login.LoginPresenter;
import com.wsy.jd2.ui.contract.LoginContract;
import com.wsy.jd2.util.ToastUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {


    private EditText phone_num;
    private EditText verfied;
    private Button send_verfied_bug;
    private Button login;


    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void initView() {
        phone_num = findViewById(R.id.mine_register_phone);
        verfied = findViewById(R.id.mine_register_code);
        send_verfied_bug = findViewById(R.id.send_verfied_bug);
        login = findViewById(R.id.mine_register_bt);
        initLinstener();
    }

    @Override
    protected void initDate() {

    }

    @Override
    protected int getLayout() {
        return R.layout.activity_login1;
    }


    private String edit_phone_num;
    private String edit_sms_code;

    private void initLinstener() {

// 发送验证码
        send_verfied_bug.setOnClickListener(v -> {
//判断咱们手机号是否为空，判断手机号是否正确，发送咱们验证码
            String phonenum = phone_num.getText().toString();
            if (!TextUtils.isEmpty(phonenum) && isMobileNO(phonenum)) {
// 表示可以发送验证码  type 4表示登录发送验证码
                mPresenter.getVerified(phonenum, "4");
            } else {
                ToastUtil.showToastShort("请输入正确得手机号");

            }
        });

//登录
        login.setOnClickListener(v -> {
            Log.i("TAG", "initLinstener: ——点击登录");
            edit_phone_num = phone_num.getText().toString();
            edit_sms_code = verfied.getText().toString();
            if (!TextUtils.isEmpty(edit_phone_num) && isMobileNO(edit_phone_num)) {
                if (!TextUtils.isEmpty(edit_sms_code)) {
// 需要用正则表达式判断验证码是否是6位，且都是数字
                    Pattern pattern = Pattern.compile("\\d{6}");
                    boolean matches = pattern.matcher(edit_sms_code).matches();
                    if (matches) {
                        Log.e("TAG", edit_phone_num + "验证码值：" + edit_sms_code);
                        // 判断你得手机号，和你发送得验证码是否正确，如果正确，调用登录接口
                    // 提交服务器进行判断
                        mPresenter.checkSmsCode(edit_phone_num, edit_sms_code, "4");
// 服务器给我们下发得验证码短信，接收手机号给他，验证码也给他，
// 如果不正确，提示用户
                    } else {
                        ToastUtil.showToastShort("验证码输入错误");
                    }
                } else {
                    ToastUtil.showToastShort("请输入验证码");
                }
            } else {
                ToastUtil.showToastShort("请输入正确得手机号");
            }
        });

    }

    //  是否发送了短信验证码，返回
    @Override
    public void getVerified(VerfiedBean s) {
        if (s.getCode() == 1) {
            ToastUtil.showToastShort("成功");

        } else {
            ToastUtil.showToastShort("错误");
        }
    }


    /**
     * 先不去登录 ,获取验证码以后，
     * 判断验证码是否正确
     * 如果正确，在去登录
     *
     * @param string
     */
    @Override
    public void getLoginResult(String string) {
    }

    // 判断去接口验证的验证码是否正确
    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {

        if (verfiedBean.getCode() == 1) {
//            表明验证码正确   电话与验证码匹配
//            自动去登录操作了。
            ToastUtil.showToastShort("验证码输入正确");
            mPresenter.login(edit_phone_num, edit_sms_code);
            startRegister();
        } else{
            ToastUtil.showToastShort("验证码输入错误");
        }


    }

    public void startRegister() {
        Intent intent = new Intent(this, RegisterMSMCodeActivity.class);
        startActivity(intent);
    }

    //验证手机号码
    private boolean isMobileNO(String edit_phone_num) {
        boolean flag = false;
        try {
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
            Matcher m = p.matcher(edit_phone_num);
            flag = m.matches();
        } catch (Exception e) {
//            LOG.error("验证手机号码错误", e);
            Log.e("TAG", "手机号错误" + e.getMessage());
            flag = false;
        }
        return flag;
    }
}
