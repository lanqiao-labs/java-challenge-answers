/**
 * 创建图书类 Book
 * @author lanqiao
 */
public class Book{
    // 类的属性
    String name; // 书名
    String author;// 作者
    double price; // 价格

    /**
     * 输出书的信息
     */
    public void print(){
        System.out.println("书名：" + name + "，作者：" + author + "，价格：" + price);
    }
}