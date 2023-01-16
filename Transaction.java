package oop;

import java.util.Date;

public class Transaction {
    private int id;
    private Date date;
    private String type;
    private double amount;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    public void deposit(Account account, double am){
        type = "Deposit";
        date = new Date();
        setAmount(am);
        setAccount(account);
        account.deposit(am);
        account.getTransactions().add(this);
    }
    
    public void withdrown(Account account, double am){
        if(account.getBalance()>am){
            type = "Withdrown";
            date = new Date();
            setAmount(am);
            setAccount(account);
            account.withdrown(am);
            account.getTransactions().add(this);
        } else {
            System.out.println("... Insufficent Balance ...");
        }
    }
    
    public void show(){
        System.out.println("-------Transaction-------");
        System.out.println("Id: " + getId());
        System.out.println("Date: " + getDate());
        System.out.println("Account No: " + getAccount().getAccNo());
        System.out.println("Title: " + getAccount().getTitle());
        System.out.println("Type: " + getType());
        System.out.println("Amount: " + getAmount());
    }
    
    @Override
    public String toString(){
        return "Transaction id=" + id + ", date=" + date + ", type=" + type + ", amount=" + amount + '\n';
    }
}
