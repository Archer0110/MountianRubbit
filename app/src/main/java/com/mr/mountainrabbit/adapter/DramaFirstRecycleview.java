package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.DramaMessage;

import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class DramaFirstRecycleview extends RecyclerView.Adapter {
    Context context;
    List list;

    public DramaFirstRecycleview(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drama_first_recycleview,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder holder1 = (viewHolder) holder;
        DramaMessage message = (DramaMessage) list.get(position);
        BitmapUtils bitmapUtils = new BitmapUtils(context);
        bitmapUtils.display(holder1.img,message.getImage());
        holder1.title.setText(message.getTitle());
        holder1.update.setText(message.getUpdate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView title;
        TextView update;
        public viewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.drama_first_item_img);
            title = (TextView) itemView.findViewById(R.id.drama_first_item_title);
            update = (TextView) itemView.findViewById(R.id.drama_first_item_update);
        }
    }
}
