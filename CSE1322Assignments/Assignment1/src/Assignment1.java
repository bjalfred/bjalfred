//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: 1


import java.util.Scanner;


public class Assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // variables
        int appleInventory = 0;
        int orangeInventory = 0;
        double applePrice = 0;
        double orangePrice = 0;
        double balance=0;
        boolean running = true;
        System.out.println("[Fruit Management System]");

        // while loop
        while (running) {
            // menu
            System.out.println("1. Buy apples");
            System.out.println("2. Buy oranges");
            System.out.println("3. Sell apples");
            System.out.println("4. Sell oranges");
            System.out.println("5. Change price of apples");
            System.out.println("6. Change price of oranges");
            System.out.println("7. List inventory");
            System.out.println("8. Show balance");
            System.out.println("0. Quit");
            System.out.println("Enter option: ");
            int Option = scanner.nextInt();

            // switch case to set up menu
            switch (Option) {
                case 1:
                    System.out.print("Buy how many apples? $ ");
                    int appleAmount = scanner.nextInt();


                    // if appleamount=0
                    if (appleAmount==0){
                        System.out.print("Buying no apples.");
                        break;
                    }

                    // if apple amount is negative
                    while(appleAmount<0){
                        System.out.println("Invalid quantity. Enter a non-negative number:  ");
                        appleAmount= scanner.nextInt();
                        if(appleAmount==0){
                            System.out.println("Buying no apples.");
                            break;
                        }

                }
                    if (appleAmount==0){
                        break;
                    }

                    //if apple amount is valid
                    System.out.print("Buy apples at what price? $ ");
                    double aPrice = scanner.nextDouble();
                    System.out.println("Bought "+appleAmount+ " apples @ $"+ aPrice+ " for a total of $" +Math.round((appleAmount*aPrice)*100.00)/100.00);
                    appleInventory+=appleAmount;
                    balance-=aPrice*appleAmount;
                    break;
                case 2:
                    System.out.print("Buy how many oranges? ");
                    int orangeAmount = scanner.nextInt();

                    // if orangeamount=0
                    if (orangeAmount==0){
                        System.out.print("Buying no oranges.");
                        break;
                    }

                    // if orange amount is negative
                    while(orangeAmount<0){
                        System.out.println("Invalid quantity. Enter a non-negative number:  ");
                        orangeAmount= scanner.nextInt();
                        if(orangeAmount==0){
                            System.out.println("Buying no oranges.");
                            break;
                        }

                    }
                    if (orangeAmount==0){
                        break;
                    }

                    //if orange amount is valid
                    System.out.print("Buy oranges at what price? $ ");
                    double oPrice = scanner.nextDouble();
                    System.out.println("Bought "+orangeAmount+ " oranges @ $"+ oPrice+ " for a total of $" +Math.round((orangeAmount*oPrice)*100.00)/100.00);
                    orangeInventory+=orangeAmount;
                    balance-=oPrice*orangeAmount;
                    break;
                case 3:
                    System.out.println("Sell how many apples @ $"+applePrice);
                    int soldApples= scanner.nextInt();
                    while(soldApples<0) {
                        System.out.println("Enter a non-negative number of apples to sell: ");
                        soldApples = scanner.nextInt();
                        if (soldApples == 0) {
                            System.out.println("Selling no apples");
                            break;
                        }
                    }
                    if (soldApples==appleInventory){

                        System.out.println("Sold all apples @ $"+ applePrice+ "for a total of $"+applePrice*soldApples);
                        appleInventory-=soldApples;
                        balance+=soldApples*applePrice;
                        break;

                    }

                    if (soldApples > appleInventory) {
                        soldApples=appleInventory;
                        System.out.println("Not enough apples. Selling instead " + appleInventory + " apples @ $" + applePrice +" for a total of $"+ soldApples*applePrice);
                        appleInventory=0;
                        balance+=(applePrice*soldApples);
                        break;
                    }
                    if(soldApples==0){
                        break;
                    }

                    System.out.println("Sold "+ soldApples+ " apples @ $"+ applePrice+ " for a total of $"+ applePrice*soldApples);
                    appleInventory-=soldApples;
                    balance+=(applePrice*soldApples);
                    break;
                case 4:
                    System.out.println("Sell how many oranges @ $"+orangePrice);
                    int soldOranges= scanner.nextInt();
                    while(soldOranges<0) {
                        System.out.println("Enter a non-negative number of oranges to sell: ");
                        soldOranges = scanner.nextInt();
                        if (soldOranges == 0) {
                            System.out.println("Selling no oranges");
                            break;
                        }
                    }
                    if (soldOranges==orangeInventory){

                        System.out.println("Sold all oranges @ $"+ orangePrice+ " for a total of $"+orangePrice*soldOranges);
                        orangeInventory-=soldOranges;
                        balance+=soldOranges*orangePrice;
                        break;

                    }
                    if (soldOranges > orangeInventory) {
                        soldOranges=orangeInventory;
                        System.out.println("Not enough oranges. Selling instead " + orangeInventory + " oranges @ $" + orangePrice +" for a total of $"+ soldOranges*orangePrice);
                        orangeInventory=0;
                        balance+=(orangePrice*soldOranges);
                        break;
                    }
                    if(soldOranges==0){
                        break;
                    }
                    System.out.println("Sold "+ soldOranges+ "oranges @ $"+ orangePrice+ " for a total of $"+ soldOranges*orangePrice);
                    orangeInventory-=soldOranges;
                    balance+=soldOranges*orangePrice;
                    break;
                case 5:
                    System.out.println("What should be the new price of selling apples? $");
                    double appleSale= scanner.nextDouble();
                    while (appleSale<0){
                        System.out.println("Invalid price. Enter a non-negative price: $");
                        appleSale= scanner.nextDouble();
                    }
                    applePrice=appleSale;
                    System.out.println("Selling price of apples set @ $"+applePrice);
                    break;
                case 6:
                    System.out.println("What should be the new price of selling oranges? $");
                    double orangeSale= scanner.nextDouble();
                    while (orangeSale<0){
                        System.out.println("Invalid price. Enter a non-negative price: $");
                        orangeSale= scanner.nextDouble();
                    }
                    orangePrice=orangeSale;
                    System.out.println("Selling price of apples set @ $"+orangePrice);
                    break;
                case 7:
                    System.out.println("Current inventory is: ");
                    System.out.println(appleInventory+" apples currently selling @ $"+ applePrice);
                    System.out.println(orangeInventory+" oranges currently selling @ $"+ orangePrice);
                    break;
                case 8:
                    System.out.println("Current balance is $"+ balance);
                    break;
                case 0:
                    System.out.println("Shutting off...");
                    running=false;
            }
        }
    }
}