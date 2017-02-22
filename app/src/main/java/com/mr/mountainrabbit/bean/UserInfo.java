package com.mr.mountainrabbit.bean;

/**
 * Created by BULING on 2017/2/21.
 */

public class UserInfo {
    private static Boolean isLogin;
    private static String user_name;
    private static String system_member;

    public static String getSystem_member() {
        return system_member;
    }

    public static void setSystem_member(String system_member) {
        UserInfo.system_member = system_member;
    }

    public static String getUser_name() {
        return user_name;
    }

    public static void setUser_name(String user_name) {
        UserInfo.user_name = user_name;
    }

    public static Boolean getIsLogin() {
        return isLogin;
    }

    public static void setIsLogin(Boolean isLogin) {
        UserInfo.isLogin = isLogin;
    }
}
