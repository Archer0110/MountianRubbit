package com.mr.mountainrabbit.view;

/**
 * Created by BULING on 2017/2/23.
 */

public interface ILoginActivityView {
    //关闭页面
    public void closePage();
    //登录成功
    public void loginSuccess();
    //登录失败
    public void loginFail();
    //服务器返回数据问题
    public void backDataFail();
    //存储失败
    public void saveFaile();
    //存储成功
    public void saveSuccess();
}
