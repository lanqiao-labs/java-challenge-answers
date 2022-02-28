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
        // 创建队列
        PriorityQueue<Student> queue = new PriorityQueue<Student>(11, new Comparator<Student>() {
            /**
             * 重写比较器方法
             */
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getScore() == o2.getScore()) {
                    return o1.getId() - o2.getId();
                }
                return o2.getScore() - o1.getScore();
            }
        });
        // 获取迭代器
        Iterator<Student> iterator1 = data.iterator();
        // 进行迭代，将数据导入队列
        while (iterator1.hasNext()){
            queue.add(iterator1.next());
        }
        // 输出移除信息
        for (int i = 0; i < 40; i++) {
            System.out.println(queue.remove());
        }

    }

    public static void main(String[] args) {
        initData();
        adjust();
    }

}