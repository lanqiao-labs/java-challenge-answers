import java.util.Scanner;

public class Login {
  public static void main(String[] args) {
      // 创建控制台输入需要的对象
      Scanner scanner = new Scanner(System.in);
      // 从控制台接收用户名和密码
      System.out.println("请输入用户名：");
      int userName = scanner.nextInt();
      System.out.println("请输入密码：");
      int pwd = scanner.nextInt();
      // 判断用户名是否正确
      if(userName!=123456){
          System.out.println("用户名错误！");
      // 判断密码是否正确
      }else if(pwd!=123456){
          System.out.println("密码错误！");
      }else{
          System.out.println("登录成功！");
      }
  }
}