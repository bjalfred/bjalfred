import java.util.Scanner;
import java.util.ArrayList;

public class Assignment7 {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);

        Inventory inventory = new Inventory();

        Item shirt= new Item("T-shirt", 6.50);
        Item sweater= new Item("Sweater", 8.50);
        Item sweatpants= new Item("Sweatpants", 10.00);
        Item skirt= new Item("Skirt", 25.50);
        Item dress= new Item("Dress", 15.50);

        System.out.println("[Order Queue Simulator]");
        System.out.println("Purchase how many 't-shirt' at $6.50?");
        int shirtAmount= scanner.nextInt();
        System.out.println("Purchase how many 'sweater' at $8.50?");
        int sweaterAmount= scanner.nextInt();
        System.out.println("Purchase how many 'sweatpants' at $10.00?");
        int sweatpantsAmount= scanner.nextInt();
        System.out.println("Purchase how many 'skirt' at $25.50?");
        int skirtAmount= scanner.nextInt();
        System.out.println("Purchase how many 'dress' at $15.50?");
        int dressAmount= scanner.nextInt();

        Purchaser shirtPurchase= new Purchaser(inventory, shirt, shirtAmount);
        Purchaser sweaterPurchase= new Purchaser(inventory, sweater, sweaterAmount);
        Purchaser sweatpantsPurchase= new Purchaser(inventory, sweatpants, sweatpantsAmount);
        Purchaser skirtPurchase= new Purchaser(inventory, skirt, skirtAmount);
        Purchaser dressPurchase= new Purchaser(inventory, dress, dressAmount);



        scanner.nextLine();
        System.out.println("Purchasers created. Press 'enter' to start purchases.");
        String enter=scanner.nextLine();

        if (enter!=null) {

            shirtPurchase.start();
            sweaterPurchase.start();
            sweatpantsPurchase.start();
            skirtPurchase.start();
            dressPurchase.start();
            System.out.println("Purchasers have started working ...");
        }

        try{
            shirtPurchase.join();
            sweaterPurchase.join();
            sweatpantsPurchase.join();
            skirtPurchase.join();
            dressPurchase.join();

        }
        catch (InterruptedException e){
           System.out.println("done");
        }

        if (!(shirtPurchase.isAlive() && sweaterPurchase.isAlive() && sweatpantsPurchase.isAlive() && skirtPurchase.isAlive() && dressPurchase.isAlive())) {

            int totalItems = (shirtPurchase.itemsProcessed + skirtPurchase.itemsProcessed + dressPurchase.itemsProcessed + sweaterPurchase.itemsProcessed + sweatpantsPurchase.itemsProcessed);
            System.out.println("Purchases are done working. A total of " + totalItems + " are awaiting processing");

            System.out.println("Create how many processors? ");
            int numOfProcessors = scanner.nextInt();

            scanner.nextLine();
            System.out.println("OrderProcessors created. Press 'enter' to start processing orders.");
            enter=scanner.nextLine();

            int numOfprocessorsCheck=numOfProcessors;


            ArrayList<Processor> Processors = new ArrayList<>();

            while (numOfprocessorsCheck != 0) {
                Processor newProcessor = new Processor(inventory);
                numOfprocessorsCheck -= 1;
                Processors.add(newProcessor);
            }


            for (int i = 0; i < Processors.size(); i++) {
                Processors.get(i).start();
            }

            try{
                for (int i = 0; i < Processors.size(); i++) {
                    Processors.get(i).join();
                }

            }
            catch (InterruptedException e){
            System.out.println("done");
            }
            int check=0;
            for (int i = 0; i < Processors.size(); i++) {
                if (!Processors.get(i).isAlive()) {
                    check += 1;
                }
                if (check == numOfProcessors) {
                    System.out.println("All OrderProcessors are done processing orders.");
                    System.out.println(inventory.getItemsProcessed() + " items were processed for a total of $" + inventory.retrieveBalance());
                    System.out.println("Simulation complete");
                }
            }


        }




        }








    }