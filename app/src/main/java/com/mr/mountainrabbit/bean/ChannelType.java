package com.mr.mountainrabbit.bean;

import java.io.Serializable;

/**
 * Created by liuha on 2017/2/28.
 */

public class ChannelType implements Serializable {
    private  String  ChannelName;
    private  String  ChannelIcon;


    public ChannelType(String channelName, String channelIcon) {
        ChannelName = channelName;
        ChannelIcon = channelIcon;

    }

    public ChannelType() {
    }

    public String getChannelName() {
        return ChannelName;
    }

    public void setChannelName(String channelName) {
        ChannelName = channelName;
    }

    public String getChannelIcon() {
        return ChannelIcon;
    }

    public void setChannelIcon(String channelIcon) {
        ChannelIcon = channelIcon;
    }

}
