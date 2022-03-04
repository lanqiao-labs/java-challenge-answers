package org.lanqiao.main;

import org.lanqiao.entity.Student;

import java.util.*;

public class Results {
    // 学生集合
    public static List<Student> data = new ArrayList<Student>();

    /**
     * 初始化集合内的数据
     */
    public static void initData(){
        int j = 1;
        // 创建随机数对象
        Random random = new Random();
        // 循环赋值
        for (int i = 0;i < 40;++i){
            data.add(new Student(180201+i,"同学"+(i+j),random.nextInt(51)+50));
        }
    }

    /**
     * 排序方法
     * 用于对集合进行排序
     */
    public static void adjust(){
		//重写排序规则
        Collections.sort(data,new Comparator<Student>(){
            @Override
            public int compare(Student a, Student b) {
                if (a.getScore() == b.getScore()) {
                    return a.getId() - b.getId();
                }
                return b.getScore()-a.getScore();
            }
               
           } );
       
    }
	/**
	 * 打印方法
     * 用于对集合进行遍历
     */
	public static void  print() {
        for(int i=0;i<data.length;i++){
          System.out.println(data.get(i));
        }
    }
    public static void main(String[] args) {
        initData();
        adjust(); 
        print();
    }
    
}