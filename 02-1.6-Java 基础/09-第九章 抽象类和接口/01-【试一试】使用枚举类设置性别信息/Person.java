/**
 * 人员信息类
 * @author 小桃子
 */
public class Person {
    // 声明属性
    private String name;
    private Sex sex;
    private int age;
    // 无参构造方法
    public Person() {
    }
    // 全参构造方法
    public Person(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    // getter/setter 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [age=" + age + ", name=" + name + ", sex=" + sex.getName() + "]";
    }
}