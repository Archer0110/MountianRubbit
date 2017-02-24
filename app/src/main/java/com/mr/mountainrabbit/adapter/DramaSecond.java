package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.*;

import java.util.List;

/**
 * 番剧的第二个子适配器
 */

public class DramaSecond extends RecyclerView.Adapter {
    Context context;
    List list;

    public DramaSecond(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drama_second,null);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        com.mr.mountainrabbit.bean.Drama drama = (com.mr.mountainrabbit.bean.Drama) list.get(position+3);
        BitmapUtils bitmapUtils = new BitmapUtils(context);
        bitmapUtils.display(holder1.img,drama.getImage());
        holder1.text.setText(drama.getName());
        holder1.recyclerView.setLayoutManager(new GridLayoutManager(context,2));
        holder1.recyclerView.setAdapter(new DramaSecondRecycleview(context,drama.getList()));
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        ImageView img;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.drama_second_recycleview);
            img = (ImageView) itemView.findViewById(R.id.drama_second_img);
            text = (TextView) itemView.findViewById(R.id.drama_second_title);
        }
    }
}
