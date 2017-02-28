package com.mr.mountainrabbit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.presenter.IChannelPersenter;
import com.mr.mountainrabbit.presenter.impl.ChabbelPersenter;

/**
 * Created by BULING on 2017/2/17.
 */

public class ChannelFragment extends Fragment{
    private RecyclerView mRecyclerView;
    private IChannelPersenter persenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.channel_fragment, null);
        mRecyclerView= (RecyclerView) view.findViewById(R.id.mChannelRecycleView);
        persenter=new ChabbelPersenter(getActivity(),mRecyclerView);
        persenter.setData();
        return view;
    }
}
