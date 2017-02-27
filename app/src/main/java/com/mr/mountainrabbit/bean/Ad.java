package com.mr.mountainrabbit.bean;

import java.io.Serializable;

/**
 * Created by liuha on 2017/2/22.
 */

public class Ad implements Serializable {
    private int id;
    private String image;
    private String url;

    public Ad(int id, String image, String url) {
        this.id = id;
        this.image = image;
        this.url = url;
    }

    public Ad() {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
