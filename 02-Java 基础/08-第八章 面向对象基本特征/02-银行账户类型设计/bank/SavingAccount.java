public class SavingAccount extends Account {  //子类 储蓄账户
    private  static  double interest;  //年利率，私有静态

    public static double getInterest() {  //获取年利率属性
        return interest;
    }

    public static void setInterest(double interest) {  //设置年利率属性
        SavingAccount.interest = interest;
    }

    public SavingAccount(long id, String name, String password) {
        super(id, name, password);
    }

    public void countInterest(){    //计算利息并存入账户
        double interesty=this.balance * this.interest;
        this.deposit(interesty);

    }
}