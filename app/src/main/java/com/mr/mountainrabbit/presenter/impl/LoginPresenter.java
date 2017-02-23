package com.mr.mountainrabbit.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.widget.EditText;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.mr.mountainrabbit.bean.Util;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;
import com.mr.mountainrabbit.presenter.ILoginPresenter;
import com.mr.mountainrabbit.view.ILoginActivityView;
import com.mr.mountainrabbit.view.impl.MainActivity;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by BULING on 2017/2/23.
 * 登录界面的逻辑操作
 */

public class LoginPresenter implements ILoginPresenter{
    private Context context;
    private ILoginActivityView mILoginActivityView;

    private IUserDao mIUserDao = new UserDao();

    public LoginPresenter(Context context, ILoginActivityView mILoginActivityView) {
        this.context = context;
        this.mILoginActivityView = mILoginActivityView;
    }

    /**
     * 跳转到主界面
     */
    @Override
    public void jumpTOMain() {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        mILoginActivityView.closePage();
    }

    /**
     * 登录
     * @param userName
     * @param userPass
     */
    @Override
    public void loginIn(EditText userName, EditText userPass) {
        final String username = userName.getText().toString().trim();
        final String userpass = userPass.getText().toString().trim();
        if(TextUtils.isEmpty(username)){//如果用户名为空
            return;
        }
        if(TextUtils.isEmpty(userpass)){//如果密码为空
            return;
        }
        mIUserDao.login(username, userpass, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                //显示登录成功
                String s = responseInfo.result;
                mILoginActivityView.loginSuccess();
                jsonString(s,username,userpass);
                jumpTOMain();
            }
            @Override
            public void onFailure(HttpException error, String msg) {
                mILoginActivityView.loginFail();
            }
        });
    }

    /**
     * 解析服务器返回的json数据
     * @param s
     */
    private void jsonString(String s,String userName,String userPass){
        if (!TextUtils.isEmpty(s)){
            try {
                JSONObject jo = new JSONObject(s);
                int result = jo.getInt("result");
                JSONObject data = jo.getJSONObject("data");
                String nickname = data.getString("nickname");
                String portrait = data.getString("portrait");
                sharePreference(result,nickname,portrait,userName,userPass);
            } catch (JSONException e) {
            }
        }else{//解析JSON数据失败
            mILoginActivityView.backDataFail();
        }
    }

    /**
     * 共享参数存储用户的信息
     */
    private void sharePreference(int result,String nickname,String portrait,String username,String userpass){
        if (TextUtils.isEmpty(nickname) && TextUtils.isEmpty(portrait)){
            //存储失败
            mILoginActivityView.saveFaile();
            return;
        }
        SharedPreferences share = context.getSharedPreferences(Util.MR, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putInt("result",result);
        edit.putString("nickname",nickname);
        edit.putString("portrait",portrait);
        edit.putString("username",username);
        edit.putString("userpass",userpass);
        boolean commit = edit.commit();
        if (commit == false){//存储不成功
            mILoginActivityView.saveFaile();
        }
        //存储成功
        mILoginActivityView.loginSuccess();
    }


}
