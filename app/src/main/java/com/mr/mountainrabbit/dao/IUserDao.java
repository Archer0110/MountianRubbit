package com.mr.mountainrabbit.dao;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.http.callback.RequestCallBack;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BULING on 2017/2/21.
 * 用户信息的数据网络层
 */

public interface IUserDao {
    //得到用户头像图片
    public void getIcon(CircleImageView imageView, String uri, Context context);
    //登录
    public void login(String userName, String userPass, RequestCallBack<String> callBack);
    //获取搜索页面的热搜
    public void getSearchOfHot(RequestCallBack<String> callBack);
}
