public class AccountTest{
    public static void main(String args[]){
        SavingAccount sa=new SavingAccount(100003,"李四","123456");
        sa.deposit(10000);  //存款10000
        sa.setInterest(0.004); //设置利率
        sa.countInterest();  //将利息存入账户
        sa.withdraw(2000); //取款2000
        sa.query(); //查询当前账号、姓名、余额 余额应为8040
        CreditAccount ca=new CreditAccount(100005,"王五","123123",10000,8000);
        ca.deposit(4000); //存款4000
        ca.purchase(3000); //消费3000
        ca.withdraw(6000);// 剩余1000加上透支额度10000后大于取款金额6000，并且取款金额6000小于限制的取现金额8000 可以提现，取款后账户-5000

    }
}