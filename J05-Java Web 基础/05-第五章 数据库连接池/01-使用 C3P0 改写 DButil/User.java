package org.lanqiao.entity;

public class User {
    private int userId;
    private String userName;
    private int userGender;
    private int userAge;
    private String userNation;
    private String userEmail;
    private String userPhone;
    private String userAddr;

    public User(String userName, int userGender, int userAge, String userNation, String userEmail, String userPhone, String userAddr) {
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userNation = userNation;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAddr = userAddr;
    }

    public User(int userId, String userName, int userGender, int userAge, String userNation, String userEmail, String userPhone, String userAddr) {
        this.userId = userId;
        this.userName = userName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userNation = userNation;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userAddr = userAddr;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserGender() {
        return userGender;
    }

    public void setUserGender(int userGender) {
        this.userGender = userGender;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserNation() {
        return userNation;
    }

    public void setUserNation(String userNation) {
        this.userNation = userNation;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserAddr() {
        return userAddr;
    }

    public void setUserAddr(String userAddr) {
        this.userAddr = userAddr;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", userAge=" + userAge +
                ", userNation='" + userNation + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userAddr='" + userAddr + '\'' +
                '}';
    }
}