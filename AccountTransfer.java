package oop;

public class AccountTransfer extends Transaction{
    Account accountTo;
    String tType = "Transfer";
    
    public void transfer(Account by, Account to, double am){
        setAccountTo(to);
        deposit(to, am);
        withdrown(by, am);
    }

    public Account getAccountTo() {
        return accountTo;
    }

    public void setAccountTo(Account accountTo) {
        this.accountTo = accountTo;
    }

    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }
    
    @Override
    public String toString(){
        return "Transaction id=" + getId() + ", date=" + getDate() + ", type=" + gettType() +", amount=" + getAmount() + "from "+ getAccount().getAccNo()+ "To "+ getAccountTo().getAccNo();
    }
    
    @Override
    public void show(){
        System.out.println("-------- Transaction ---------");
        System.out.println("Id " + getId());
        System.out.println("Date " + getDate());
        System.out.println("for Account No " + getAccount().getAccNo()+ " to "+ getAccountTo().getAccNo());
        System.out.println("Title " + getAccount().getTitle());
        System.out.println("Type "+ gettType());
        System.out.println("Amount "+ getAmount());
    }
    
}
