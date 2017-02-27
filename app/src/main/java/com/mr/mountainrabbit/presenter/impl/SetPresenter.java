package com.mr.mountainrabbit.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.Util;
import com.mr.mountainrabbit.presenter.ISetPresenter;
import com.mr.mountainrabbit.view.ISetActivityView;
import com.mr.mountainrabbit.view.impl.MainActivity;

/**
 * Created by BULING on 2017/2/24.
 */

public class SetPresenter implements ISetPresenter{
    private Context context;
    private ISetActivityView mISetActivityView;

    public SetPresenter(Context context, ISetActivityView mISetActivityView) {
        this.context = context;
        this.mISetActivityView = mISetActivityView;
    }


    @Override
    public void exitSystem() {
        SharedPreferences share = context.getSharedPreferences(Util.MR, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit();
        edit.putInt("result",0);
        edit.putString("nickname","");
        edit.putString("portrait","");
        edit.putString("username","");
        edit.putString("userpass","");
        boolean commit = edit.commit();
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
        mISetActivityView.getOnBackPress();
    }

    @Override
    public void isExit(TextView back_app) {
        SharedPreferences share = context.getSharedPreferences(Util.MR, Context.MODE_PRIVATE);
        int result = share.getInt("result", 0);
        if(result == 1){
            back_app.setVisibility(View.VISIBLE);
            return;
        }
        back_app.setVisibility(View.GONE);
    }
}
