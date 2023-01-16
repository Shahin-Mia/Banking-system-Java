package oop;

import java.util.ArrayList;
import java.util.Objects;

public class Account {
    private int accNo;
    private String title;
    private double balance;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transaction) {
        this.transactions = transaction;
    }

    public Account() {
        System.out.println("Default Constructor");
        title = "Test";
        balance = 500;
        accNo = 1001;
    }

    public Account(int accNo, String title, double balance) {
        System.out.println("Argument Constructor");
        this.accNo = accNo;
        this.title = title;
        this.balance = balance;
    }
    
    public Account(Account account){
        System.out.println("---Copy Constructor---");
        setAccNo(account.getAccNo());
        setTitle(account.getTitle());
        setBalance(account.getBalance());
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    public void deposit(double amount){
        this.balance += amount;
    }
    
    public void withdrown(double amount){
        this.balance -= amount;
    }
    
    public void display(){
        System.out.println("Account No          :" + getAccNo());
        System.out.println("Account Title       :" + getTitle());
        for(Transaction transaction: transactions){
            System.out.println(transaction);
        }
        System.out.println("Account Balance     :" + getBalance());  
    }
    
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return """
               Account Information 
               accNo=""" + accNo + "\ntitle=" + title + "\nbalance="+ balance;
    }
    
    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj){
        if(obj != null && obj instanceof Account){
            Account a = (Account) obj;
            if(this.accNo==a.getAccNo() && this.title.equals(a.getTitle())){
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return accNo+title.hashCode() + (int)balance/accNo;
    }
}
