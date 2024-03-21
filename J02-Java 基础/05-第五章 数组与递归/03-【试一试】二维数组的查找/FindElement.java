import java.util.Scanner;

public class FindElement{
  public static int[][] array={{1,2,8,9},
                    {2,4,9,12},
                    {4,7,10,13},
                    {6,8,11,15}
                };
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
                
        System.out.println("请输入想要查找的数字：");
        int num=sc.nextInt();
        boolean b=findElement(array, num);
        System.out.println(b);
    }
    public static boolean findElement(int[][] arr,int num){
        if (arr==null || arr.length==0 ||arr[0].length==0) {
            return false;
        }
        for (int i = 0,j=arr[i].length-1;  i<arr.length && j>=0;) {
            if (num>arr[i][j]) {
                i++;
            }else if(num<arr[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
}
