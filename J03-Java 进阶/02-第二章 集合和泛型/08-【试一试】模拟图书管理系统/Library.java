package org.lanqiao.main;

import org.lanqiao.entity.Book;

import java.util.HashSet;
import java.util.Scanner;

public class Library {
    static HashSet<Book> books = new HashSet<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while(true){
            System.out.println("------欢迎来到蓝桥图书馆------");
            System.out.println("1.添加图书");
            System.out.println("2.查询图书");
            System.out.println("3.删除图书");
            System.out.println("4.退出程序");
            System.out.println("请输入选项：");
            int i = sc.nextInt();
            switch (i){
                case 1 :
                    addBook();
                    break;
                case 2:
                    selectBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    System.out.println("退出成功");
                    System.exit(0);
                    break;
            }
        }
    }

    public static void deleteBook() {
        // 通过图书id删除图书
        System.out.println("请输入要删除的图书id：");
        int id = sc.nextInt();
        // 循环遍历所有图书
        for(Book b : books){
            // 比较图书 id 和输入的id，若一致则从容器中删除该图书
            if(b.getId()==id){
                books.remove(b);
            }
        }
        System.out.println("删除成功！");
    }

    public static void selectBook() {
        
        if(books.size()==0){
            System.out.println("没有图书！");
            return;
        }
        // 使用增强 for 循环输出所有图书信息
        System.out.println("以下为所有图书信息！");
        for(Book b : books){
            System.out.println(b);
        }
        
    }

    public static void addBook() {
        // 输入图书信息
        System.out.println("请输入图书id：");
        int id = sc.nextInt();
        System.out.println("请输入书名：");
        String name = sc.next();
        System.out.println("请输入作者名");
        String author = sc.next();
        System.out.println("请输入价格");
        double price = sc.nextDouble();
        // 创建对象
        Book book = new Book(id,name,author,price);
        // 添加图书
        books.add(book);
        System.out.println("添加成功！");
    }
}