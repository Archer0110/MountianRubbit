package com.mr.mountainrabbit.presenter.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.mr.mountainrabbit.adapter.RecommedRecycleAdapter;
import com.mr.mountainrabbit.bean.Ad;
import com.mr.mountainrabbit.bean.RecommBanana;
import com.mr.mountainrabbit.bean.RecommEdarticle;
import com.mr.mountainrabbit.bean.RecommedOther;
import com.mr.mountainrabbit.bean.RecommendAnime;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * Created by liuha on 2017/2/21.
 */

public class RecommendPersenter {
    private int WindousHight;
    private Context contex;
    private RecyclerView mRecyclerView;
    private List<Ad> AdData = new ArrayList<>();//广告的资源
    private List<RecommedOther> MonkeyHeadData ;//猴山头条的资源
    private List<RecommendAnime> animeData = new ArrayList<>();//番剧的资源
    private List<RecommedOther> cartoonData = new ArrayList<>();//动画的资源
    private List<RecommedOther> RecreationData = new ArrayList<>();//娱乐的资源
    private List<RecommEdarticle> articleData = new ArrayList<>();//文章的资源
    private List<RecommedOther> gameData = new ArrayList<>();//游戏资源
    private List<RecommedOther> musicData = new ArrayList<>();//音乐资源
    private List<RecommedOther> movieData = new ArrayList<>();//影视资源
    private List<RecommedOther> danceData = new ArrayList<>();//舞蹈资源
    private List<RecommedOther> scienceData = new ArrayList<>();//科技资源
    private List<RecommedOther> sportData = new ArrayList<>(); //运动资源
    private List<RecommedOther> womanData = new ArrayList<>();//彼女资源
    private List<RecommedOther> fishpondData = new ArrayList<>();//鱼塘资源
    private List<RecommBanana> bananaData=new ArrayList<>();//香蕉排行榜资源
    private IUserDao dao = new UserDao();
    private Map<String,List> data=new HashMap<>();

    public RecommendPersenter(int windousHight, Context contex, RecyclerView mRecyclerView) {
        WindousHight = windousHight;
        this.contex = contex;
        this.mRecyclerView = mRecyclerView;
    }

    //请求数据
    public void getData() {
        dao.getRecommendData("1", "2000", new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {

                parsingJson(responseInfo.result);
            }
            @Override
            public void onFailure(HttpException error, String msg) {

            }
        });
    }

    //解析json数据
    private void parsingJson(String result) {

        try {
            JSONObject resultObj = new JSONObject(result);
            JSONArray arr = resultObj.getJSONArray("data");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject obj = arr.getJSONObject(i);
                if ("轮播图".equals(obj.get("name"))) {
                    getAdDate(obj);
                } else if ("猴山头条".equals(obj.getString("name"))) {
                    getMonkeyHead(obj);
                } else if ("番剧".equals(obj.getString("name"))) {
                    getAnimeData(obj);
                } else if ("动画".equals(obj.getString("name"))) {
                    getCartoonData(obj);
                } else if ("娱乐".equals(obj.getString("name"))) {
                    getRecreationData(obj);
                } else if ("文章".equals(obj.getString("name"))) {
                    getArticleData(obj);
                } else if ("游戏".equals(obj.getString("name"))) {
                    getGameData(obj);
                } else if ("音乐".equals(obj.getString("name"))) {
                    getMusicData(obj);
                } else if ("影视".equals(obj.getString("name"))) {
                    getMovieData(obj);
                } else if ("舞蹈".equals(obj.getString("name"))) {
                    getDanceData(obj);
                } else if ("科技".equals(obj.getString("name"))) {
                    getScienceData(obj);
                } else if ("体育".equals(obj.getString("name"))) {
                    getSportData(obj);
                } else if ("彼女".equals(obj.getString("name"))) {
                    getWomanData(obj);
                } else if ("鱼塘".equals(obj.getString("name"))) {
                    getFishpondData(obj);
                }else if("香蕉榜".equals(obj.getString("name"))){
                    getBananaData(obj);
                }
            }
            saveData();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    //获取香蕉榜的数据
    private void getBananaData(JSONObject obj) {
        try {
            String iconUrl=obj.getString("image");
            JSONArray arr=obj.getJSONArray("contents");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject dataObj=arr.getJSONObject(i);
                RecommBanana ban=new RecommBanana();
                ban.setIconUrl(iconUrl);
                ban.setImage(dataObj.getString("image"));
                JSONObject user=dataObj.getJSONObject("owner");
                ban.setUserName(user.getString("name"));
                ban.setTitle(dataObj.getString("title"));
                ban.setUrl(dataObj.getString("url"));
                JSONObject objInfo=dataObj.getJSONObject("visit");
                ban.setGoldBanana(objInfo.getInt("goldBanana"));
                bananaData.add(ban);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //将数据存到map集合中
    private void saveData() {
        data.put("AdData",AdData);
        data.put("MonkeyHeadData",MonkeyHeadData);
        data.put("animeData",animeData);
        data.put("cartoonData",cartoonData);
        data.put("RecreationData",RecreationData);
        data.put("articleData",articleData);
        data.put("gameData",gameData);
        data.put("musicData",musicData);
        data.put("movieData",movieData);
        data.put("danceData",danceData);
        data.put("scienceData",scienceData);
        data.put("sportData",sportData);
        data.put("womanData",womanData);
        data.put("fishpondData",fishpondData);
        data.put("bananaData",bananaData);
        setAdapter();
    }

    private void setAdapter() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(contex,LinearLayoutManager.VERTICAL,false));
        RecommedRecycleAdapter recyclerAdapter=new RecommedRecycleAdapter(contex,data,WindousHight);
        mRecyclerView.setAdapter(recyclerAdapter);
    }


    //获取鱼塘资源
    private void getFishpondData(JSONObject obj) {
        pullOtherData(fishpondData, obj);
    }

    //获取彼女资源
    private void getWomanData(JSONObject obj) {
        pullOtherData(womanData, obj);
    }

    //获取体育内容
    private void getSportData(JSONObject obj) {
        pullOtherData(sportData, obj);
    }

    //获取科技内容
    private void getScienceData(JSONObject obj) {
        pullOtherData(scienceData, obj);
    }

    /**
     * 获取舞蹈内容
     */
    private void getDanceData(JSONObject obj) {
        pullOtherData(danceData, obj);
    }

    //获取影视内容
    private void getMovieData(JSONObject obj) {
        pullOtherData(movieData, obj);
    }

    //获取音乐内容
    private void getMusicData(JSONObject obj) {
        pullOtherData(musicData, obj);
    }

    //获取游戏的内容
    private void getGameData(JSONObject obj) {
        pullOtherData(gameData, obj);
    }

    //获取文章的内容
    private void getArticleData(JSONObject obj) {
        try {
            String iconUrl = obj.getString("image");
            JSONArray array = obj.getJSONArray("contents");
            for (int i = 0; i < array.length(); i++) {
                JSONObject dataObj = array.getJSONObject(i);
                RecommEdarticle cle = new RecommEdarticle();
                cle.setIconUrl(iconUrl);
                cle.setId(dataObj.getInt("id"));
                JSONObject userObj = dataObj.getJSONObject("owner");
                cle.setName(userObj.getString("name"));
                cle.setTitle(dataObj.getString("title"));
                cle.setUrl(dataObj.getString("url"));
                JSONObject onjInFo = dataObj.getJSONObject("visit");
                cle.setComments(onjInFo.getInt("comments"));
                cle.setViews(onjInFo.getInt("views"));
                articleData.add(cle);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    // 获取娱乐内容
    private void getRecreationData(JSONObject obj) {
        pullOtherData(RecreationData, obj);
    }

    //获取动画内容
    private void getCartoonData(JSONObject obj) {
       pullOtherData(cartoonData,obj);
    }

    //获取番剧内容
    private void getAnimeData(JSONObject obj) {
        try {
            String iconUrl = obj.getString("image");
            JSONArray arr = obj.getJSONArray("contents");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject dataObj = arr.getJSONObject(i);
                RecommendAnime anime = new RecommendAnime();
                anime.setIcon(iconUrl);
                anime.setId(dataObj.getInt("id"));
                anime.setImage(dataObj.getString("image"));
                anime.setTitle(dataObj.getString("title"));
                anime.setUrl(dataObj.getString("url"));
                JSONObject info = dataObj.getJSONObject("latestBangumiVideo");
                anime.setAnimeMessage(info.getString("title"));
                animeData.add(anime);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //获取猴山头条的数据
    private void getMonkeyHead(JSONObject obj) {
        MonkeyHeadData=new ArrayList<>();
        try {
            String iconUrl = obj.getString("image");
            JSONArray arr = obj.getJSONArray("contents");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject dataObj = arr.getJSONObject(i);
                RecommedOther other = new RecommedOther();
                other.setIconUrl(iconUrl);
                other.setId(dataObj.getInt("id"));
                other.setImage(dataObj.getString("image"));
                other.setTitle(dataObj.getString("title"));
                other.setUrl(dataObj.getString("url"));
                try {
                    JSONObject info = dataObj.getJSONObject("visit");
                other.setDanmakuSize(info.getInt("danmakuSize"));
                other.setViews(info.getInt("views"));
                }catch (Exception e){
                    other.setDanmakuSize(100);
                    other.setViews(1078);
                }

                MonkeyHeadData.add(other);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    //获得广告轮播的数据
    private void getAdDate(JSONObject obj) {
        try {
            JSONArray Adarr = obj.getJSONArray("contents");
            for (int i = 0; i < Adarr.length(); i++) {
                JSONObject adJson = Adarr.getJSONObject(i);
                Ad ad = new Ad();
                ad.setId(adJson.getInt("id"));
                ad.setImage(adJson.getString("image"));
                ad.setUrl(adJson.getString("url"));
                AdData.add(ad);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    //解析 后面的娱乐，游戏，音乐，影视，舞蹈，科技，体育等内容的方法
    private void pullOtherData(List<RecommedOther> data, JSONObject obj) {
        try {
            String iconUrl = obj.getString("image");
            JSONArray arr = obj.getJSONArray("contents");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject dataObj = arr.getJSONObject(i);
                RecommedOther other = new RecommedOther();
                other.setIconUrl(iconUrl);
                other.setId(dataObj.getInt("id"));
                other.setImage(dataObj.getString("image"));
                other.setTitle(dataObj.getString("title"));
                other.setUrl(dataObj.getString("url"));
                JSONObject info = dataObj.getJSONObject("visit");
                other.setDanmakuSize(info.getInt("danmakuSize"));
                other.setViews(info.getInt("views"));
                data.add(other);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
