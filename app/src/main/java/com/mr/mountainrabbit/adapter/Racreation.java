package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.mountainrabbit.R;

import java.util.List;

/**
 * 娱乐页面的主适配器
 */

public class Racreation extends RecyclerView.Adapter {
    List<RecyclerView.Adapter> list ;
    Context context;

    public Racreation(List<RecyclerView.Adapter> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.racreation_item,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder holder1 = (viewHolder) holder;
        holder1.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        holder1.recyclerView.setAdapter(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 4;
    }
    class viewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        public viewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.racreation_item);
        }
    }

}
