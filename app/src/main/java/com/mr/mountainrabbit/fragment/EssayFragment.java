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
import com.mr.mountainrabbit.adapter.Essay;
import com.mr.mountainrabbit.adapter.EssayFirst;
import com.mr.mountainrabbit.adapter.EssaySecond;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BULING on 2017/2/17.
 */

public class EssayFragment extends Fragment{
    RecyclerView recyclerView ;
    List<RecyclerView.Adapter> list = new ArrayList<>();
    List data = new ArrayList();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.essay_fragment, null);
        recyclerView = (RecyclerView) view.findViewById(R.id.essay_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.add(new EssayFirst(data,getActivity()));
        list.add(new EssaySecond(getActivity(),data));
        recyclerView.setAdapter(new Essay(getActivity(),list));
        return view;
    }
}
