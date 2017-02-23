package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.mountainrabbit.R;

import java.util.List;

/**
 * 番剧页面的主适配器
 */

public class Drama extends RecyclerView.Adapter {
    Context context;
    List list;

    public Drama(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.drama_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        RecyclerView mRecycleview1 = holder1.recyclerView1;
        mRecycleview1.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        mRecycleview1.setAdapter((RecyclerView.Adapter) list.get(position));
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView1;
        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView1 = (RecyclerView) itemView.findViewById(R.id.drama_item);
        }
    }
}
