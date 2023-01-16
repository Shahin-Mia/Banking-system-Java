package oop;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author shahin
 */
public class SavingAccount extends Account {

    SimpleDateFormat dt = new SimpleDateFormat("DD-mm-YYYY");
    private String acctype = "Saving ";
    private double rate;
    private int limit = 1;

    public SavingAccount() {
        super();
    }

    public SavingAccount(int accNo, String title, double balance) {
        super(accNo, title, balance);
    }

    public SavingAccount(Account account, int limit) {
        super(account);
        this.limit = limit;
    }

    public SimpleDateFormat getDt() {
        return dt;
    }

    public void setDt(SimpleDateFormat dt) {
        this.dt = dt;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    
    public int count(){
        int n = 0;
        for(Transaction t:getTransactions()){
            if(dt.format(t.getDate()).equals(dt.format(new Date()))){
                n++;
            }
        }
        return n;
    }
    
    @Override
    public void withdrown(double amount){
        if(limit > count()){
            super.withdrown(amount);
        } else {
            System.out.println("Out of limit");
            getTransactions().remove(getTransactions().size()-1);
        }
    }
    
    @Override
    public void display(){
        System.out.println(getAcctype());
        super.display();
    }
}
