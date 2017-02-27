package com.mr.mountainrabbit.presenter.impl;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;
import com.mr.mountainrabbit.presenter.ISearchPresenter;
import com.mr.mountainrabbit.view.ISearchActivityView;
import com.mr.mountainrabbit.view.impl.MainActivity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BULING on 2017/2/25.
 */

public class SearchPresenter implements ISearchPresenter{

    private IUserDao mIUserDao = new UserDao();
    private List<String> data = new ArrayList<>();

    private Context Context;
    private ISearchActivityView mISearchActivityView;

    public SearchPresenter(android.content.Context context, ISearchActivityView mISearchActivityView) {
        Context = context;
        this.mISearchActivityView = mISearchActivityView;
    }

    /**
     * 加载热搜的数据
     */
    @Override
    public void searchHotData(RecyclerView recycler_search) {
        getHotData(recycler_search);


    }

    /**
     * 跳转到主界面
     */
    @Override
    public void jumpToMain() {
        Intent intent = new Intent(Context, MainActivity.class);
        Context.startActivity(intent);
        mISearchActivityView.finishPage();
    }

    private void getHotData(final RecyclerView recycler_search) {
        mIUserDao.getSearchOfHot(new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                String result = responseInfo.result;
                //解析json
                jsonString(result,recycler_search);
            }

            @Override
            public void onFailure(HttpException error, String msg) {
                //返回服务器请求失败

            }
        });
    }

    /**
     * 解析热搜的json
     */
    private void jsonString(String result,RecyclerView recycler_search) {
        if(TextUtils.isEmpty(result)){
            //返回服务器异常--解析字符串为空

            return;
        }
        try {

            JSONObject jo = new JSONObject(result);
            JSONArray ja = jo.getJSONArray("data");
            for(int i = 0;i<ja.length();i++){
                JSONObject object = ja.getJSONObject(i);
                String value = object.getString("value");
                data.add(value);
            }

            recycler_search.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
            recycler_search.setAdapter(new RecyclerAdapterOfHotSearch());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
     * 自己写一个类继承Recycler
     */

    private class RecyclerAdapterOfHotSearch extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mISearchActivityView.getInflater().inflate(R.layout.textview_search, null);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ViewHolder mViewHolder = (ViewHolder) holder;
            mViewHolder.getText_search().setText(data.get(position));
            //设置控件的宽高
            holder.itemView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
        private class ViewHolder extends RecyclerView.ViewHolder{
            private TextView text_search;

            public ViewHolder(View itemView) {
                super(itemView);
                text_search = (TextView) itemView.findViewById(R.id.text_search);
            }
            public TextView getText_search(){
                return text_search;
            }

        }
    }

}
