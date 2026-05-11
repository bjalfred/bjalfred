//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Checking Class

public class Checking extends Account {
    Checking(double newBalance){
        accountBalance = newBalance;

    }
    @Override
    public double withdraw(double getMoney){
        if (getMoney>accountBalance ) {
            System.out.println("Charging an overdraft fee of $20 because the account is below $0");
            accountBalance-=getMoney;
            accountBalance-=20;
            return accountBalance;
        }
        else {
            accountBalance-=getMoney;
            return accountBalance;
        }
    }

    @Override
    public String toString(){
        return "Checking account #" + accountNumber +", balance $" +accountBalance;
    }



}
