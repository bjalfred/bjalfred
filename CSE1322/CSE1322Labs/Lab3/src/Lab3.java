//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab:3




import java.util.Scanner;
import java.util.ArrayList;


public class Lab3 {
    public static void main(String[] args) {
        ArrayList<String[]> phonebook= new ArrayList<>();
        Scanner scanner= new Scanner(System.in);

        boolean running=true;
        System.out.println("[Phonebook]");

        while(running){
            System.out.println("1. Add Contact");
            System.out.println("2. Remove Contacts");
            System.out.println("3. List Contacts");
            System.out.println("4. Search Contacts");
            System.out.println("5. Quit");

            System.out.println("Enter option: ");
            int Option= scanner.nextInt();

            switch(Option){
                case 1:
                    String [] contacts= new String[2];
                    System.out.println("Enter the contact's name");
                    scanner.nextLine();
                    String contactName= scanner.nextLine();
                    System.out.println("Enter the contact's phone number: ");
                    String number= scanner.nextLine();

                    contacts[0]=contactName;
                    contacts[1]=number;

                    phonebook.add(contacts);
                    System.out.println("Contact added.");
                    break;
                case 2:
                    System.out.println("Enter the contact to remove: ");
                    scanner.nextLine();
                    String search = scanner.nextLine();
                    boolean found=false;

                    for (int i = 0; i < phonebook.size(); i++) {
                        if (phonebook.get(i)[0].equals(search)) {
                            phonebook.remove(i);
                            found=true;
                            break;
                        }
                    }
                    if (!found){
                        System.out.println("No contact with that name.");
                    }
                    else{
                        System.out.println("Contact deleted.");
                    }
                    break;
                case 3:
                    if (phonebook.isEmpty()){
                        System.out.println("The phonebook is empty");

                    }
                    else {
                        System.out.println("Listing all contacts...");
                        for (int i = 0; i < phonebook.size(); i++) {
                            String [] contact= phonebook.get(i);
                            System.out.println("Name: " + contact[0] +" | " +" Phone: " + contact[1]);
                        }
                        System.out.println("Done listing contacts.");
                    }
                    break;
                case 4:
                    boolean keyword = false;
                    System.out.println("Enter keyword to search: ");
                    scanner.nextLine();
                    String searchChar = scanner.nextLine();
                    System.out.println("Searching all contacts for keyword...");
                    for (int i = 0; i < phonebook.size(); i++) {
                        String [] contact = phonebook.get(i);
                        if (phonebook.get(i)[0].contains(searchChar)) {
                            System.out.println("Name: " + contact[0] +" | " +" Phone: " + contact[1]);
                            keyword = true;
                        }
                    }
                    if (!keyword){
                        System.out.print("No contacts contained the keyword.");
                    }
                    else {
                        System.out.println("Done searching keyword.");
                    }
                    break;
                case 5:
                    System.out.println("Shutting off...");
                    running=false;
            }


        }


    }
}