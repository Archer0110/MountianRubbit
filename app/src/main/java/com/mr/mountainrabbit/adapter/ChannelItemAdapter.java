package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mr.mountainrabbit.R;

import java.util.List;

/**
 * Created by liuha on 2017/2/28.
 */

public class ChannelItemAdapter extends RecyclerView.Adapter<ChannelItemAdapter.ChannelItemHolder> {
    private Context mContext;
    private List<String> data;

    public ChannelItemAdapter(Context mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public ChannelItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView= LayoutInflater.from(mContext).inflate(R.layout.channel_iten_body_item,null,false);
        ChannelItemHolder mChannelItemHolder=new ChannelItemHolder(mView);

        return mChannelItemHolder;
    }

    @Override
    public void onBindViewHolder(ChannelItemHolder holder, int position) {
        String body=data.get(position);
        holder.mChannelItem_Body_tex.setText(body);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public  class ChannelItemHolder extends RecyclerView.ViewHolder{
        TextView mChannelItem_Body_tex;
        public ChannelItemHolder(View itemView) {
            super(itemView);
            mChannelItem_Body_tex= (TextView) itemView.findViewById(R.id.mChannelItem_Body_tex);
        }
    }
}
