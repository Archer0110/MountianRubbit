package com.mr.mountainrabbit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.adapter.DramaFirst;
import com.mr.mountainrabbit.adapter.DramaSecond;
import com.mr.mountainrabbit.presenter.IDramaPresenter;
import com.mr.mountainrabbit.presenter.impl.DramaPresenter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * 番剧碎片
 */

public class DramaFragment extends Fragment {
    RecyclerView mRecycleview;
    IDramaPresenter presenter ;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drama_fragment,null);
        com.lidroid.xutils.ViewUtils.inject(view);
        mRecycleview = (RecyclerView) view.findViewById(R.id.drama_recycleview);
        presenter =  new DramaPresenter(mRecycleview,getActivity());
        presenter.getData();
        return view;
    }
}

