//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Lab 11


import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[BlueRay Disk Collection]");
        boolean running = true;
        BlueRayCollection collection = new BlueRayCollection();

        while (running) {
            System.out.println("1. Add to collection");
            System.out.println("2. See collection");
            System.out.println("3. Quit");

            System.out.println("Enter option: ");
            int Option = scanner.nextInt();

            switch (Option) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter disk title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter director name:");
                    String director = scanner.nextLine();


                    System.out.println("Enter year of release:");
                    int year;
                    try{
                        year = scanner.nextInt();
                    }
                    catch(InputMismatchException e){
                        System.out.println("Year of release must be a whole number!");
                        scanner.nextLine();
                        continue;
                    }

                    System.out.println("Enter price of disk: $");
                    double price;
                    try{
                    price = scanner.nextDouble();}
                    catch (InputMismatchException e){
                        System.out.println("Price must be a number");
                        scanner.nextLine();
                        continue;
                    }

                    collection.addDisk(title, director, year, price);
                    System.out.println("BlueRay Disk added to collection.");

                    break;
                case 2:
                    if (collection.showAll().isEmpty()) {
                        System.out.println("BlueRay collection is empty");
                    } else {
                        System.out.println(collection.showAll());
                    }
                    break;
                case 3:
                    System.out.println("Shutting off...");
                    running = false;
            }
        }
    }
}