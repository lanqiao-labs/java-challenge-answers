package org.lanqiao.entity;

public class User {
    private String userName;
    private String userPwd;
    private String nickName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public User() {
    }

    public User(String userName, String userPwd, String nickName) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.nickName = nickName;
    }
}