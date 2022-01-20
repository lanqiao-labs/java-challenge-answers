/**
 * 存储性别信息的枚举类
 * @author 小桃子
 */
public enum Sex{
    MALE(1, "男"), FEMALE(0, "女");
    // 声明序号
    private int value;
    // 声明名称
    private String name;
    // 声明构造方法
    private Sex(int value, String name){
        this.value = value;
        this.name = name;
    }
    // 获取序号信息
    public int getValue(){
        return value;
    }
    // 获取名称信息
    public String getName(){
        return name;
    }
}