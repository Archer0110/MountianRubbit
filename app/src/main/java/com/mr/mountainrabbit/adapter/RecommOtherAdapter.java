package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.RecommedOther;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;

import java.util.List;

/**
 * Created by liuha on 2017/2/24.
 */

public class RecommOtherAdapter extends RecyclerView.Adapter<RecommOtherAdapter.ViewHolder> {
    private List<RecommedOther> data;
    private Context context;
    private IUserDao dao=new UserDao();

    public RecommOtherAdapter(List<RecommedOther> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.re_item_style1,null,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecommedOther other=data.get(position);
        dao.downLoadImg(other.getImage(),holder.style1_img,context);
        int views = other.getViews();
        if(views>10000){
            holder.style1_read.setText(views/10000+"");
        }else {
            holder.style1_read.setText(views+"");
        }
        holder.style1_comment.setText(other.getDanmakuSize()+"");
        holder.style1_body.setText(other.getTitle());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView style1_img;
        TextView style1_read;
        TextView style1_comment;
        TextView style1_body;
        public ViewHolder(View itemView) {
            super(itemView);
            style1_img= (ImageView) itemView.findViewById(R.id.style1_img);
            style1_read= (TextView) itemView.findViewById(R.id.style1_read);
            style1_comment= (TextView) itemView.findViewById(R.id.style1_comment);
            style1_body= (TextView) itemView.findViewById(R.id.style1_body);
        }


    }
}
