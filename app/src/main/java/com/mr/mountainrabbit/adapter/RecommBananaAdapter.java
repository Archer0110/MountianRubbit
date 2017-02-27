package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.RecommBanana;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;

import java.util.List;

/**
 * Created by liuha on 2017/2/24.
 */

public class RecommBananaAdapter extends RecyclerView.Adapter<RecommBananaAdapter.BananaHOlder> {
    private Context context;
    private List<RecommBanana> data;
    private IUserDao userDao=new UserDao();

    public RecommBananaAdapter(Context context, List<RecommBanana> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public BananaHOlder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.re_item_style2,null);
        BananaHOlder hOlder=new BananaHOlder(view);
        return hOlder;
    }

    @Override
    public void onBindViewHolder(BananaHOlder holder, int position) {
        RecommBanana banana=data.get(position);
        userDao.downLoadImg(banana.getImage(),holder.style2_img,context);
        if(banana.getGoldBanana()>10000){
            holder.style2_bananaCount.setText(banana.getGoldBanana()/10000+"万");
        }else {
            holder.style2_bananaCount.setText(banana.getGoldBanana()+"");
        }
        holder.style2_body.setText(banana.getTitle());
        holder.style2_userName.setText(banana.getUserName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class BananaHOlder extends RecyclerView.ViewHolder{
        ImageView style2_img;
        TextView style2_body;
        TextView style2_bananaCount;
        TextView style2_userName;
        public BananaHOlder(View itemView) {
            super(itemView);
            style2_img= (ImageView) itemView.findViewById(R.id.style2_img);
            style2_body= (TextView) itemView.findViewById(R.id.style2_body);
            style2_bananaCount= (TextView) itemView.findViewById(R.id.style2_bananaCount);
            style2_userName= (TextView) itemView.findViewById(R.id.style2_userName);
        }
    }
}
