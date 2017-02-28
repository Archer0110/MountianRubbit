package com.mr.mountainrabbit.presenter.impl;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.mr.mountainrabbit.adapter.DramaFirst;
import com.mr.mountainrabbit.adapter.DramaSecond;
import com.mr.mountainrabbit.bean.Drama;
import com.mr.mountainrabbit.bean.DramaMessage;
import com.mr.mountainrabbit.bean.Util;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;
import com.mr.mountainrabbit.presenter.IDramaPresenter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class DramaPresenter implements IDramaPresenter {
    RecyclerView recyclerView;
    Context context;
    List<Drama> data = new ArrayList<>();
    List<RecyclerView.Adapter> adapters = new ArrayList<>();
    RecyclerView.Adapter adapter1;
    RecyclerView.Adapter adapter2;

    public DramaPresenter(RecyclerView recyclerView,Context context) {
        this.recyclerView = recyclerView;
        this.context = context;
        init();
        adapter1 = new DramaFirst(context,data);
        adapter2 = new DramaSecond(context,data);
        adapters.add(adapter1);
        adapters.add(adapter2);
        LinearLayoutManager manager = new LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(manager);
      //  recyclerView.setAdapter(new com.mr.mountainrabbit.adapter.Drama(context,adapters));
    }

    private void init() {
        for(int i = 0;i<6;i++){
            data.add(new Drama());
        }
    }

    @Override
    public void getData() {
        IUserDao dao = new UserDao();
        RequestParams params = new RequestParams();
        params.addHeader("deviceType","1");
        params.addHeader("productId","2000");
        dao.getHttpData(params, Util.DramaPath, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                getJson(responseInfo.result);
                adapter1.notifyDataSetChanged();
                adapter2.notifyDataSetChanged();
            }
            @Override
            public void onFailure(HttpException error, String msg) {
                Toast.makeText(context,"网络开小差了...(⊙﹏⊙)b",Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 解析接口回传的json数据
     * @param json
     */
    private List<Drama> getJson(String json){
        JSONObject obj = null;
        data.clear();
        try {
            obj = new JSONObject(json);
            JSONArray arr = obj.getJSONArray("data");
            for(int i = 0;i<arr.length();i++){
                Drama drama = new Drama();
                drama.clearList();
                JSONObject obj1 = arr.getJSONObject(i);
                drama.setImage(obj1.getString("image"));
                drama.setName(obj1.getString("name"));
                List<DramaMessage> list = new ArrayList<>();
                JSONArray arr1 = obj1.getJSONArray("contents");
                for(int j = 0; j < arr1.length() ; j++){
                    DramaMessage message = new DramaMessage();
                    JSONObject obj2 = arr1.getJSONObject(j);
                    message.setImage(obj2.getString("image"));
                    message.setTitle(obj2.getString("title"));
                    if( i == 2 ){
                        JSONObject obj3 = obj2.getJSONObject("latestBangumiVideo");
                        message.setUpdate(obj3.getString("title"));
                    }
                    if(i>1){
                        JSONObject obj4 = obj2.getJSONObject("visit");
                        message.setComments(obj4.getString("comments"));
                        message.setRead(obj4.getString("views"));
                    }

                    list.add(message);
                }
                drama.setList(list);
                data.add(drama);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return data;
    }

}
