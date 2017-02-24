package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lidroid.xutils.BitmapUtils;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.*;
import com.mr.mountainrabbit.bean.Drama;

import java.util.ArrayList;
import java.util.List;

/**
 * 番剧页面的第一个适配器，也就是头的适配器
 */

public class DramaFirst extends RecyclerView.Adapter{
    Context context;
    List<com.mr.mountainrabbit.bean.Drama> list;

    public DramaFirst(Context context, List list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.drama_first,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        BitmapUtils bitmapUtils = new BitmapUtils(context);
        ViewHolder holder1 = (ViewHolder) holder;

        Drama drama1 = list.get(0);
        DramaMessage message1 = drama1.getList().get(0);
        bitmapUtils.display(holder1.firstImg,message1.getImage());


        Drama drama2 = list.get(1);

        DramaMessage message2 = drama2.getList().get(0);
        bitmapUtils.display(holder1.img1,message2.getImage());
        holder1.text1.setText(message2.getTitle());

        DramaMessage message3 = drama2.getList().get(1);
        bitmapUtils.display(holder1.img2,message3.getImage());
        holder1.text2.setText(message3.getTitle());

        DramaMessage message4 = drama2.getList().get(2);
        bitmapUtils.display(holder1.img3,message4.getImage());
        holder1.text3.setText(message4.getTitle());

        DramaMessage message5 = drama2.getList().get(3);
        bitmapUtils.display(holder1.img4,message5.getImage());
        holder1.text4.setText(message5.getTitle());


        Drama drama3 = list.get(2);
        List<DramaMessage> data = drama3.getList();
        bitmapUtils.display(holder1.titleImg,drama3.getImage());
        holder1.titleText.setText(drama3.getName());
        holder1.recyclerView.setLayoutManager(new GridLayoutManager(context,3));
        holder1.recyclerView.setAdapter(new DramaFirstRecycleview(context,data));
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    private class ViewHolder extends RecyclerView.ViewHolder{
        RecyclerView recyclerView;
        //顶上第一张图片
        ImageView firstImg;
        //目录模块控件
        ImageView img1;
        ImageView img2;
        ImageView img3;
        ImageView img4;
        //目录模块的文本控件
        TextView text1;
        TextView text2;
        TextView text3;
        TextView text4;
        //第一个模块题目图片
        ImageView titleImg;
        //第一个模块题目文本
        TextView titleText;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.drama_first_recycleview);
            firstImg = (ImageView) itemView.findViewById(R.id.drama_first_image);
            img1 = (ImageView) itemView.findViewById(R.id.drama_menu_1_image);
            img2 = (ImageView) itemView.findViewById(R.id.drama_menu_2_image);
            img3 = (ImageView) itemView.findViewById(R.id.drama_menu_3_image);
            img4 = (ImageView) itemView.findViewById(R.id.drama_menu_4_image);
            text1 = (TextView) itemView.findViewById(R.id.drama_menu_1_text);
            text2 = (TextView) itemView.findViewById(R.id.drama_menu_2_text);
            text3 = (TextView) itemView.findViewById(R.id.drama_menu_3_text);
            text4 = (TextView) itemView.findViewById(R.id.drama_menu_4_text);
            titleImg = (ImageView) itemView.findViewById(R.id.drama_message_1_image);
            titleText = (TextView) itemView.findViewById(R.id.drama_message_1_text);
        }
    }
}

