package com.mr.mountainrabbit.bean;

/**
 * Created by Administrator on 2017/2/23.
 */

public class DramaMessage {
    private String image = "";
    private String title = "";
    private String update = "";
    private String comments = "";
    private String read = "";

    @Override
    public String toString() {
        return "DramaMessage{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", update='" + update + '\'' +
                ", comments='" + comments + '\'' +
                ", read='" + read + '\'' +
                '}';
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

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getRead() {
        return read;
    }

    public void setRead(String read) {
        this.read = read;
    }
}
