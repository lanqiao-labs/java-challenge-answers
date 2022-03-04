package org.lanqiao.pojo;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

public class Student implements Serializable{
    //学号
    @TableId
    private int stuNo;
    //姓名
    private String stuName;
    //年龄
    private int stuAge;
    //年级
    private String graName;
    
    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }
   // 性别的 getter 、setter 方法 

     public int getStuAge() {
        return stuAge;
    }

    public void setStuAge(int stuAge) {
        this.stuAge = stuAge;
    }

    public String getGraName() {
        return graName;
    }

    public void setGraName(String graName) {
        this.graName = graName;
    }

    //为了方便地输出对象中的内容，重写toString()方法
    @Override
    public String toString()	{
        return   "学号:"+this.stuNo+"\t姓名:"+this.stuName
            +"\t年龄:"+this.stuAge+"\t年级:"+this.graName;
    }

}