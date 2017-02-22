package com.mr.mountainrabbit.dao.impl;

import android.content.Context;

import com.lidroid.xutils.BitmapUtils;
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
}
