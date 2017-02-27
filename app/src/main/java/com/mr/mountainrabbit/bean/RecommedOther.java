package com.mr.mountainrabbit.bean;

import java.io.Serializable;

/**
 * Created by liuha on 2017/2/23.
 * 后面的娱乐，游戏，音乐，影视，舞蹈，科技，体育等内容的格式都是一样的
 *
 *
 */

public class RecommedOther implements Serializable {
    private int id;
    private String image;
    private String title;
    private String url;
    private int danmakuSize;
    private int views;
    private String iconUrl;

    public RecommedOther() {
    }

    public RecommedOther(int id, String image, String title, String url, int danmakuSize, int views, String iconUrl) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.url = url;
        this.danmakuSize = danmakuSize;
        this.views = views;
        this.iconUrl = iconUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getDanmakuSize() {
        return danmakuSize;
    }

    public void setDanmakuSize(int danmakuSize) {
        this.danmakuSize = danmakuSize;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }




}
