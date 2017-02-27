package com.mr.mountainrabbit.fragment;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.presenter.impl.RecommendPersenter;

/**
 * Created by BULING on 2017/2/17.
 */

public class RecommendFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private RecommendPersenter persenter;
    private Context context;
    private int WindousHight;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recommend_fragment, null);
        getWindousWidth();
        mRecyclerView= (RecyclerView) view.findViewById(R.id.mRecommend_RefreshRecyclerView);
        persenter=new RecommendPersenter(WindousHight,getActivity(),mRecyclerView);
        persenter.getData();
        return view;
    }
    //获得屏幕宽度
    private void getWindousWidth() {
        DisplayMetrics mDisplayMetrics=new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        WindousHight=mDisplayMetrics.widthPixels;
    }

}
