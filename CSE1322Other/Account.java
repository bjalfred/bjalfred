//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Account Class

public class Account {
   protected int accountNumber;
    public static int nextNumber=10001;
    protected double accountBalance;

    public Account(){
        accountNumber=nextNumber;
        nextNumber+=1;
        accountBalance=0;
    }
    public Account(double newBalance){
        nextNumber=accountNumber;
        nextNumber+=1;
        accountBalance = newBalance;
    }
    public double withdraw(double getMoney) {
        accountBalance -= getMoney;
        return accountBalance;
    }

    public double deposit(double addMoney){
        accountBalance+=addMoney;
        return accountBalance;
    }

    double getAccountBalance(){
        return accountBalance;
    }

    double getAccountNumber(){
        return accountNumber;
    }

    @Override
    public String toString(){
        return "Account #" +getAccountNumber() +", balance $" + getAccountBalance();
    }



}
