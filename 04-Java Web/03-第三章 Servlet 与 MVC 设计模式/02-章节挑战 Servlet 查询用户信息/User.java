
package org.lanqiao.entity;

public class User {
 private String username;
 private String userPassword;
 private int userAge;
 private String userAddress;

 public User() {
 }

 //添加 username userAge userAddress 三个参数的构造方法

 public User(String username, int userAge, String userAddress) {
     this.username = username;
     this.userAge = userAge;
     this.userAddress = userAddress;
 }

 public String getUsername() {
     return username;
 }

 public void setUsername(String username) {
     this.username = username;
 }

 public String getUserPassword() {
     return userPassword;
 }

 public void setUserPassword(String userPassword) {
     this.userPassword = userPassword;
 }

 public int getUserAge() {
     return userAge;
 }

 public void setUserAge(int userAge) {
     this.userAge = userAge;
 }

 public String getUserAddress() {
     return userAddress;
 }

 public void setUserAddress(String userAddress) {
     this.userAddress = userAddress;
 }
} 