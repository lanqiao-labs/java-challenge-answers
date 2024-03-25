package bank;
public class Account {
    private long id;  //账户id
    private String name;  //客户姓名
    private String password="000000";  //账户密码：初始密码为“000000”
    private double balance;  //账户余额

   
    public Account() {
      
    }
    public Account(long id, String name, String password, double balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public void deposit(double cash){  //存款
        System.out.println("======存款操作======");
        System.out.println("现存入："+cash);
        balance=this.balance+cash;    //余额自动计算
        System.out.println("现余额："+ this.balance+"\n");

    }

    public void withdraw(double cash){  //取款
        System.out.println("======取款操作======");
        System.out.println("现支出："+cash);
        balance=this.balance-cash;    //余额自动计算
        System.out.println("现余额："+ this.balance+"\n");

    }

    public void query(){  //查询
        System.out.println("======查询操作======");
        System.out.println("账号："+this.id);
        System.out.println("姓名："+ this.name);
        System.out.println("余额："+ this.balance+"\n");

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
}
