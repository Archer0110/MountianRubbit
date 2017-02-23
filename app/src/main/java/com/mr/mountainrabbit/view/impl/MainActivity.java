package com.mr.mountainrabbit.view.impl;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.Util;
import com.mr.mountainrabbit.presenter.IMainPresenter;
import com.mr.mountainrabbit.presenter.impl.MainPresenter;
import com.mr.mountainrabbit.view.IMainActivityView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 这是主界面
 * 所有用XUtils来写
 *
 */

public class MainActivity extends AppCompatActivity implements IMainActivityView{

    @ViewInject(R.id.toolbar)
    private Toolbar toolbar;
    @ViewInject(R.id.drawLayout)
    private DrawerLayout drawLayout;
    @ViewInject(R.id.tabLayout_main)
    private TabLayout tabLayout_main;
    @ViewInject(R.id.viewPager_main)
    private ViewPager viewPager_main;
    @ViewInject(R.id.nv_draw)
    private NavigationView nv_draw;


    private IMainPresenter mIMainPresenter = new MainPresenter(this,this);

    private TextView user_name;
    private TextView system_member;
    private ImageView user_message;
    private CircleImageView icon_draw;
    private LinearLayout resign_draw;
    private LinearLayout sign_login_draw;
    private ImageView banana_yellow;
    private ImageView banana_orange;
    private CircleImageView roundIcon;
    private ImageView open_draw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //给注解做解释
        ViewUtils.inject(this);
        findView();
        setInitData();
        setListener();

    }

    /**
     * 找Navigation的头部控件
     */
    private void findView() {
        //菜单栏上的头像图片
        roundIcon = (CircleImageView) findViewById(R.id.roundIcon);
        open_draw = (ImageView) findViewById(R.id.open_draw);

        View view = nv_draw.inflateHeaderView(R.layout.nv_head_draw);
        //用户姓名文本框
        user_name = (TextView) view.findViewById(R.id.user_name);
        //是否是会员文本框
        system_member = (TextView) view.findViewById(R.id.system_member);
        //用户消息图片
        user_message = (ImageView) view.findViewById(R.id.user_message);
        //用户头像图片
        icon_draw = (CircleImageView) view.findViewById(R.id.icon_draw);
        //香蕉等级
        banana_yellow = (ImageView) view.findViewById(R.id.banana_yellow);
        //香蕉等级
        banana_orange = (ImageView) view.findViewById(R.id.banana_orange);
        //快速注册
        resign_draw = (LinearLayout) view.findViewById(R.id.resign_draw);
        //签到领香蕉
        sign_login_draw = (LinearLayout) view.findViewById(R.id.sign_login_draw);

    }

    /**
     * 设置初始化数据
     */
    private void setInitData() {
        //去掉标题栏
        toolbar.setTitle("");
        //用户头像设置
        mIMainPresenter.isIconToolBar(roundIcon);
        //设置当前Activity支持ToolBar
        setSupportActionBar(toolbar);
        //调用方法设置适配器
        mIMainPresenter.setTabLayoutAdapter(viewPager_main,tabLayout_main);
        //设置抽屉的宽度
        ViewGroup.LayoutParams params = nv_draw.getLayoutParams();
        params.width = getResources().getDisplayMetrics().widthPixels/4*3;
        nv_draw.setLayoutParams(params);
        //设置侧滑头部的隐藏与显
        mIMainPresenter.LoginInOrOut(user_name,system_member,user_message,icon_draw,resign_draw,sign_login_draw,banana_yellow,banana_orange);
    }

    /**
     * 设置监听
     */
    private void setListener() {
        //设置侧滑抽屉的点击事件
        NavigationListener mNavigationListener = new NavigationListener();
        nv_draw.setNavigationItemSelectedListener(mNavigationListener);
        //设置头部的点击事件
        HeadClick mHeadClick = new HeadClick();
        user_message.setOnClickListener(mHeadClick);
        icon_draw.setOnClickListener(mHeadClick);
        resign_draw.setOnClickListener(mHeadClick);
        //设置ToolBar上头像的监听
        roundIcon.setOnClickListener(mHeadClick);
    }


    @Override
    public void onBackPressed() {
        finish();
    }

    /**
     * 加载菜单
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }


    /**
     * 菜单监听
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.game_menu://点击了游戏

                break;
            case R.id.download_menu://点击了下载

                break;
            case R.id.history_menu://点击了查看历史

                break;
            case R.id.search_menu://点击了搜索

                break;

        }
        return true;
    }

    /**
     * 获取碎片管理加载器
     */
    @Override
    public FragmentManager getFragmentsManager() {
        return getSupportFragmentManager();
    }


    /**
     * 自己定义的类实现了侧滑抽屉菜单的监听接口
     */
    private class NavigationListener implements NavigationView.OnNavigationItemSelectedListener {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            switch (id){
                case R.id.history_draw://点击了历史记录

                    break;
                case R.id.download_draw://点击了离线缓存

                    break;
                case R.id.fans://点击关注和粉丝粉丝

                    break;
                case R.id.collect://点击了我的收藏

                    break;
                case R.id.contribute://点击了我的投稿

                    break;
                case R.id.set://点击了设置

                    break;
                case R.id.game_draw://点击了游戏中心

                    break;
                case R.id.idea://点击了意见反馈

                    break;
            }
            return true;
        }
    }

    /**
     * 自己定义的类实现头部的点击事件
     */
    private class HeadClick implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.user_message://点击了查看消息

                    break;
                case R.id.icon_draw://点击了头像选择登录
                    mIMainPresenter.JumpTOLogin();    //跳转到登录页面
                    break;
                case R.id.resign_draw://点击了快速注册

                    break;
                case R.id.sign_login_draw://点击了签到领香蕉
                    break;

                case R.id.roundIcon://点击展开抽屉
                    drawLayout.openDrawer(GravityCompat.START);
                    break;
                case R.id.open_draw://点击旁边3个点打开抽屉
                    drawLayout.openDrawer(GravityCompat.START);
                    break;
            }
        }
    }

}
