// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    3
// IDE Name:	   <IntelliJ>

import java.util.Scanner;

public class myTest_No_HT
{
   public static void main (String[] args)
   {
      boolean running = true; // creating a boolean to use in the while loop
      Scanner scanner= new Scanner(System.in); //creating a scanner object
      LinkedList_No_HT myList = new LinkedList_No_HT(); //create a list object

      while (running) {

         //menu prompt

         System.out.println("---------MAIN MENU---------");
         System.out.println("1.\tAdd First Node");
         System.out.println("2.\tAdd Last Node");
         System.out.println("3.\tAdd At Index");
         System.out.println("4.\tRemove First Node");
         System.out.println("5.\tRemove Last Node");
         System.out.println("6.\tRemove At Index");
         System.out.println("7.\tPrint List Size");
         System.out.println("8.\tPrint List Forward");
         System.out.println("9.\tPrint List in Reverse");
         System.out.println("10.\tExit program");
         System.out.println();

         System.out.println("Enter option number: ");

         int Option = scanner.nextInt(); //option scanner


         switch (Option) {
            //adding First Node
            case 1: {
               System.out.println("What number do you want the node to hold? ");
               int data= scanner.nextInt(); // data scanner to be used in the method call

               System.out.println("Adding value " + data + " as first node.");

               //printing data according to assignment instructions
               System.out.print("List content before adding " + data + " is:  ");
               myList.printList(); //printing list before method call
               System.out.println();

               System.out.print("List content after adding "+ data +" is: ");
               myList.addFirstNode(data);
               myList.printList(); // printing list after method call
               System.out.println();

               break;
            }
            case 2:{
               System.out.println("What number do you want the node to hold? ");
               int data= scanner.nextInt(); // data object for the method parameter

               System.out.println("Adding value " + data + " as last node.");


               //printing data according to assignment instructions
               System.out.print("List content before adding " + data + " is:  ");
               myList.printList(); //printing list before the method call
               System.out.println();

               System.out.print("List content after adding " + data + " is: ");
               myList.addLastNode(data);
               myList.printList();//printing list after the method call
               System.out.println();
               break;
            }
            case 3: {
               int size= myList.countNodes(); // creating an int variable to guide the user in index

               System.out.println("The current list size is " + size);
               System.out.println("From 0-" + (size-1)  + " pick an index to add a node" );
               int index= scanner.nextInt(); // scanner to get the index parameter

               System.out.println("What number do you want the node to hold? ");
               int data= scanner.nextInt(); // getting data for the method parameter

               System.out.println("Adding value " + data + " at index " + index + ".");


               System.out.print("List content before adding " + data + "is:  ");
               myList.printList(); // printing list before the method call
               System.out.println();

               System.out.print("List content after adding" + data +"is: ");
               myList.addAtIndex(index,data);
               myList.printList(); // printing list after the method call
               System.out.println();
               break;
            }
            case 4: {

               // printing according to assignment instructions

               System.out.println("Method removeFirstNode()");

               System.out.print("List content before removing first node is:  ");
               myList.printList(); // printing before the method call
               System.out.println();

               System.out.print("List content after removing the first node is: ");
               myList.removeFirstNode();
               myList.printList();// printing after the method call
               System.out.println();

               break;
            }
            case 5: {
               //printing according to assignment instructions
               System.out.println("Method removeLastNode()");
               System.out.print("List content before removing the last node is:  ");
               myList.printList(); // printing before the method call
               System.out.println();

               System.out.print("List content after removing the last node is: ");
               myList.removeLastNode();
               myList.printList(); // printing after the method call
               System.out.println();
               break;
            }
            case 6: {
               int size= myList.countNodes(); // creating an int variable to guide the user in index

               System.out.println("Method removeAtIndex()");

               System.out.println("The current list size is " + size);
               System.out.println("From 0-" + (size-1)  + " pick an index to be removed" );
               int index= scanner.nextInt(); // index scanner to use for the parameter

               System.out.print("List content before removing the node is:  ");
               myList.printList();
               System.out.println(); // list before the method call

               System.out.print("List content after removing the node is: ");
               myList.removeAtIndex(index);
               myList.printList(); //list after the method call
               System.out.println();
               break;
            }
            case 7:{
               //printing the size of the list
               System.out.println("The size of the list is : " + myList.countNodes());
               break;
            }
            case 8: {
               // printing the list
               System.out.print("The complete list is: " );
               myList.printList();
               System.out.println();
               break;
            }
            case 9: {
               // printing the reversed list
               System.out.print("The list in reverse: ");
               myList.printInReverseRecursive(myList.ListName);
               System.out.println();
               break;
            }
            case 10: {
               // shutting down prompt
               System.out.println("Shutting down ...");
               running=false;}
         }
      }
   }
}
    
