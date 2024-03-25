package bank;
public class CreditAccount  extends Account{  //子类 信用账户类
    private double ceiling;  //透支额度
    private double money; //取现额度

    public CreditAccount() {
        
    }

    public CreditAccount(double ceiling, double money) {
        this.ceiling = ceiling;
        this.money = money;
    }
    public CreditAccount(long id, String name, String password, double balance, double ceiling, double money) {
        super(id, name, password, balance);
        this.ceiling = ceiling;
        this.money = money;
    }
    public double getCeiling() {
        return ceiling;
    }
    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }
    public void purchase(double payment){    //刷卡消费
        System.out.println("您的卡号为："+this.getId());
        System.out.println("刷卡消费："+payment);
        if((this.getBalance()+this.ceiling-payment)>0){  //可以透支
            this.setBalance(this.getBalance()-payment); //计算余额
            System.out.println("最终余额为："+this.getBalance()+"\n");
        }else {
            System.out.println("超过透支额度！此次刷卡无效! \n");
        }
    }
    public void withdraw(double cash){   //重写父类的取款方式
        if((this.getBalance()+ceiling-cash)>0&&cash<=money){   //可以透支
            super.withdraw(cash);
        }else{
            System.out.println("\n 取现失败！\n 超过透支额度或取现额度 \n");
        }
    }
}
