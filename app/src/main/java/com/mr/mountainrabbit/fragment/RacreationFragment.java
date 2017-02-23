package com.mr.mountainrabbit.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.adapter.Racreation;
import com.mr.mountainrabbit.adapter.RacreationFirst;
import com.mr.mountainrabbit.adapter.RacreationForth;
import com.mr.mountainrabbit.adapter.RacreationSecond;
import com.mr.mountainrabbit.adapter.RacreationThird;

import java.util.ArrayList;
import java.util.List;

/**
 * 娱乐模块的碎片
 */

public class RacreationFragment extends Fragment{
    RecyclerView recyclerView;
    List<RecyclerView.Adapter> list = new ArrayList<>();
    List data = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recreation_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.racreation_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerView.Adapter adapter1 = new RacreationFirst(data,getActivity());
        RecyclerView.Adapter adapter2 = new RacreationSecond(data);
        RecyclerView.Adapter adapter3 = new RacreationThird(data);
        RecyclerView.Adapter adapter4 = new RacreationForth(data);
        list.add(adapter1);
        list.add(adapter2);
        list.add(adapter3);
        list.add(adapter4);
        recyclerView.setAdapter(new Racreation(list,getActivity()));

        return view;
    }
}
