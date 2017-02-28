package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.ChannelType;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;

import java.util.List;

/**
 * Created by liuha on 2017/2/28.
 */

public class ChannelAdapter extends RecyclerView.Adapter<ChannelAdapter.ChannelHolder> {
    private Context mContext;
    private List<List> data;
    private List<ChannelType> typeData;
    private IUserDao dao=new UserDao();

    public ChannelAdapter(List<ChannelType> typeData, Context mContext, List<List> data) {
        this.typeData = typeData;
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ChannelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView= LayoutInflater.from(mContext).inflate(R.layout.channel_rv_item,null,false);
        ChannelHolder mChannelHolder=new ChannelHolder(mView);
        return mChannelHolder;
    }

    @Override
    public void onBindViewHolder(ChannelHolder holder, int position) {
        dao.downLoadImg(typeData.get(position).getChannelIcon(),holder.mChannelItem_TitleImg,mContext);
        holder.mChannelItem_TitleTxt.setText(typeData.get(position).getChannelName());
        holder.mChannelItem_RecycleView.setLayoutManager(new GridLayoutManager(mContext,3,GridLayoutManager.VERTICAL,false));
        holder.mChannelItem_RecycleView.setAdapter(new ChannelItemAdapter(mContext,data.get(position)));
        int count=(int) (Math.random()*200);
        holder.mChannelItem_cont.setText("+"+count+"");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ChannelHolder extends RecyclerView.ViewHolder{
        ImageView mChannelItem_TitleImg;
        TextView mChannelItem_TitleTxt;
        RecyclerView mChannelItem_RecycleView;
        TextView mChannelItem_cont;
        public ChannelHolder(View itemView) {
            super(itemView);
            mChannelItem_RecycleView= (RecyclerView) itemView.findViewById(R.id.mChannelItem_RecycleView);
            mChannelItem_TitleImg= (ImageView) itemView.findViewById(R.id.mChannelItem_TitleImg);
            mChannelItem_TitleTxt= (TextView) itemView.findViewById(R.id.mChannelItem_TitleTxt);
            mChannelItem_cont= (TextView) itemView.findViewById(R.id.mChannelItem_cont);
        }
    }
}
