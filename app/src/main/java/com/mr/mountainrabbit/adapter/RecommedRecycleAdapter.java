package com.mr.mountainrabbit.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.RecommBanana;
import com.mr.mountainrabbit.bean.RecommEdarticle;
import com.mr.mountainrabbit.bean.RecommedOther;
import com.mr.mountainrabbit.bean.RecommendAnime;
import com.mr.mountainrabbit.bean.Util;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;
import com.mr.mountainrabbit.view.customview.AdView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * Created by liuha on 2017/2/23.
 */

public class RecommedRecycleAdapter extends RecyclerView.Adapter<RecommedRecycleAdapter.ViewHolder> {
    private List<Integer> count;
    private Context context;
    private Map<String,List> data;
    private IUserDao dao=new UserDao();
    private int WindousHight;

    public RecommedRecycleAdapter(Context context, Map<String, List> data,int WindousHight) {
        this.context = context;
        this.data = data;
        this.WindousHight=WindousHight;
        count=new ArrayList<>();
        count.add(0);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.recommend_recycle_item,null,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
       if(position==0){
           initData1(holder);
       }else if(position==1){

           initdataBanana(holder);
       }else if(position==2){

           initDataDrama(holder);
       }else if(position==3) {

           List<RecommedOther> objData=data.get("cartoonData");
           initOther(objData,holder,"动画","更多动画内容");
       }else  if(position==4){

           List<RecommedOther> objData=data.get("RecreationData");
           initOther(objData,holder,"娱乐","更多娱乐内容");
       }else if(position==5){

           initEssayData(holder);
       }else  if(position==6){

           List<RecommedOther> objData=data.get("gameData");
           initOther(objData,holder,"游戏","更多游戏内容");
           dao.downLoadImg(Util.BannerGame,holder.mRecomItemIll,context);
       }else if(position==7){

           List<RecommedOther> objData=data.get("musicData");
           initOther(objData,holder,"音乐","更多音乐内容");
       }else if(position==8){

           List<RecommedOther> objData=data.get("movieData");
           initOther(objData,holder,"影视","更多影视内容");
       }else if(position==9){

           List<RecommedOther> objData=data.get("danceData");
           initOther(objData,holder,"舞蹈","更多舞蹈内容");
           dao.downLoadImg(Util.MonkeyBanner,holder.mRecomItemIll,context);
       }else  if(position==10){

           List<RecommedOther> objData=data.get("scienceData");
           initOther(objData,holder,"科技","更多科技内容");
       }else if(position==11){

           List<RecommedOther> objData=data.get("sportData");
           initOther(objData,holder,"体育","更多体育内容");
       }else if(position==12){

           List<RecommedOther> objData=data.get("womanData");
           initOther(objData,holder,"彼女","更多彼女内容");
       }else if(position==13){
           List<RecommedOther> objData=data.get("fishpondData");
           initOther(objData,holder,"鱼塘","更多鱼塘内容");
       }
    }




    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout mRecomItemLayout;//广告条的layout
        AdView mRecomItemAd;//广告控件
        LinearLayout mRecomItemtitle;//标题栏的layout
        ImageView mRecomItemTitleImg;//标题栏的图标
        TextView mRecomItemTitleTex;//标题栏的文字
        RecyclerView mRecomItemRV;//内容
        LinearLayout mRecomItemIllLayout;//放广告的横幅的layout
        ImageView mRecomItemIll;//广告横幅
        LinearLayout mRecomItemMore;//更多的layout
        TextView mRecomItemMoreText;//菜单键
        public ViewHolder(View itemView) {
            super(itemView);
            mRecomItemLayout= (LinearLayout) itemView.findViewById(R.id.mRecomItemLayout);
            mRecomItemAd= (AdView) itemView.findViewById(R.id.mRecomItemAd);
            mRecomItemtitle= (LinearLayout) itemView.findViewById(R.id.mRecomItemtitle);
            mRecomItemTitleImg= (ImageView) itemView.findViewById(R.id.mRecomItemTitleImg);
            mRecomItemTitleTex= (TextView) itemView.findViewById(R.id.mRecomItemTitleTex);
            mRecomItemRV= (RecyclerView) itemView.findViewById(R.id.mRecomItemRV);
            mRecomItemIllLayout= (LinearLayout) itemView.findViewById(R.id.mRecomItemIllLayout);
            mRecomItemIll= (ImageView) itemView.findViewById(R.id.mRecomItemIll);
            mRecomItemMoreText= (TextView) itemView.findViewById(R.id.mRecomItemMoreText);
            mRecomItemMore= (LinearLayout) itemView.findViewById(R.id.mRecomItemMore);
        }
    }
    //适配猴山头条
    private void initData1(ViewHolder holder) {
        holder.mRecomItemLayout.setVisibility(View.VISIBLE);
        holder.mRecomItemAd.setData(data.get("AdData"),context);
        List<RecommedOther> datas=data.get("MonkeyHeadData");
        RecommedOther other=datas.get(0);
        dao.downLoadImg(other.getIconUrl(),holder.mRecomItemTitleImg,context);
        holder.mRecomItemTitleTex.setText("猴山头条");
        holder.mRecomItemRV.setLayoutManager(new GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false));
        holder.mRecomItemRV.setAdapter(new RecommOtherAdapter(datas,context));
        holder.mRecomItemIllLayout.setVisibility(View.VISIBLE);
        dao.downLoadImg(Util.RecommendNotice,holder.mRecomItemIll,context);
    }
    //适配香蕉榜
    private void initdataBanana(ViewHolder holder) {
        List<RecommBanana> banan=data.get("bananaData");
        RecommBanana objbanana=banan.get(0);
        dao.downLoadImg(objbanana.getIconUrl(),holder.mRecomItemTitleImg,context);
        holder.mRecomItemTitleTex.setText("香蕉榜");
        holder.mRecomItemRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        holder.mRecomItemRV.setAdapter(new RecommBananaAdapter(context,banan));
        holder.mRecomItemIllLayout.setVisibility(View.VISIBLE);
        dao.downLoadImg(Util.BananaNotice,holder.mRecomItemIll,context);
    }
    //适配番剧
    private void initDataDrama(ViewHolder holder) {
        List<RecommendAnime> anie=data.get("animeData");
        RecommendAnime objAnie=anie.get(0);
        dao.downLoadImg(objAnie.getIcon(),holder.mRecomItemTitleImg,context);
        holder.mRecomItemTitleTex.setText("番剧");
        holder.mRecomItemRV.setLayoutManager(new GridLayoutManager(context,3,GridLayoutManager.VERTICAL,false));
        holder.mRecomItemRV.setAdapter(new RecommAnimeAdapter(anie,context,WindousHight));
        holder.mRecomItemMore.setVisibility(View.VISIBLE);
        holder.mRecomItemMoreText.setText("更多番剧内容");

    }

    //适配文章
    private void initEssayData(ViewHolder holder) {
        List<RecommEdarticle> article=data.get("articleData");
        RecommEdarticle objArticle=article.get(0);
        dao.downLoadImg(objArticle.getIconUrl(),holder.mRecomItemTitleImg,context);
        holder.mRecomItemTitleTex.setText("文章");
        holder.mRecomItemRV.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false));
        holder.mRecomItemRV.setAdapter(new RecommArticleAdapter(article,context));
        holder.mRecomItemMore.setVisibility(View.VISIBLE);
        holder.mRecomItemMoreText.setText("显示更多热门");
    }
    //适配其他类的
    private void initOther(List<RecommedOther> objData,ViewHolder holder,String head,String menue) {
        RecommedOther other=objData.get(0);
        dao.downLoadImg(other.getIconUrl(),holder.mRecomItemTitleImg,context);
        holder.mRecomItemTitleTex.setText(head);
        holder.mRecomItemRV.setLayoutManager(new GridLayoutManager(context,2, GridLayoutManager.VERTICAL,false));
        holder.mRecomItemRV.setAdapter(new RecommOtherAdapter(objData,context));
        holder.mRecomItemMore.setVisibility(View.VISIBLE);
        holder.mRecomItemMoreText.setText(menue);
    }
}
