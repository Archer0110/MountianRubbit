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
 * 番剧页面第二个模块的适配器的子适配器
 */

public class DramaSecondRecycleview extends RecyclerView.Adapter {
    Context context;
    List list;

    public DramaSecondRecycleview(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drama_second_recycleview,null);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder holder1 = (viewHolder) holder;
        DramaMessage  message = (DramaMessage) list.get(position);
        holder1.comments.setText(message.getComments());
        String s = message.getRead();
        int a = Integer.parseInt(s);
        if(a>=10000){
            a = a/10000;
            holder1.views.setText(a+"万");
        }else{
            holder1.views.setText(message.getRead());
        }
        holder1.title.setText(message.getTitle());
        BitmapUtils bitmapUtils = new BitmapUtils(context);
        bitmapUtils.display(holder1.img,message.getImage());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView views;
        TextView comments;
        ImageView img;
        public viewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.drama_second_item_title);
            views = (TextView) itemView.findViewById(R.id.drama_second_item_views);
            comments = (TextView) itemView.findViewById(R.id.drama_second_item_comments);
            img = (ImageView) itemView.findViewById(R.id.drama_second_item_img);
            }
    }
}
