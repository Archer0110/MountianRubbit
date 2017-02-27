package com.mr.mountainrabbit.bean;

import java.io.Serializable;

/**
 * Created by liuha on 2017/2/23.
 */

public class RecommendAnime implements Serializable {
    private int id;
    private String image;
    private String animeMessage;
    private String title;
    private String url;
    private String icon;
    private String endTitle;

    public RecommendAnime() {
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

    public String getAnimeMessage() {
        return animeMessage;
    }

    public void setAnimeMessage(String animeMessage) {
        this.animeMessage = animeMessage;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getEndTitle() {
        return endTitle;
    }

    public void setEndTitle(String endTitle) {
        this.endTitle = endTitle;
    }

    @Override
    public String toString() {
        return "RecommendAnime{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", animeMessage='" + animeMessage + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", endTitle='" + endTitle + '\'' +
                '}';
    }
}
