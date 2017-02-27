package com.mr.mountainrabbit.dao;

import android.content.Context;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;

import com.lidroid.xutils.http.RequestParams;

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

    /**
     * 所有网络下载所用的方法。
     */
    public void getHttpData(RequestParams params,String url, RequestCallBack<String> callBack);


    public  void getRecommendData(String deviceType , String productId , RequestCallBack<String> callBack);

    public void  getData(RequestParams params,RequestCallBack<String> callBack);

    public void downLoadImg(String url, ImageView imageView, Context context );
}
