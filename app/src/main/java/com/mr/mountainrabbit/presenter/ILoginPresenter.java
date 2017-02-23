package com.mr.mountainrabbit.presenter;

import android.widget.EditText;

/**
 * Created by BULING on 2017/2/23.
 */

public interface ILoginPresenter {
    //点击了返回主界面按钮
    public void jumpTOMain();
    //点击登录按钮
    public void loginIn(EditText userName,EditText userPass);
}
