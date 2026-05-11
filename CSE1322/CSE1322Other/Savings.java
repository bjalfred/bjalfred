//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Savings class

public class Savings extends Account {
    private int numberOfDeposits=0;

    Savings(double newBalance){
        accountBalance = newBalance;

    }
    @Override
    public double withdraw(double getMoney){
        if (accountBalance<500){
            System.out.println("Charging a fee od $10 because you are below $500");
            accountBalance-=getMoney;
            accountBalance-=10;
            return accountBalance;
        }
        else{
            accountBalance-=getMoney;
            return accountBalance;

        }

    }

    @Override
    public double deposit(double addMoney){
        if (numberOfDeposits<5){
            numberOfDeposits+=1;
            System.out.println("This is deposit " + numberOfDeposits + " to this account");
            accountBalance+=addMoney;
            return accountBalance;

        }
        else if (numberOfDeposits>5){
            System.out.println("Charging a fee of $10");
            accountBalance+=addMoney;
            accountBalance-=10;
            return accountBalance;
        }
        return accountBalance;
    }

    public double addInterest(){
        double interest= accountBalance*0.015;
        System.out.println("Cuustomer has earned $" + interest + " in interest.");
        deposit(interest);
        return accountBalance;
    }

    @Override
    public String toString(){
        return "Savings account #" +accountNumber + ", balance $" + accountBalance;
    }
}
