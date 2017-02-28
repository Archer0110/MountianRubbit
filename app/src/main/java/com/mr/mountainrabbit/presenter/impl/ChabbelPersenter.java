package com.mr.mountainrabbit.presenter.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.mr.mountainrabbit.adapter.ChannelAdapter;
import com.mr.mountainrabbit.bean.ChannelType;
import com.mr.mountainrabbit.presenter.IChannelPersenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liuha on 2017/2/27.
 */

public class ChabbelPersenter implements IChannelPersenter{
    private Context mContext;
    private RecyclerView mRecyclerView;
    private List<String> Recreationdata;
    private List<String> Articledata;
    private List<String> Cartoondata;
    private List<String> Gamedata;
    private  List<String> Aniedata;
    private  List<String> Moviedata;
    private  List<String> Musicdata;
    private  List<String> Dancedata;
    private  List<String> Sciencedata;
    private  List<String> Sportdata;
    private  List<String>  Womandata;
    private  List<String> Fishdata;
    private  List<List> data;
    private List<ChannelType> Typedata;
    private ChannelAdapter mChannelAdapter;


    public ChabbelPersenter(Context mContext, RecyclerView mRecyclerView) {
        this.mContext = mContext;
        this.mRecyclerView = mRecyclerView;
    }

    //获取数据
    @Override
    public void setData() {
        initData();

    }

    //初始化数据
    private void initData() {
        initRecreationData();
        initArticle();
        initCartoon();
        initGame();
        initAnie();
        initMovie();
        initMusic();
        initDance();
        initScience();
        initSport();
        initWoman();
        initFish();
        initTypedata();
        saveData();
    }

    /**
     * 标题栏的数据
     */
    private void initTypedata() {
        Typedata=new ArrayList<>();
        Typedata.add(new ChannelType("娱乐","http://imgs.aixifan.com/cms/2017_01_12/1484212553481.png"));
        Typedata.add(new ChannelType("动画","http://imgs.aixifan.com/cms/2017_01_12/1484212536103.png"));
        Typedata.add(new ChannelType("游戏","http://imgs.aixifan.com/cms/2017_01_12/1484212578725.png"));
        Typedata.add(new ChannelType("文章","http://imgs.aixifan.com/cms/2017_01_12/1484212564463.png"));
        Typedata.add(new ChannelType("番剧","http://imgs.aixifan.com/cms/2017_01_12/1484212523990.png"));
        Typedata.add(new ChannelType("影视","http://imgs.aixifan.com/cms/2017_01_12/1484212603490.png"));
        Typedata.add(new ChannelType("音乐","http://imgs.aixifan.com/cms/2017_01_12/1484212591117.png "));
        Typedata.add(new ChannelType("舞蹈","http://imgs.aixifan.com/cms/2017_01_12/1484212614194.png"));
        Typedata.add(new ChannelType("科技","http://imgs.aixifan.com/cms/2017_01_12/1484212628426.png"));
        Typedata.add(new ChannelType("体育","http://imgs.aixifan.com/cms/2017_01_12/1484212639155.png"));
        Typedata.add(new ChannelType("彼女","http://imgs.aixifan.com/cms/2017_01_12/1484212648949.png"));
        Typedata.add(new ChannelType("鱼♂塘","http://imgs.aixifan.com/cms/2017_01_12/1484212658591.png"));
    }

    //保存数据集
    private void saveData() {
        data=new ArrayList<>();
        data.add(Recreationdata);
        data.add(Articledata);
        data.add(Cartoondata);
        data.add(Gamedata);
        data.add(Aniedata);
        data.add(Moviedata);
        data.add(Musicdata);
        data.add(Dancedata);
        data.add(Sciencedata);
        data.add(Sportdata);
        data.add(Womandata);
        data.add(Fishdata);
        setAdapter();
    }

    private void setAdapter() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false));
        mChannelAdapter=new ChannelAdapter(Typedata,mContext,data);
        setHelper();
        mRecyclerView.setAdapter(mChannelAdapter);
    }

    private void setHelper() {
        ItemTouchHelper.Callback mCallback=new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN,ItemTouchHelper.UP|ItemTouchHelper.DOWN){


            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
               int fromPostition=viewHolder.getAdapterPosition();//得到拖动ViewHolder的position
                int toPosition=target.getAdapterPosition();//得到ViewHolder 的position
                if (fromPostition < toPosition) {
                for (int i = fromPostition; i < toPosition; i++) {
                    Collections.swap(data, i, i + 1);
                }
            } else {
                for (int i = fromPostition; i > toPosition; i--) {
                    Collections.swap(data, i, i - 1);
                }
            }
            mChannelAdapter.notifyItemMoved(fromPostition, toPosition);
            //返回true表示执行拖动
            return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {


            }
        };

        ItemTouchHelper mItemTouchHelper=new ItemTouchHelper(mCallback);
        mItemTouchHelper.attachToRecyclerView(mRecyclerView);


    }

    /**
     * 鱼塘
     */
    private void initFish() {
        Fishdata=new ArrayList<>();
        Fishdata.add("军事");
        Fishdata.add("历史");
        Fishdata.add("焦点");
    }

    /**
     * 彼女
     */
    private void initWoman() {
        Womandata=new ArrayList<>();
        Womandata.add("造型");
        Womandata.add("西皮");
        Womandata.add("爱豆");
        Womandata.add("其他");
    }

    /**
     * 体育
     */
    private void initSport() {
        Sportdata=new ArrayList<>();
        Sportdata.add("综合体育");
        Sportdata.add("足球");
        Sportdata.add("篮球");
        Sportdata.add("搏击");
        Sportdata.add("11区体育");
        Sportdata.add("惊奇体育");
    }

    /**
     * 科技
     */
    private void initScience() {
        Sciencedata=new ArrayList<>();
        Sciencedata.add("SF");
        Sciencedata.add("黑科技");
        Sciencedata.add("数码");
        Sciencedata.add("广告");
        Sciencedata.add("百科技");
        Sciencedata.add("自我发电");
    }

    /**
     * 舞蹈
     */
    private void initDance() {
        Dancedata=new ArrayList<>();
        Dancedata.add("综合舞蹈");
        Dancedata.add("宅舞");
    }

    /**音乐
     *  */
    private void initMusic() {
        Musicdata=new ArrayList<>();
        Musicdata.add("原创-翻唱");
        Musicdata.add("演奏");
        Musicdata.add("Vocaloid");
        Musicdata.add("日系音乐");
        Musicdata.add("综合音乐");
        Musicdata.add("演唱会");
    }

    /**
     * 影视
     */
    private void initMovie() {
        Moviedata=new ArrayList<>();
        Moviedata.add("电影");
        Moviedata.add("日剧");
        Moviedata.add("美剧");
        Moviedata.add("国产");
        Moviedata.add("网络剧");
        Moviedata.add("韩剧");
        Moviedata.add("特摄-霹雳");
        Moviedata.add("纪录片");
        Moviedata.add("其他");
    }

    /**
     * 番剧
     */
    private void initAnie() {
        Aniedata=new ArrayList<>();
        Aniedata.add("新番连载");
        Aniedata.add("旧番补档");
        Aniedata.add("国产动画");
        Aniedata.add("动画资讯");
    }

    /**
     * 游戏
     */
    private void initGame() {
        Gamedata=new ArrayList<>();
        Gamedata.add("游戏锦集");
        Gamedata.add("电子竞技");
        Gamedata.add("主机单机");
        Gamedata.add("英雄联盟");
        Gamedata.add("守望先锋");
        Gamedata.add("桌游卡牌");
        Gamedata.add("Mugen");
    }

    /*
     *动画数据
     */
    private void initCartoon() {
        Cartoondata=new ArrayList<>();
        Cartoondata.add("动画短片");
        Cartoondata.add("MAD-AMV");
        Cartoondata.add("MAD-3D");
        Cartoondata.add("2.5次元");
    }

    /**
     * 文章的数据
     */
    private void initArticle() {
        Articledata=new ArrayList<>();
        Articledata.add("工作の情感");
        Articledata.add("动漫文化");
        Articledata.add("漫画の小说");
        Articledata.add("综合");
        Articledata.add("游戏");
    }

    /**
     * 娱乐的内容
     */
    private void initRecreationData() {
        Recreationdata=new ArrayList<>();
        Recreationdata.add("生活娱乐");
        Recreationdata.add("鬼畜调教");
        Recreationdata.add("萌宠");
        Recreationdata.add("美食");
        Recreationdata.add("综艺");
    }
}
