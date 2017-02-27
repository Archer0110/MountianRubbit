package com.mr.mountainrabbit.bean;

/**
 * Created by BULING on 2017/2/21.
 * 这用来放常量
 */

public class Util {
    //默认图片的路径
    public static String ICONPATH = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1841987292,1358375699&fm=23&gp=0.jpg";

    //根地址
    private static String basePath = "http://139.129.19.51/story";
    //接口根地址
    private static String projectPath = "/index.php/home/Interface/";
    //登录接口的地址
    public static final String LOGINPATH = basePath + projectPath + "login";
    //头像图片的地址
    public static final String ICONPICTURE =basePath + "/Uploads/portrait/";


    //搜索页面热搜的接口
    public static final String SearchHotPath = "http://api.aixifan.com/hotwords";


    //共享参数要使用的文件名称
    public static final String MR = "MountainRabbitUserInFo";
}
