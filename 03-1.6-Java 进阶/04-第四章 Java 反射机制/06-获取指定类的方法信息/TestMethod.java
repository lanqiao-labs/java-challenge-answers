import java.lang.reflect.*;
public class TestMethod {
    public static void main(String args[]) {
        try {
            Class c = Class.forName("User");
            //返回Method对象数组，存放该类或接口的所有方法（不含继承的）
            Method mlist[] = c.getDeclaredMethods();
            System.out.println("User类getDeclaredMethods()得到的方法如下：");
            //遍历所有方法
            for (int i = 0; i < mlist.length; i++) {
                System.out.println("===================================");
                Method m = mlist[i];
                System.out.println("方法" + (i + 1) + "名称为：" + m.getName());//得到方法名
                System.out.println("该方法所在的类为：" + m.getDeclaringClass());
                
                System.out.println("返回值类型为：" + m.getReturnType());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}