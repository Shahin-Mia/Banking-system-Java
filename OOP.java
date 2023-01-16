package oop;

public class OOP {

    public static void main(String[] args) {
        Account a = new Account();
        a.display();
        Account b = new Account(1002, "demo", 200);
        b.display();
        Account c = new Account(a);
        c.display();
        Transaction t = new Transaction();
        t.setId(101);
        t.deposit(a, 5000);
        a.display();
        System.out.println(a);
        
        AccountTransfer t2 = new AccountTransfer();
        t2.setId(102);
        t2.transfer(a, b, 300);
        System.out.println(t2);
        b.display();
        
        System.out.println(a.hashCode());
        
        SavingAccount s = new SavingAccount();
        System.out.println(s.getLimit());
    }
    
}
