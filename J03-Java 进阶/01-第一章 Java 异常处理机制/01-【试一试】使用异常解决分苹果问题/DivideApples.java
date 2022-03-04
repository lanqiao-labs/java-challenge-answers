import java.util.Scanner;
import java.util.InputMismatchException;


public class DivideApples {    
    //苹果数
    int appleNum = 0; 
    //学生数
    int stuNum = 0;  
    public void divide() {
        System.out.println("**_现在给孩子们分苹果_**");
        Scanner input = new Scanner(System.in);
        try{
            System.out.print("请输入桌子上有几个苹果：");
            appleNum = input.nextInt();
            System.out.print("请输入班上有几个孩子：");
            stuNum = input.nextInt();
            System.out.println("班上每个孩子分得多少苹果：" + appleNum / stuNum);
            System.out.println("孩子们非常开心！");
        }catch(InputMismatchException e){
            System.out.println("苹果数量和孩子人数必须为整数值！");
        }catch(ArithmeticException e){
            System.out.println("孩子人数不能为零！");
        }
    }
    
    public static void main(String[] args) {
        new DivideApples().divide();
    }
}