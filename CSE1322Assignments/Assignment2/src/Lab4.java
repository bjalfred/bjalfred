import java.util.ArrayList;
import java.util.Scanner;

public class Lab4 {
    public static void main(String[] args) {
        ArrayList<Building> buildingList= new ArrayList<>();
        Scanner scanner= new Scanner(System.in);

        boolean running = true;

        System.out.println("[Apartment Complex Management System]");

        while(running){
           System.out.println("1. Add building");
           System.out.println("2. Remove building");
           System.out.println("3. List all buildings");
           System.out.println("4. List all tenants");
           System.out.println("5. Add tenant");
           System.out.println("6. Remove tenant");
           System.out.println("7. Update tenant");
           System.out.println("8. Charge rent");
           System.out.println("9. Pay for service");
           System.out.println("0. Quit");

           System.out.println("Select option: ");
           int Option= scanner.nextInt();

           switch (Option){
               case 1:
                    System.out.println("How many tenants can this building have?");
                    int numOfApartments= scanner.nextInt();
                    Building apartment= new Building(numOfApartments);
                    buildingList.add(apartment);
                    System.out.println("Building "+ apartment.getID() +" created");
               break;
               case 2:
                   System.out.println("Enter id of building: ");
                   int Id= scanner.nextInt();

                   Building findBuilding=null;

                   for (int i = 0; i<buildingList.size(); i++ ){
                       if (buildingList.get(i).getID() == Id){
                           findBuilding= buildingList.get(i);
                           break;
                       }
                   }
                   if (findBuilding != null){
                       buildingList.remove(findBuilding);
                       System.out.println("Building removed");
                   }
                   else{
                       System.out.println("No building with such id.");

                   }
                    break;
               case 3:
                    for (int i = 0; i<buildingList.size(); i++ ){
                        Building b= buildingList.get(i);
                        System.out.println("Building " + b.getID() +": " + b.countTenants() + " tenants." );
                    }
                    break;
               case 4:
                   System.out.println("Enter id of building to list: ");
                   Id= scanner.nextInt();

                   findBuilding =null;

                   for (int i = 0; i<buildingList.size(); i++ ){
                       if (buildingList.get(i).getID() == Id){
                           findBuilding= buildingList.get(i);
                           break;
                       }
                   }
                   if (findBuilding != null) {
                       System.out.println(findBuilding.listTenants());
                   }
                   else{
                       System.out.println("No building with such id.");
                   }
                    break;
               case 5:
                    System.out.println("Enter id of building: ");
                    Id= scanner.nextInt();

                    findBuilding=null;


                   for (int i = 0; i<buildingList.size(); i++ ){
                       if (buildingList.get(i).getID() == Id){
                           findBuilding= buildingList.get(i);
                            break;
                       }
                   }

                   if (findBuilding != null){

                       System.out.println(findBuilding.listTenants());

                       System.out.println("Enter tenant name: ");
                       scanner.nextLine();
                       String n= scanner.nextLine();
                       System.out.println("Enter tenant age: ");
                       int a= scanner.nextInt();
                       System.out.println("Enter tenant rent : $");
                       double r= scanner.nextDouble();

                       Tenant newTenant=new Tenant(n,a,r);

                       System.out.println("Add tenant to which apartment? ");
                       int apartNum= scanner.nextInt();

                       if (findBuilding.addTenant(newTenant,apartNum)){
                           System.out.println("Tenant added.");
                       }
                       else{
                           System.out.println("There is already a tenant at that apartment.");
                       }
                   }

                   else{
                       System.out.println("No building with such id.");
                   }
                   break;

               case 6:
                   System.out.println("Enter id of building: ");
                   Id= scanner.nextInt();

                   findBuilding=null;

                   for (int i = 0; i<buildingList.size(); i++ ){
                       if (buildingList.get(i).getID() == Id){
                           findBuilding= buildingList.get(i);
                           break;
                       }
                   }

                   if (findBuilding != null){

                       System.out.println(findBuilding.listTenants());


                       System.out.println("Remove tenant at which apartment? ");
                       int apartNum= scanner.nextInt();

                       Tenant evictedTenant=findBuilding.getTenant(apartNum);

                       if (evictedTenant!= null && findBuilding.removeTenant(apartNum)) {
                           System.out.println("Tenant removed.");
                       }
                       else{
                           System.out.println("Apartment is empty.");
                       }
                   }

                   break;
               case 7:
                   System.out.println("Enter id of building: ");
                    Id= scanner.nextInt();

                   findBuilding=null;

                   for (int i = 0; i<buildingList.size(); i++ ){
                       if (buildingList.get(i).getID() == Id){
                           findBuilding= buildingList.get(i);
                           break;
                       }
                   }

                   if (findBuilding != null){

                       System.out.println(findBuilding.listTenants());


                       System.out.println("Update tenant at which apartment? ");
                       int apartNum= scanner.nextInt();

                       Tenant updateTenant=findBuilding.getTenant(apartNum);

                       if (updateTenant!= null) {
                           System.out.println("Current tenant information: ");
                           System.out.println(findBuilding.getTenant(apartNum).toString());

                           System.out.println("Enter new name: ");
                           scanner.nextLine();
                           String n= scanner.nextLine();
                           System.out.println("Enter new age: ");
                           int a= scanner.nextInt();
                           System.out.println("Enter new rent : $");
                           double r= scanner.nextDouble();

                           updateTenant.name=n;
                           updateTenant.age=a;
                           updateTenant.rent=r;

                           System.out.println("Tenant updated.");

                       }
                       else{
                           System.out.println("That is not a valid apartment.");
                       }
                   }
                   break;
               case 8:
                   System.out.println("Enter id of building: ");
                   Id= scanner.nextInt();

                   findBuilding=null;

                   for (int i = 0; i<buildingList.size(); i++ ){
                       if (buildingList.get(i).getID() == Id){
                           findBuilding= buildingList.get(i);
                           break;
                       }
                   }

                   if (findBuilding != null){

                       System.out.println(findBuilding.listTenants());


                       System.out.println("Charge rent of which tenant? ");
                       int apartNum= scanner.nextInt();

                       Tenant payingTenant=findBuilding.getTenant(apartNum);

                       if (payingTenant!= null) {
                           String nameOfTenant=payingTenant.name;
                           Building.collectRent(payingTenant);
                           System.out.println("Tenant charged. New balance is $"+ Building.getBalance());
                       }
                       else{
                           System.out.println("Rent cannot be charged apartment is empty.");
                       }
                   }
                   break;
               case 9:
                   System.out.println("Current balance is $"+ Building.getBalance());
                   System.out.println("Enter service amount: $");
                   double servPrice= scanner.nextDouble();
                   Building.payForService(servPrice);
                   System.out.println("New balance is $" +Building.getBalance());
                   break;
               case 0:
                   System.out.println("Shutting off...");
                   running= false;

           }
        }



        }
    }
