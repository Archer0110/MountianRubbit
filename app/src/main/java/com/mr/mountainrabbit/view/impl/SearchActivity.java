package com.mr.mountainrabbit.view.impl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;
import com.mr.mountainrabbit.presenter.ISearchPresenter;
import com.mr.mountainrabbit.presenter.impl.SearchPresenter;
import com.mr.mountainrabbit.view.ISearchActivityView;

public class SearchActivity extends AppCompatActivity implements ISearchActivityView{
    @ViewInject(R.id.recycler_search)
    private RecyclerView recycler_search;
    @ViewInject(R.id.back_main_search)
    private ImageView back_main_search;
    @ViewInject(R.id.search_search)
    private SearchView search_search;

    private ISearchPresenter mISearchPresenter = new SearchPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ViewUtils.inject(this);
        initData();
        setListener();
    }

    /**
     * 设置监听
     */
    private void setListener() {
        back_main_search.setOnClickListener(new ClickListener());
        search_search.setOnQueryTextListener(new SearchListener());
    }

    /**
     * 初始化数据
     */
    private void initData() {
        mISearchPresenter.searchHotData(recycler_search);
    }

    @Override
    public LayoutInflater getInflater() {
        return getLayoutInflater();
    }

    @Override
    public void finishPage() {
        finish();
    }

    @Override
    public void requestFail() {
        Toast.makeText(this,"服务器请求失败",Toast.LENGTH_SHORT).show();
    }
    /**
     * 自己写个类实现页面的点击事件的监听
     */
    private class ClickListener implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.back_main_search://点击了返回
                    mISearchPresenter.jumpToMain();
                    break;
            }
        }
    }

    /**
     * 自己写一个类来实现搜索的监听
     */
    private class SearchListener implements SearchView.OnQueryTextListener {

        //单机搜索按钮时调用的方法
        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }
        //用户输入时调用的方法
        @Override
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    }

}
