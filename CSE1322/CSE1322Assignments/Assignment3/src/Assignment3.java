//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Assignment 3

import java.util.ArrayList;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        ArrayList<Item> Items= new ArrayList<>();
        Scanner scanner= new Scanner(System.in);

        boolean running=true;
        System.out.println("[VaporStore Item System]");
        boolean multiplayer;

        while (running){
            System.out.println("1. Add Video Game");
            System.out.println("2. Add Development Kit");
            System.out.println("3. Add Tradable");
            System.out.println("4. Add Collectable");
            System.out.println("5. List all items");
            System.out.println("6. Update price");
            System.out.println("7. Quit");

            System.out.println("Enter option: ");
            int Option= scanner.nextInt();

            switch (Option){
                case 1:
                    System.out.println("Enter name of item: ");
                    scanner.nextLine();
                    String name= scanner.nextLine();

                    System.out.println("Enter price of item: $");
                    Double price= scanner.nextDouble();


                    System.out.println("Enter name of publisher: ");
                    scanner.nextLine();
                    String publisher= scanner.nextLine();

                    System.out.println("Does this game have multiplayer support? ");
                    String multiCheck = scanner.nextLine();

                    multiCheck=multiCheck.toLowerCase();

                    if (multiCheck.equals("yes")){
                        multiplayer=true;
                    }
                    else{
                        multiplayer=false;
                    }

                    Item game= new VideoGame(name,price,publisher,multiplayer);
                    Items.add(game);
                    System.out.println("Item added.");

                    break;
                case 2:

                    ArrayList<String> newTargets= new ArrayList<>();

                    System.out.println("Enter name of item: ");

                    scanner.nextLine();
                    name = scanner.nextLine();

                    System.out.println("Enter price of item: $");
                    price=scanner.nextDouble();

                    System.out.println("Enter name of publisher: ");
                    scanner.nextLine();
                    publisher= scanner.nextLine();

                    System.out.println("Enter the name of each supported platform, one per line. Enter an empty line when done. ");
                    String platformList;

                    while (running) {
                        platformList = scanner.nextLine();
                        if (platformList.isEmpty()) {
                            break;
                        }
                    }

                    Item devKit= new DevelopmentKit(name,price,publisher,newTargets);
                    Items.add(devKit);

                    System.out.println("Item added.");

                    break;
                case 3:
                    System.out.println("Enter name of item: ");
                    scanner.nextLine();
                    name= scanner.nextLine();

                    System.out.println("Enter price of item: $");
                    price= scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter item's description: ");
                    scanner.nextLine();
                    String description= scanner.nextLine();

                    System.out.println("How many days before this item can be resold? ");
                    int resell=scanner.nextInt();
                    scanner.nextLine();

                    Item trade = new Tradable(name,price, description, resell);
                    Items.add(trade);

                    System.out.println("Item added.");

                    break;
                case 4:
                    System.out.println("Enter name of item: ");
                    scanner.nextLine();
                    name=scanner.nextLine();

                    System.out.println("Enter price of item: $");
                    price= scanner.nextDouble();

                    System.out.println("Enter item's description: ");
                    scanner.nextLine();
                    description= scanner.nextLine();

                    System.out.println("Where can this collectable be used? ");
                    String useOfCollect= scanner.nextLine();

                    Item collection= new Collectable(name,price,description,useOfCollect);
                    Items.add(collection);

                    System.out.println("Item added.");
                    break;
                case 5:
                    System.out.println("Here's a list of all items that are currently available: ");
                    for (int i=0; i<Items.size();  i++){
                        System.out.println(Items.get(i).toString());
                    }
                    break;
                case 6:
                    System.out.println("Enter id of item: ");
                    int Id= scanner.nextInt();

                    Item findItem=null;

                    for (int i = 0; i<Items.size(); i++ ){
                        if (Items.get(i).getID() == Id){
                            findItem= Items.get(i);
                            break;
                        }
                    }

                    if (findItem != null){
                        System.out.println("Enter item's new price: $");
                        double newPrice=scanner.nextDouble();
                        findItem.setPrice(newPrice);
                        System.out.println("Price updated.");
                    }
                    else{
                        System.out.println("No item with that id.");
                    }
                    break;

                case 7:
                    System.out.println("Shutting off...");
                    running=false;
            }
        }


        }
    }
