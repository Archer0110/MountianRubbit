package com.mr.mountainrabbit.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */

public class Drama {
    private String name = "";
    private String image = "";
    private List<DramaMessage> list = new ArrayList<>();

    public Drama() {
        for(int i = 0; i<6 ; i++){
            list.add(new DramaMessage());
        }

    }

    @Override
    public String toString() {
        return "Drama{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", list=" + list +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<DramaMessage> getList() {
        return list;
    }

    public void setList(List<DramaMessage> list) {
        this.list.addAll(list);
    }
    public  void clearList(){
        list.clear();
    }
}
