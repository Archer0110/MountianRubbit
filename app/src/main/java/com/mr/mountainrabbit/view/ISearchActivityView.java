package com.mr.mountainrabbit.view;

import android.view.LayoutInflater;

/**
 * Created by BULING on 2017/2/25.
 */

public interface ISearchActivityView {
    //获取布局管理加载器
    public LayoutInflater getInflater();
    //结束本页面
    public void finishPage();
    //服务器请求失败
    public void requestFail();
}
