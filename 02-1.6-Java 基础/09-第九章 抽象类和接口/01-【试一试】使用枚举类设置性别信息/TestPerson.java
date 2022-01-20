/**
 * 测试类
 * @author 小桃子
 */
public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person("小李子", Sex.MALE, 10);
        System.out.println(p1);

        Person p2 = new Person();
        p2.setName("小桃子");
        p2.setSex(Sex.FEMALE);
        p2.setAge(20);
        System.out.println(p2);
    }
}