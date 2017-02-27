package com.mr.mountainrabbit.bean;

import java.io.Serializable;

/**
 * Created by liuha on 2017/2/24.
 */

public class RecommBanana implements Serializable {
    private String iconUrl;
    private String image;
    private String userName;
    private String title;
    private String url;
    private int goldBanana;

    public RecommBanana() {
    }

    public RecommBanana(String iconUrl, String image, String userName, String title, String url, int goldBanana) {
        this.iconUrl = iconUrl;
        this.image = image;
        this.userName = userName;
        this.title = title;
        this.url = url;
        this.goldBanana = goldBanana;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public int getGoldBanana() {
        return goldBanana;
    }

    public void setGoldBanana(int goldBanana) {
        this.goldBanana = goldBanana;
    }
}
