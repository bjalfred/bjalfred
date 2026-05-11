//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab:4


import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
       ParkWallet.setTickets(100);

       boolean running = true;
       System.out.print("[Theme Park Wallet Manager]");

       Scanner scanner= new Scanner(System.in);

       while (running) {
           System.out.println("1. Add tickets");
           System.out.println("2. Set tickets");
           System.out.println("3. Buy prize");
           System.out.println("4. Set Holiday");
           System.out.println("5. Quit");

           System.out.println("Your wallet has "+ ParkWallet.getTicketCount()+ " tickets");
           System.out.println("Enter Option: ");
           int Option= scanner.nextInt();

           switch(Option){
               case 1:
                   System.out.print("Add how many tickets? ");
                   int ticketCount = scanner.nextInt();
                   ParkWallet.addTickets(ticketCount);
                   System.out.println("Your wallet has "+ ParkWallet.getTicketCount()+ " tickets");
                   break;
               case 2:
                   System.out.println("Set ticket balance to: ");
                   int newTickets = scanner.nextInt();
                   ParkWallet.setTickets(newTickets);
                   System.out.println("Your wallet has "+ ParkWallet.getTicketCount()+ " tickets");
                   break;
               case 3:
                   if (!ParkWallet.holidayStatus()) {
                       System.out.println("1. T-shirt (150 tickets)");
                       System.out.println("2. Sun hat (350 tickets)");
                       System.out.println("3. Sneakers (600 tickets)");

                       System.out.println("Buy which prize? ");
                       int choice = scanner.nextInt();

                       if (choice == 1 && ParkWallet.removeTickets(150)) {
                           System.out.println("You bought a T-shirt for 150 tickets");

                       } else if (choice == 1 && !ParkWallet.removeTickets(150)) {
                           System.out.println("Not enough tickets for a T-shirt");
                       }
                       if (choice == 2 && ParkWallet.removeTickets(350)) {
                           System.out.print("You bought a sun hat for 350 tickets");

                       } else if (choice == 2 && !ParkWallet.removeTickets(350)) {
                           System.out.println("Not enough tickets for a sun hat");
                       }
                       if (choice == 3 && ParkWallet.removeTickets(600)) {
                           System.out.println("You bought sneakers for 600 tickets");

                       } else if (choice == 3 && !ParkWallet.removeTickets(600)) {
                           System.out.println("Not enough tickets for sneakers");
                       }
                   }
                   else{
                       System.out.println("1. T-shirt (75 tickets)");
                       System.out.println("2. Sun hat (175 tickets)");
                       System.out.println("3. Sneakers (300 tickets)");

                       System.out.println("Buy which prize? ");
                       int choice = scanner.nextInt();

                       if (choice == 1 && ParkWallet.removeTickets(75)) {
                           System.out.println("You bought a T-shirt for 75 tickets");

                       } else if (choice == 1 && !ParkWallet.removeTickets(75)) {
                           System.out.println("Not enough tickets for a T-shirt");
                       }
                       if (choice == 2 && ParkWallet.removeTickets(175)) {
                           System.out.print("You bought a sun hat for 175 tickets");

                       } else if (choice == 2 && !ParkWallet.removeTickets(175)) {
                           System.out.println("Not enough tickets for a sun hat");
                       }
                       if (choice == 3 && ParkWallet.removeTickets(300)) {
                           System.out.println("You bought sneakers for 300 tickets");

                       } else if (choice == 3 && !ParkWallet.removeTickets(300)) {
                           System.out.println("Not enough tickets for sneakers");
                       }

                   }
               break;
               case 4:
                   ParkWallet.setHoliday();
                   if (ParkWallet.holidayStatus()){
                       System.out.println("It is now a holiday");
                   }
                   else{
                       System.out.println("It is no longer a holiday");
                   }
                   break;
               case 5:
                   System.out.println("Shutting off...");
                   running = false;

           }


       }
    }
}