
public class DataException {

    // 数据获取
    public void getData(Object[] objs){

        IModuleService  is [] = new IModuleService [6]; 
        if(is.length!=objs.length){
            throw new ArrayIndexOutOfBoundsException("参数 objs 数组个数未达到 6 ！");
        }
        for(int i=0;i<is.length;i++){
            if(objs[i]==null){
                continue;
            }
            if(objs[i] instanceof AService){
                is[i]=(AService) objs[i];
                is[i].method1();
                ((AService) is[i]).methodA();
            }else  if(objs[i] instanceof BService){
                is[i]=(BService) objs[i];
                is[i].method1();
                ((BService) is[i]).methodB();
            }else{
               // throw new ClassCastException("参数传入的数据类型不正确，不是 IModuleService 接口子类！");
               System.out.println("参数传入的数据类型不正确，不是 IModuleService 接口子类！");
            }
        }

    }

    public static void main(String[] args){
        DataException de = new DataException();
        de.getData(new Object[]{new BService(), new AService(), new BService(), new AService() , new BService(), new AService()});
        System.out.println("-----------------");
        de.getData(new Object[]{new BService(), new AService(), new BService(), new AService() , new String(), new BService()});
        System.out.println("-----------------");
        de.getData(new Object[]{new BService(), new AService(), new BService(), new AService()});
    }
}


interface IModuleService{
    void method1();
}
class AService implements IModuleService{
    @Override
    public void method1() {
        System.out.println("AService");
    }
    public void methodA(){
        System.out.println("AService methodA()");
    }
}
class BService implements IModuleService{
    @Override
    public void method1() {
        System.out.println("BService");
    }
    public void methodB(){
        System.out.println("BService methodB()");
    }
}
