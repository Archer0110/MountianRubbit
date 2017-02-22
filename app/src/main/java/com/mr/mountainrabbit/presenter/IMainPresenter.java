package com.mr.mountainrabbit.presenter;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by BULING on 2017/2/20.
 * MainActivity的逻辑操作
 */

public interface IMainPresenter {
    //设置TabLayout的适配器
    public void setTabLayoutAdapter(ViewPager mViewPager, TabLayout mTabLayout);
    //跳转到登录页面
    public void JumpTOLogin();
    //根据登录成功或者失败的信息显示头部布局的控件的显示与隐藏
    public void LoginInOrOut(Boolean islogin, TextView user_name, TextView system_member, ImageView user_message, CircleImageView icon_draw, LinearLayout resign_draw, LinearLayout sign_login_draw, ImageView banana_yellow, ImageView banana_orange);
    //设置头像图片--网络获取
    public void setRoundImageIcon(CircleImageView imageIcon,String uri);
}
