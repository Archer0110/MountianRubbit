package com.mr.mountainrabbit.bean;

import java.io.Serializable;

/**
 * Created by liuha on 2017/2/23.
 * 文章类
 *
 */

public class RecommEdarticle implements Serializable {
    private int id;
    private  String name;
    private String title;
    private int comments;
    private int views;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    private String iconUrl;

    public RecommEdarticle(int id, String name, String title, int comments, int views) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.comments = comments;
        this.views = views;
    }

    public RecommEdarticle() {
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "RecommEdarticle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", comments=" + comments +
                ", views=" + views +
                '}';
    }
}
