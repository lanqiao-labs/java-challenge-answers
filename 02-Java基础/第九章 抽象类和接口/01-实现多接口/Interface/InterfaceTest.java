public class InterfaceTest{
    public static void main (String args[]){
        //实例化一个 NormalMan 对象，传入 name 参数，并调用实现的抽象方法打印相应的功能信息
        
        NormalMan nm=new  NormalMan("zhangsan");
        nm.breath();
        nm.hasSex();
        nm.eat();
        nm.think();
        nm.study();
    }
}