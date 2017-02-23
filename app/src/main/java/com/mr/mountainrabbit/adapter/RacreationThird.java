package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.mountainrabbit.R;

import java.util.List;

/**
 * 娱乐页面的第三个模块的子适配器
 */

public class RacreationThird extends RecyclerView.Adapter {
    List list ;
    Context context;

    public RacreationThird(List list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.racreation_third,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
    private class viewHolder extends RecyclerView.ViewHolder{

        public viewHolder(View itemView) {
            super(itemView);
        }
    }
}
