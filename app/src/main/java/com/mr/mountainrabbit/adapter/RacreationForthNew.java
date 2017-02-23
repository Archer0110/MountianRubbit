package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.mountainrabbit.R;

import java.util.List;

/**
 * 娱乐页面第四个模块的子适配器的适配器
 */

public class RacreationForthNew extends RecyclerView.Adapter {
    List list ;
    Context context;

    public RacreationForthNew(List list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.racreation_forth_new,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }
    private class viewHolder extends RecyclerView.ViewHolder{

        public viewHolder(View itemView) {
            super(itemView);
        }
    }
}
