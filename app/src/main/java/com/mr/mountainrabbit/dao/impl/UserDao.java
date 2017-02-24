package com.mr.mountainrabbit.dao.impl;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.mr.mountainrabbit.bean.Util;
import com.mr.mountainrabbit.dao.IUserDao;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BULING on 2017/2/21.
 */

public class UserDao implements IUserDao{
    /**
     * 下载设置网络头像
     * @param imageView
     * @param uri
     */
    @Override
    public void getIcon(CircleImageView imageView, String uri, Context context) {
        BitmapUtils mBitmapUtils = new BitmapUtils(context);
        mBitmapUtils.display(imageView,uri);
    }

    @Override
    public void login(String userName, String userPass, RequestCallBack<String> callBack) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.configTimeout(5000);
        RequestParams params = new RequestParams();
        params.addBodyParameter("username",userName);
        params.addBodyParameter("password",userPass);
        httpUtils.send(HttpRequest.HttpMethod.POST, Util.LOGINPATH,params,callBack);
    }


}
