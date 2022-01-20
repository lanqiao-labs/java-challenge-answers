import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * @author Teacher Tao
 */
public class DivideApplesThrows {
    
    //苹果数
    int appleNum = 0; 
    //学生数
    int stuNum = 0;  
    
    Scanner input = new Scanner(System.in);
    
    public void divide() throws RuntimeException{
        System.out.println("**_现在给孩子们分苹果_**");
        System.out.print("请输入桌子上有几个苹果：");
        appleNum = input.nextInt();
        if(appleNum == 0) {
            throw new RuntimeException("苹果数量不能为零，否则孩子们要失望了");
        }
        System.out.print("请输入班上有几个孩子：");
        stuNum = input.nextInt();
        System.out.println("班上每个孩子分得多少苹果：" + appleNum / stuNum);
        System.out.println("孩子们非常开心！");
    }
    
    public void scannerClose() {
        input.close();
        System.out.println("Scanner 对象进行释放");
    }
    
    public static void main(String[] args) {
        DivideApplesThrows dat = new DivideApplesThrows();
        try {
            dat.divide();
        }catch(InputMismatchException e) {
            System.out.println("苹果数量和孩子人数必须为整数值");
        }catch(ArithmeticException e) {
            System.out.println("孩子人数不能为零");
        }catch(RuntimeException e) {
            System.out.println(e.getMessage());     
        }finally {
            dat.scannerClose();
        }
        
    }

}
