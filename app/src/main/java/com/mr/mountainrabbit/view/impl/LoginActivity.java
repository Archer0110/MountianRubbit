package com.mr.mountainrabbit.view.impl;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.presenter.ILoginPresenter;
import com.mr.mountainrabbit.presenter.impl.LoginPresenter;
import com.mr.mountainrabbit.view.ILoginActivityView;

public class LoginActivity extends AppCompatActivity implements ILoginActivityView{
    @ViewInject(R.id.back_main)
    private ImageView back_main;
    @ViewInject(R.id.login_userName)
    private EditText login_userName;
    @ViewInject(R.id.login_userPass)
    private EditText login_userPass;
    @ViewInject(R.id.login_login)
    private Button login_login;
    @ViewInject(R.id.login_resign)
    private TextView login_resign;
    @ViewInject(R.id.login_forgetPass)
    private TextView login_forgetPass;

    private ILoginPresenter mILoginPresenter = new LoginPresenter(this,this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ViewUtils.inject(this);
        setListener();
    }

    /**
     *实现监听
     */
    private void setListener() {
        back_main.setOnClickListener(new ClickListener());
        login_login.setOnClickListener(new ClickListener());
        login_resign.setOnClickListener(new ClickListener());
        login_forgetPass.setOnClickListener(new ClickListener());
    }

    @Override
    public void closePage() {
        finish();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFail() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void backDataFail() {
        Toast.makeText(this,"服务器努力加载中...",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveFaile() {
        Toast.makeText(this,"存储失败，联系客服妹妹~",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void saveSuccess() {
        Toast.makeText(this,"存储成功",Toast.LENGTH_SHORT).show();
    }

    /**
     * 自己写一个类实现控件的点击监听
     */
    public class ClickListener implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back_main://返回主界面
                    mILoginPresenter.jumpTOMain();
                    break;
                case R.id.login_login://点击登陆
                    mILoginPresenter.loginIn(login_userName,login_userPass);
                    break;
                case R.id.login_resign://点击快速注册
                    break;
                case R.id.login_forgetPass://点击忘记密码
                    break;


            }
        }
    }

}
