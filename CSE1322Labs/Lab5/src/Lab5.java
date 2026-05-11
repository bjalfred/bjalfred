//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: 5

import java.util.Scanner;

public class Lab5 {
    public static void main(String[] args) {

        Checking newChecking= new Checking(0);
        Savings newSavings= new Savings(500);
        Scanner scanner= new Scanner(System.in);

        System.out.println("[Banking System]");

        boolean running=true;

        while (running){

            System.out.println("1. Withdraw from Checking");
            System.out.println("2. Withdraw from Savings");
            System.out.println("3. Deposit to Checking");
            System.out.println("4. Deposit to Savings");
            System.out.println("5. Balance of Checking");
            System.out.println("6. Balance of Savings");
            System.out.println("7. Award Interest to Savings");
            System.out.println("8. Quit");

            System.out.println("Select option: ");
            int Option= scanner.nextInt();

            if (Option>=9|| Option<=0){
                System.out.println("Invalid option.");
            }

            switch (Option){
                case 1:
                    System.out.println("How much would you like to withdraw from Checking? $");
                    double checkWithdraw= scanner.nextDouble();
                    newChecking.withdraw(checkWithdraw);
                    System.out.println("Current balance of Checking is $" + newChecking.getAccountBalance());
                    break;
                case 2:
                    System.out.println("How much would you like to withdraw from Checking? $");
                    double saveWithdraw= scanner.nextDouble();
                    newSavings.withdraw(saveWithdraw);
                    System.out.println("Current balance of Savings is $" + newSavings.getAccountBalance());
                    break;
                case 3:
                    System.out.println("How much would you like to deposit to Checking? $");
                    double checkDeposit= scanner.nextDouble();
                    newChecking.deposit(checkDeposit);
                    System.out.println("Current balance of Checking is $" + newChecking.getAccountBalance());
                    break;
                case 4:
                    System.out.println("How much would you like to deposit to Savings? $");
                    double saveDeposit= scanner.nextDouble();
                    newSavings.deposit(saveDeposit);
                    System.out.println("Current balance of Savings is $" + newSavings.getAccountBalance());
                    break;
                case 5:
                    System.out.println(newChecking.toString());
                    break;
                case 6:
                    System.out.println(newSavings.toString());
                    break;
                case 7:
                    //System.out.println(newSavings.addInterest());
                    break;
                case 8:
                    System.out.println("Shutting off...");
                    running=false;
                    break;

            }

        }



        }
    }
