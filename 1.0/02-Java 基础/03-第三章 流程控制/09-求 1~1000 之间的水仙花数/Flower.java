public class Flower{
public static void main(String[] args) {
   for( int i=100;i<1000;i++){   //水仙花数的位数要 >=3.
       int a=i/100; //得到百位的数字
       int b=(i/10)%10;  //得到十位的数字
       int c=i%10;  //得到各位的数字
       if(i==a*a*a+b*b*b+c*c*c){  //判断是否符合水仙花数的性质
           System.out.print(i + " ");
       }

   }
    }
}
