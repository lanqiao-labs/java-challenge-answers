/**
 * 定义一个测试类
 * @author lanqiao
 */
public class TestStock {
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL","Oracle Corporation",35,36);
        System.out.println(stock.getChangePercent());
    }
}