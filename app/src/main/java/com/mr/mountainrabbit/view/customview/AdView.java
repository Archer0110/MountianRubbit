package com.mr.mountainrabbit.view.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.lidroid.xutils.BitmapUtils;
import com.mr.mountainrabbit.R;
import com.mr.mountainrabbit.bean.Ad;
import com.mr.mountainrabbit.dao.IUserDao;
import com.mr.mountainrabbit.dao.impl.UserDao;

import java.util.List;

/**
 * Created by liuha on 2017/2/21.
 */

public class AdView extends LinearLayout {
    private  LinearLayout layout;
    private ViewPager pager;
    private Context context;
    private List<Ad> data;


    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        init(context);

    }
    //初始化
    private void init(Context context) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=inflater.inflate(R.layout.adview_coustom,this);
        findView(view);
        pager.addOnPageChangeListener(new MyPagerListener());
    }
    //找到里面的控件
    private void findView(View view) {
        layout= (LinearLayout) view.findViewById(R.id.mCoustomViewAd_layout);
        pager= (ViewPager) view.findViewById(R.id.mCoustomViewAd_pager);
    }



    //对外提供一个设置数据的方法
    public void setData(final List<Ad> data, Context context){
        this.context=context;
        this.data=data;
        MyAdapter adapter=new MyAdapter();
        pager.setAdapter(adapter);
        setIcom(0);
        new Thread(new Runnable() {
            Handler handler=new Handler();
            @Override
            public void run() {

                try {
                    while (true) {
                        Thread.sleep(4000);
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                int currentItem=pager.getCurrentItem();
                                int nextItem=(currentItem+1)%data.size();
                                pager.setCurrentItem(nextItem);
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //设置小圆点
    private void setIcom(int position){
        for (int i = 0; i <data.size() ; i++) {
            ImageView img=new ImageView(context);
            LayoutParams layoutParams=new LayoutParams(35,35);
            layoutParams.setMargins(10,10,10,10);
            img.setLayoutParams(layoutParams);
            if(i==position){
                img.setImageResource(R.drawable.banana_yellow);
            }else {
                img.setImageResource(R.drawable.ad_dot);
            }
            layout.addView(img);
        }
    }


    //设置一个接口回调ViewPager的监听事件
    interface  Callback{
        public void onPageSelected(int position);
    }
    private  Callback callback;

    public void setCheckListener(Callback callback){
        this.callback=callback;
    }

    //Viewpager 的适配器
    private class MyAdapter extends PagerAdapter{
        private IUserDao dao=new UserDao();

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView mImageView=new ImageView(context);
            //mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            Ad ad=data.get(position);
            String url = ad.getImage();
            dao.downLoadImg(url,mImageView,context);

            container.addView(mImageView);
            return mImageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((ImageView)object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }
    }

    //viewpager 的监听事件
    private  class MyPagerListener implements ViewPager.OnPageChangeListener{


        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            layout.removeAllViews();
            setIcom(position);
            //callback.onPageSelected(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }

}
