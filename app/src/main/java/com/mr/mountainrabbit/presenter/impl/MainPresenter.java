package com.mr.mountainrabbit.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.adapter.TabLayoutAdapter;
import com.mr.mountainrabbit.bean.Util;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;
import com.mr.mountainrabbit.fragment.AttentionFragment;
import com.mr.mountainrabbit.fragment.ChannelFragment;
import com.mr.mountainrabbit.fragment.DramaFragment;
import com.mr.mountainrabbit.fragment.EssayFragment;
import com.mr.mountainrabbit.fragment.RacreationFragment;
import com.mr.mountainrabbit.fragment.RecommendFragment;
import com.mr.mountainrabbit.presenter.IMainPresenter;
import com.mr.mountainrabbit.view.IMainActivityView;
import com.mr.mountainrabbit.view.impl.LoginActivity;
import java.util.ArrayList;
import java.util.List;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by BULING on 2017/2/20.
 * MainActivity的逻辑操作的实现类
 */

public class MainPresenter implements IMainPresenter{
    private List<Fragment> fragmentsList = new ArrayList<>();
    private String[] arrTabTitles;
    private IUserDao mIUserDao = new UserDao();

    private Context context;
    private IMainActivityView mIMainActivityView;

    public MainPresenter(Context context, IMainActivityView mIMainActivityView) {
        this.context = context;
        this.mIMainActivityView = mIMainActivityView;
    }

    /**
     * 给是tablayout的适配器，使其可以实现联动效果
     * @param mViewPager
     * @param mTabLayout
     */
    @Override
    public void setTabLayoutAdapter(ViewPager mViewPager, TabLayout mTabLayout) {
        //设置切换标题栏
        arrTabTitles = context.getResources().getStringArray(R.array.arrTabTitles);
        AttentionFragment af = new AttentionFragment();
        ChannelFragment cf = new ChannelFragment();
        DramaFragment df = new DramaFragment();
        EssayFragment ef = new EssayFragment();
        RacreationFragment rtf = new RacreationFragment();
        RecommendFragment rmf = new RecommendFragment();
        fragmentsList.add(af);
        fragmentsList.add(rmf);
        fragmentsList.add(df);
        fragmentsList.add(rtf);
        fragmentsList.add(ef);
        fragmentsList.add(cf);
        //调用tabLayout的适配器
        TabLayoutAdapter adapter = new TabLayoutAdapter(mIMainActivityView.getFragmentsManager(),fragmentsList,arrTabTitles);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * 跳转到登陆也面
     * @return
     */
    @Override
    public void JumpTOLogin() {
        SharedPreferences share = context.getSharedPreferences(Util.MR, Context.MODE_PRIVATE);
        int result = share.getInt("result", 0);
        if(result == 1){
            return;
        }
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    /**
     * 根据登录成功或者失败的信息显示头部布局的控件的显示与隐藏
     * @param user_name:用户的昵称
     * @param system_member：是否为会员
     * @param user_message：用户消息
     * @param icon_draw：用户头像
     * @param resign_draw：快速注册
     * @param sign_login_draw:签到领香蕉
     * @param banana_yellow:香蕉等级
     * @param banana_orange：香蕉等级
     */
    @Override
    public void LoginInOrOut(TextView user_name, TextView system_member,
                             ImageView user_message, final CircleImageView icon_draw,
                             LinearLayout resign_draw, LinearLayout sign_login_draw,
                             ImageView banana_yellow, ImageView banana_orange) {
        SharedPreferences share = context.getSharedPreferences(Util.MR, Context.MODE_PRIVATE);
        int result = share.getInt("result", 0);
        String portrait = share.getString("portrait", null);
        String nickname = share.getString("nickname", "立即登录");
        if(result == 1){//表示登录成功
            //用户头像设置
            setRoundImageIcon(icon_draw,Util.ICONPICTURE+portrait);
            user_name.setText(nickname);
            system_member.setText("黄金会员");
            user_message.setVisibility(View.VISIBLE);
            resign_draw.setVisibility(View.GONE);
            sign_login_draw.setVisibility(View.VISIBLE);
            banana_yellow.setVisibility(View.VISIBLE);
            banana_orange.setVisibility(View.VISIBLE);

            return;
        }

        user_message.setVisibility(View.GONE);
        resign_draw.setVisibility(View.VISIBLE);
        sign_login_draw.setVisibility(View.GONE);
        banana_yellow.setVisibility(View.GONE);
        banana_orange.setVisibility(View.GONE);
        //用户头像设置
        setRoundImageIcon(icon_draw, Util.ICONPATH);
    }

    /**
     * 设置网络头像的获取
     * @param imageIcon
     * @param uri
     */
    @Override
    public void setRoundImageIcon(CircleImageView imageIcon, String uri) {
        mIUserDao.getIcon(imageIcon,uri,context);
    }

    /**
     * toolbar上的头像展示
     * @param roundIcon
     */
    @Override
    public void isIconToolBar(CircleImageView roundIcon) {
        SharedPreferences share = context.getSharedPreferences(Util.MR, Context.MODE_PRIVATE);
        int result = share.getInt("result", 0);
        String portrait = share.getString("portrait", null);
        if(result == 1){
            setRoundImageIcon(roundIcon,Util.ICONPICTURE+portrait);
            return;
        }
        setRoundImageIcon(roundIcon, Util.ICONPATH);
    }
}
