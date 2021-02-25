public class Account { //父类 
    long id;  //账户id
    String name;  //客户姓名
    String password="000000";  //账户密码：初始密码为“000000”
    double balance;  //账户余额

    public long getId() {       //获取账户id 属性
        return id;
    }

    public void setId(long id) {   //设置账户id属性
        this.id = id;
    }

    public String getName() {    //获取客户姓名属性
        return name;
    }

    public void setName(String name) {     //设置客户姓名属性
        this.name = name;
    }

    

    public void setPassword(String password) {    //设置账户密码
        this.password = password;
    }

    public Account(long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Account(){
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
    
    
}
