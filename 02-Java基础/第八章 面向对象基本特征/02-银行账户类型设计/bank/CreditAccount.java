public class CreditAccount extends Account { //子类 信用账户类
    private double ceiling;  //透支额度
    private double money; //取现额度

    public double getCeiling() {
        return ceiling;
    }

    public void setCeiling(double ceiling) {
        this.ceiling = ceiling;
    }

    

    public CreditAccount(long id, String name, String password, double ceiling, double money) {
        super(id, name, password);
        this.ceiling = ceiling;
        this.money = money;
    }

    public void purchase(double payment){    //刷卡消费
        System.out.println("您的卡号为："+this.id);
        System.out.println("刷卡消费："+payment);
        if((this.balance+this.ceiling-payment)>0){  //可以透支
            this.balance=this.balance-payment; //计算余额
            System.out.println("最终余额为："+this.balance+"\n");
            
        }else {
            System.out.println("超过透支额度！此次刷卡无效! \n");
        }

    }
    public void withdraw(double cash){   //重写父类的取款方式
        if((balance+ceiling-cash)>0&&cash<=money){   //可以透支
            super.withdraw(cash);
            
        }else{
            System.out.println("\n 取现失败！\n 超过透支额度或取现额度 \n");
        }
        
    }
}
