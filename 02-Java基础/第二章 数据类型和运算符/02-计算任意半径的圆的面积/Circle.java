import java.util.Scanner;
public class Circle{
    
    public static void main(String[] args) {
        int r;
        final double PI=3.14;
        double S;
        Scanner input = new Scanner(System.in);
        System.out.print("请输入圆的半径：");
        r = input.nextInt();
        S=PI*r*r;
        System.out.print("圆的面积为："+S);
    }   
}
