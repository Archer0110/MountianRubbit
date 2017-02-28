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

    //搜索获得的数据
    public static final String UserSearch = "http://search.app.acfun.cn/suggest?q=";

    //共享参数要使用的文件名称
    public static final String MR = "MountainRabbitUserInFo";

    public static final String iconPath = "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1841987292,1358375699&fm=23&gp=0.jpg";

    //番剧页面接口
    public static final String DramaPath = "http://api.aixifan.com/regions?belong=11&loadCount=-1&channelId=155";

    public static final String BANANANOTICE="http://api.aixifan.com/ranks/1";//推荐页的香蕉榜
    public static final String RecommendNotice="http://imgs.aixifan.com/cms/2016_10_27/1477538060663.png";//推荐页全站排行榜的图片地址
    public static final String BananaNotice="http://imgs.aixifan.com/cms/2016_10_27/1477538071954.png";//推荐页的香蕉排行榜横幅
    public static final String BannerGame="http://imgs.aixifan.com/cms/2017_02_22/1487736897818.jpg";//推荐页的游戏横幅
    public static final String MonkeyBanner="http://cdn.aixifan.com/dotnet/artemis/u/cms/www/201601/18100819jyhrelmf.jpg";//推荐页的猴山小卖部横幅
}
