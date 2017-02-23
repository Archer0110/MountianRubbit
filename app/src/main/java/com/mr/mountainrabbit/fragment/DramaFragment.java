package com.mr.mountainrabbit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.adapter.Drama;
import com.mr.mountainrabbit.adapter.DramaFirst;
import com.mr.mountainrabbit.adapter.DramaSecond;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * 番剧碎片
 */

public class DramaFragment extends Fragment {
    RecyclerView mRecycleview;
    RecyclerView.Adapter adapter1;
    RecyclerView.Adapter adapter2;
    List list = new ArrayList();
    List data = new ArrayList();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.drama_fragment,null);
        com.lidroid.xutils.ViewUtils.inject(view);
        mRecycleview = (RecyclerView) view.findViewById(R.id.drama_recycleview);
        adapter1 = new DramaFirst(getActivity(),data);
        adapter2 = new DramaSecond(getActivity(),data);
        list.add(adapter1);
        list.add(adapter2);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        mRecycleview.setLayoutManager(manager);
        mRecycleview.setAdapter(new Drama(getActivity(),list));
        return view;
    }
}

