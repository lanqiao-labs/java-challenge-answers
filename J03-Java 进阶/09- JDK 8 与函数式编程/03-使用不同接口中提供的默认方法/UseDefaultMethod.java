/**
 * @author Teacher Tao
 */
public class UseDefaultMethod {
    public static void main(String[] args) {
        IModuleAService imas = new ModuleServiceImpl();
        imas.method1();
        imas.method2();
        imas.method();
        IModuleBService imbs = new ModuleServiceImpl();
        imbs.method3();
        imbs.method();
    }
}

interface IModuleAService{
    public void method1();   
    default void method2(){
        System.out.println("IModuleAService中的method2默认方法");
    }
    default void method(){
        System.out.println("IModuleAService中的method默认方法");
    }
}

interface IModuleBService{
    public void method3();
    default void method(){
        System.out.println("IModuleBService中的method默认方法");
    }
}

class ModuleServiceImpl implements IModuleAService, IModuleBService{

    @Override
    public void method3() {
        System.out.println("模块B中的method3方法实现");
    }

    @Override
    public void method1() {
        System.out.println("模块A中的method1方法实现");
    }

    @Override
    public void method() {
        IModuleAService.super.method();
    }

}