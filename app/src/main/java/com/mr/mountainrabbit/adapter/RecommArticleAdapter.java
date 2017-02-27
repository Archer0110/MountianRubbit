package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.RecommEdarticle;

import java.util.List;

/**
 * Created by liuha on 2017/2/24.
 */

public class RecommArticleAdapter extends RecyclerView.Adapter<RecommArticleAdapter.ArticleHolder> {
    private List<RecommEdarticle> data;
    private Context context;

    public RecommArticleAdapter(List<RecommEdarticle> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ArticleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.re_item_style4,null,false);
        ArticleHolder holder=new ArticleHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ArticleHolder holder, int position) {
        RecommEdarticle edarticle=data.get(position);
        holder.style4_commite.setText(edarticle.getComments()+"");
        holder.style4_body.setText(edarticle.getTitle());
        holder.style4_readcount.setText(edarticle.getViews()+"");
        holder.style4_userName.setText(edarticle.getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ArticleHolder extends RecyclerView.ViewHolder{
        TextView style4_commite;
        TextView style4_body;
        TextView style4_userName;
        TextView style4_readcount;
        public ArticleHolder(View itemView) {
            super(itemView);
            style4_commite= (TextView) itemView.findViewById(R.id.style4_commite);
            style4_body= (TextView) itemView.findViewById(R.id.style4_body);
            style4_userName= (TextView) itemView.findViewById(R.id.style4_userName);
            style4_readcount= (TextView) itemView.findViewById(R.id.style4_readcount);
        }
    }
}
