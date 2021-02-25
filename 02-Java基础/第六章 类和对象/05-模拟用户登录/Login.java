public class Login{
    private String userName;//用户名
    private int Password;//用户密码

    
    
   
    public void isvaildUser(String userName,int  Password){
        
        if(userName.equals("admin")&& Password==123456){
            System.out.println("登录成功");
        
        }else{
            System.out.println("用户名或密码错误");
        }
           
    }
    public void isvaildUser(String userName){
        System.out.println("密码为空");
    }
    public void isvaildUser(int Password){
        System.out.println("用户名为空");
    }
    public void isvaildUser(){
        System.out.println("用户名和密码都为空");
    }

    public static void main(String args[]){
        Login login=new Login();
        login.isvaildUser("admin",123456);
        login.isvaildUser("admin");
        login.isvaildUser(123456);
        login.isvaildUser("admin",123);
        login.isvaildUser();

    }
   
}