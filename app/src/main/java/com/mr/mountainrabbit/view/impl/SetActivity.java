package com.mr.mountainrabbit.view.impl;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.presenter.ISetPresenter;
import com.mr.mountainrabbit.presenter.impl.SetPresenter;
import com.mr.mountainrabbit.view.ISetActivityView;

public class SetActivity extends AppCompatActivity implements ISetActivityView{

    @ViewInject(R.id.decoding_Settings)
    private LinearLayout decoding_Settings;
    @ViewInject(R.id.isplay_decoding)
    private LinearLayout isplay_decoding;
    @ViewInject(R.id.barrage_size)
    private LinearLayout barrage_size;
    @ViewInject(R.id.default_clairly)
    private LinearLayout default_clairly;
    @ViewInject(R.id.cache_space)
    private LinearLayout cache_space;
    @ViewInject(R.id.isplay_noline)
    private LinearLayout isplay_noline;
    @ViewInject(R.id.accept_message)
    private LinearLayout accept_message;
    @ViewInject(R.id.download_img)
    private LinearLayout download_img;
    @ViewInject(R.id.essaybody_size)
    private LinearLayout essaybody_size;
    @ViewInject(R.id.back_default)
    private LinearLayout back_default;
    @ViewInject(R.id.check_update)
    private LinearLayout check_update;
    @ViewInject(R.id.forus)
    private LinearLayout forus;
    @ViewInject(R.id.back_app)
    private TextView back_app;

    private ISetPresenter mISetPresenter = new SetPresenter(this,this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        ViewUtils.inject(this);
        initData();
        setListener();
    }

    /**
     * 初始化的工作
     */
    private void initData() {
        mISetPresenter.isExit(back_app);
    }

    /**
     * 设置设置页面的监听
     */
    private void setListener() {
        decoding_Settings.setOnClickListener(new ClickListener());
        isplay_decoding.setOnClickListener(new ClickListener());
        barrage_size.setOnClickListener(new ClickListener());
        default_clairly.setOnClickListener(new ClickListener());
        cache_space.setOnClickListener(new ClickListener());
        isplay_noline.setOnClickListener(new ClickListener());
        accept_message.setOnClickListener(new ClickListener());
        download_img.setOnClickListener(new ClickListener());
        essaybody_size.setOnClickListener(new ClickListener());
        back_default.setOnClickListener(new ClickListener());
        check_update.setOnClickListener(new ClickListener());
        forus.setOnClickListener(new ClickListener());
        back_app.setOnClickListener(new ClickListener());
    }

    /**
     * 点击弹出对话框
     */
    public void breakDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.custom_decoding, null);
        builder.setView(view);
        builder.create().show();
        RadioGroup gr_decoding = (RadioGroup) view.findViewById(R.id.gr_decoding);
        TextView sure_decoding = (TextView) view.findViewById(R.id.sure_decoding);
        RadioButton soft_decoding = (RadioButton) view.findViewById(R.id.soft_decoding);
        //设置播放设置弹出框里面的监听
        sure_decoding.setOnClickListener(new ClickListener());
        gr_decoding.setOnCheckedChangeListener(new onChackChange());

    }

    @Override
    public void getOnBackPress() {
        onBackPressed();
    }


    /**
     * 自己写一个类实现了单选按钮的事件的监听
     */
    class onChackChange implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.system_decoding://点击了系统硬解

                    break;
                case R.id.soft_decoding://点击了软件解码
                    break;
            }
        }
    }


    /**
     * 自己写的类实现了点击事件的监听
     */
    class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.decoding_Settings://解码设置
                    breakDialog();
                    break;
                case R.id.isplay_decoding://允许在移动网络下播放

                    break;
                case R.id.barrage_size://弹幕大小

                    break;
                case R.id.default_clairly://默认离线清晰度

                    break;
                case R.id.cache_space://缓存空间

                    break;
                case R.id.isplay_noline://允许在移动网络下缓存

                    break;
                case R.id.accept_message://接收新消息通知

                    break;
                case R.id.download_img://移动网络下加载图片

                    break;
                case R.id.essaybody_size://文章正文字号

                    break;
                case R.id.back_default://恢复默认设置

                    break;
                case R.id.check_update://检查更新

                    break;
                case R.id.forus://关于我们

                    break;
                case R.id.back_app://退出系统
                    mISetPresenter.exitSystem();
                    break;
                case R.id.sure_decoding://点击了弹出框的确定按钮

                    break;

            }
        }

    }



}
