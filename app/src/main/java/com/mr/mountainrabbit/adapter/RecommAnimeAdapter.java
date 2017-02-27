package com.mr.mountainrabbit.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.RecommendAnime;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;

import java.util.List;

/**
 * Created by liuha on 2017/2/24.
 */

public class RecommAnimeAdapter extends RecyclerView.Adapter<RecommAnimeAdapter.AnimeHolder>{
    private List<RecommendAnime> data;
    private Context context;
    private IUserDao dao=new UserDao();
    private int WindousHight;

    public RecommAnimeAdapter(List<RecommendAnime> data, Context context, int windousHight) {
        this.data = data;
        this.context = context;
        WindousHight = windousHight;
    }

    @Override
    public AnimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.re_item_style3,null,false);
       //view.setLayoutParams(new RecyclerView.LayoutParams(WindousHight,100));
        AnimeHolder holder=new AnimeHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(AnimeHolder holder, int position) {
        RecommendAnime anime=data.get(position);
        dao.downLoadImg(anime.getImage(),holder.style3_img,context);
        holder.style3_body.setText(anime.getTitle());
        holder.style3_other.setText("更新至"+anime.getAnimeMessage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class  AnimeHolder extends RecyclerView.ViewHolder{
        ImageView style3_img;
        TextView style3_body;
        TextView style3_other;
        public AnimeHolder(View itemView) {
            super(itemView);
            style3_img= (ImageView) itemView.findViewById(R.id.style3_img);
            style3_body= (TextView) itemView.findViewById(R.id.style3_body);
            style3_other= (TextView) itemView.findViewById(R.id.style3_other);
        }
    }

}