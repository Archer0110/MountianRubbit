package com.mr.mountainrabbit.presenter;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListView;

/**
 * Created by BULING on 2017/2/25.
 */

public interface ISearchPresenter {
    //加载热搜的布局的数据
    public void searchHotData(RecyclerView recycler_search);
    //返回主界面
    public void jumpToMain();
    //获取用户输入框搜索加载下来的数据
    public void getUserScanner(String newText, ListView listview_search,LinearLayout lin_search);
}
