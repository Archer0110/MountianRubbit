package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mr.mountainrabbit.R;

import java.util.List;

/**
 * 娱乐页面的第四个模块的子适配器
 */

public class RacreationForth extends RecyclerView.Adapter {
    List list ;
    Context context;

    public RacreationForth(List list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.racreation_forth,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder holder1 = (viewHolder) holder;
        holder1.recyclerView.setLayoutManager(new GridLayoutManager(context,2,GridLayoutManager.VERTICAL,false));
        holder1.recyclerView.setAdapter(new RacreationForthNew(list));
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    private class viewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        public viewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.racreation_forth);
        }
    }
}
