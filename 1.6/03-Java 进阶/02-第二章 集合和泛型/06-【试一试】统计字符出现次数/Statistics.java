package org.lanqiao.main;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class Statistics {

    public static HashMap<Character,Integer> statis(String str){
        // 创建 HashMap 用于储存统计后的数据
        HashMap<Character,Integer> map = new HashMap<>();
        // 将非字母的字符去掉
        str = str.replaceAll("[^a-zA-Z]", "");
        // 将字符串转为字符数组
        char[] arr = str.toCharArray();
        // 循环统计字母出现次数
        for(int i = 0; i < arr.length; i++){
            if(map.containsKey(arr[i])){
                Integer count = map.get(arr[i]);
                map.put(arr[i], count+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        // 创建控制台录入对象
        Scanner sc = new Scanner(System.in);
        // 接收控制台录入的字符串对象
        System.out.println("请输入一个字符串：");
        String str = sc.next();
        // 接收方法返回的集合
        HashMap<Character,Integer> map = statis(str);
        // 遍历集合 
        Set<Entry<Character,Integer>> entrySet = map.entrySet();
        for(Object obj : entrySet){
            System.out.println(obj);
        }
    }
}