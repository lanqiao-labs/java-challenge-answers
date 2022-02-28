package org.lanqiao.entity;

import org.lanqiao.exception.ScoreException;

public class Student {
    private String name;
    private double score;

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
   
    public double getScore() {
        return score;
    }
    
    public void setScore(double score) throws ScoreException {
        if(score<0||score>150){
            throw new ScoreException(score);
        }else{
            System.out.println("成绩设置为：" + score + "合理。");
            this.score = score;
        }
    }

    public Student(String name,double score) throws ScoreException {
        this.name = name;
        if(score<0||score>150){
            throw new ScoreException(score);
        }else{
            System.out.println("成绩设置为：" + score + "合理。");
            this.score = score;
        }
    }

    public Student(){
        
    }
}