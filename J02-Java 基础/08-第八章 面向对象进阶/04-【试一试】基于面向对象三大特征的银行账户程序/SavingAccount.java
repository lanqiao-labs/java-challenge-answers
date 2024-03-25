package bank;
public class SavingAccount  extends Account{  //子类 储蓄账户
    private  double interest;  //年利率

 
    public void countInterest(){    //计算利息并存入账户
        double interesty=this.getBalance() * this.interest;
        this.deposit(interesty);
    }


    public SavingAccount(double interest) {
        this.interest = interest;
    }

    public SavingAccount( ) {
       
    }

    public SavingAccount(long id, String name, String password, double balance, double interest) {
        super(id, name, password, balance);
        this.interest = interest;
    }


    public double getInterest() {
        return interest;
    }


    public void setInterest(double interest) {
        this.interest = interest;
    }
}
