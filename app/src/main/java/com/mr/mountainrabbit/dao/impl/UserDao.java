package com.mr.mountainrabbit.dao.impl;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
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

    @Override
    public void getSearchOfHot(RequestCallBack<String> callBack) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.configTimeout(5000);
        RequestParams params = new RequestParams();
        params.addHeader("deviceType","1");
        httpUtils.send(HttpRequest.HttpMethod.GET, Util.SearchHotPath,params,callBack);
    }

    /**
     * 所有网络下载所用的方法。
     */
    @Override
    public void getHttpData(RequestParams params,String url, RequestCallBack<String> callBack) {
        HttpUtils utils = new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET,url,params,callBack);
    }

    /**
     * 下载推荐页的数据
     * @param deviceType
     * @param productId
     * @param callBack
     */
    @Override
    public void getRecommendData(String deviceType, String productId, RequestCallBack<String> callBack) {
        RequestParams params=new RequestParams();
        params.addHeader("deviceType",deviceType);
        params.addHeader("productId",productId);
        params.addHeader("appVersion","4.5.0");
        HttpUtils utils=new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET,"http://api.aixifan.com/regions?belong=0&loadCount=-1",params,callBack);
    }

    @Override
    public void getData(RequestParams params, RequestCallBack<String> callBack) {
        HttpUtils utils=new HttpUtils();
        utils.send(HttpRequest.HttpMethod.GET, Util.BANANANOTICE,params,callBack);
    }

    @Override
    public void downLoadImg(String url, ImageView imageView, Context context ) {
        BitmapUtils utils=new BitmapUtils(context);
        utils.display(imageView,url);
        // utils.configDefaultLoadingImage(R.drawable.loading);
        //   utils.configDefaultLoadFailedImage(R.drawable.defeated);
    }

    /**
     * 获取用户搜索下来的数据
     * @param data
     */
    @Override
    public void getUserScannerData(String data,RequestCallBack<String> callBack) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.configTimeout(5000);
        RequestParams params = new RequestParams();
        params.addHeader("deviceType","1");
        httpUtils.send(HttpRequest.HttpMethod.GET, Util.UserSearch + data, params,callBack);
    }
}
