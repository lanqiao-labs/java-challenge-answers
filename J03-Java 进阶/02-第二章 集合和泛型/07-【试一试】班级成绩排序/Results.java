package org.lanqiao.main;

import org.lanqiao.entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;
import java.util.Comparator;

public class Results {
    // 学生集合
    public static List<Student> data = new ArrayList<Student>();
	// 学生人数
	public static int stuSize = 40 ;
    /**
     * 初始化集合内的数据
     */
    public static void initData(){
        int j = 1;
        // 创建随机数对象
        Random random = new Random();
        // 循环赋值
        for (int i = 0;i < stuSize;++i){
            data.add(new Student(180201+i,"同学"+(i+j),random.nextInt(51)+50));
        }
    }

    /**
	 * 显示学生信息
     * 输出集合内的数据
     */
    public static void print(){
          for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i));
        }
    }


    /**
     * 排序方法
     * 用于对集合进行排序
     */
    public static void adjust(){
        Collections.sort(data,new Comparator<Student>(){
            public int compare(Student s1,Student s2){
                if(s1.getScore()>s2.getScore()){
                    return -1;
                }else if(s1.getScore()<s2.getScore()){
                    return 1;
                }else {
                    if(s1.getId()>s2.getId()){
                        return 1;
                    }else{
                        return -1;
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        initData();
        adjust();
        print();
    }
   
}