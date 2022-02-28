/**
 * 创建图书测试类 BookTest
 * @author lanqiao
 */
public class BookTest {

    public static void main(String args[]){
        Book book = new Book();

        book.name = "Java 基础"; // 添加书名
        book.author = "lanqiao";// 添加作者
        book.price = 60.8;// 添加价格

        book.print(); //输出书的信息
    }
}