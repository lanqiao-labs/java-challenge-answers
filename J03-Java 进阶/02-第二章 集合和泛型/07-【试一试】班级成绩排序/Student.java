package org.lanqiao.entity;

public class Student {
    // 学号
    private int id;
    // 姓名
    private String name;
    // 成绩
    private int score;

    public Student(){
       
    }

    public Student(int id,String name,int score){
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public void setId(int id) {
        this. id=id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
    public void setScore(int score) {
        this.score=score;
    }

    public String toString() {
        return "学号：" + id +
                ", 姓名：" + name  +
                ", 成绩：" + score ;
    }
}