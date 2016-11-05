package com.xrtz.xrlive.bean;

/**
 * Created by Administrator on 2016/11/4.
 */

public class User {
    private String userName;
    private String password;
    private int id;//直播id

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
