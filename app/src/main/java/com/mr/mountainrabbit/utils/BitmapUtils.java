package com.mr.mountainrabbit.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

/**
 * Created by BULING on 2017/2/16.
 */

public class BitmapUtils {
    //传进来一张图片，把图片裁剪成圆形头像
    public static Bitmap  ChangeBitmapToRound(Bitmap mBitmap){
        if(null != mBitmap){
            //这里可能需要调整一下图片的大小来让你的图片能在圆里面充分显示
            mBitmap = Bitmap.createScaledBitmap(mBitmap, 300, 300, true);
            //构建一个位图对象，画布绘制出来的图片将会绘制到此bitmap对象上
            Bitmap bitmap = Bitmap.createBitmap(300, 300,Bitmap.Config.ARGB_8888);
            //构建一个画布
            Canvas mCanvas = new Canvas(bitmap);
            //获得一个画笔对象，并设置为抗锯齿
            Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            //获得一种渲染方式对象
            //BitmapShader的作用是使用一张位图作为纹理来对某一区域进行填充。
            //可以想象成在一块区域内铺瓷砖，只是这里的瓷砖是一张张位图而已。
            Shader mShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            //设置画笔的渲染方式
            mPaint.setShader(mShader);
            //通过画布的画圆方法将渲染后的图片绘制出来
            mCanvas.drawCircle(100, 100, 100, mPaint);
            return bitmap;
        }else{
            return null;


        }

    }


}
