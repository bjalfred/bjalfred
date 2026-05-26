// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    3
// IDE Name:	   <IntelliJ>

import java.util.List;

public class LinkedList_No_HT
{
   public Node ListName;

   //constructor method to create a list object with a specifc name. 
   public LinkedList_No_HT()
   {
      ListName = null;
   }
  
   //method add node to end of list
   public void addLastNode(int data) 
   {
      if (ListName == null) 
         ListName = new Node(data); //one node list
      else 
      {
         Node temp = ListName;
         while (temp.next != null) 
         {
            temp = temp.next;
         }
         
         temp.next = new Node(data);
      }
   }
  
   //======== Your part to complete for this assignment =========
   
   //method #1: add first node

   /*
   Method adds a node to the beginning of the list.
   Takes in parameter data to create the new node
    */
   public void addFirstNode(int data)
   {
      // if ListName (the original first node) is null, create a node based on the data entered
         if (ListName==null){
            ListName= new Node(data);
         }
         // if it is not null, take ListName and move it down one, and put this current node as ListName
         else{
            Node temp= ListName;
            ListName= new Node(data);
            ListName.next=temp;
         }
   }
     
      
   //method #2: add node at index
   /*
   Adds a node to index that the user specifies
   the user specifies the index parameter to pick where they want to insert the node
   the user specifies the data parameter to create a node with data at said index
   */
   public void addAtIndex(int index, int data)
   {
         // creating nodes to assist with adding nodes at a specific index
         Node addingNode= new Node(data); // new node i am inserting
         Node temp= ListName;
         Node newTemp= null; // node to move the rest of the list down

      // invalid index check
         if (index<0 || index>countNodes() ){
            System.out.println("Invalid index, try again");
         }
         else if (index==0){
            ListName= addingNode; // ListName is equal to the new node
            ListName.next=temp; //ListName is now ListName.next
         }
         // if the index is not 0
         else {
            // move to the node right before the index you want to change
            do {
               temp = temp.next;
               index -= 1;
            } while (index != 1);

            newTemp=temp.next; //the node at the position I want to change is equal to newtemp
            temp.next=addingNode; // the node right before the index I want to change is now the node the user entered
            addingNode.next=newTemp; // the node that the user entered.next is now pointed to the original node
         }

   }
      
      
   //method #3: remove first node
   /*
   This method removes the first node by setting ListName to the next node
    */
   public void removeFirstNode()
   {
      // if there is no node added to the nothing can be removed
         if(ListName==null){
            System.out.println("List is Empty");
         }
         else{
            // temp is equal to the node after ListName
            Node temp= ListName.next;
            ListName=null; // List name is now null;
            ListName=temp; //ListName is now equal to the next node
         }
   }
      
      
   //method #4: remove last node
   /*
   This method removes the last node by setting the last node to null
    */
   public void removeLastNode()
   {
         Node temp= ListName;

         //If there is no node in the list there is nothing that can be removed
         if (temp==null){
            System.out.println("List is Empty.");
         }
         //If this is a one node list, ListName becomes null
         else if (temp.next==null){
            ListName=null;
         }
         // If there is a two node list the node after ListName becomes null
         else if(temp.next.next == null){
            temp.next=null;
         }
         else{
            // traverse the list
            do{
            temp=temp.next;
            }while(!(temp.next.next ==null)); // use this condition if temp.next.next(node after the current node you are looking at-
            // is null ) stop at the node before it
            temp.next=null; // set the node after it to be null
         }
   }
    
    
   //method #5: remove node at index
   /*
   this method removes a node at the position that the user specifies in the index parameter
    */
   public void removeAtIndex(int index)
   {
      Node temp= ListName;

      // you cannot remove invalid indexes
      if (index<0 || index>countNodes()-1 ){
         System.out.println("Invalid index, try again");
      }
      // if there is no list
      else if (ListName==null){
         System.out.println("List is Empty.");
      }
      // If the index is 0 ListName is replaced by ListName.next (node after listName)
      else if(index==0){
         ListName=ListName.next;
      }
      else {
         // traverse through the list and subtract 1 from the index cals
         do {
            temp = temp.next;
            index -= 1;
         } while (index != 1); // stops at the index before you want to remove it

         temp.next = temp.next.next; // the target node is replaced with the node after the target node
      }
   }
          
   //method #6: countNodes
   /*
   This method counts the number of nodes in the list and returns that number
    */
   public int countNodes()
   {
      Node temp= ListName; // useful node
      int listSize= 0; //counter

      // while we are not at the end of the list, move forward and add one
      while(temp!=null){
         temp=temp.next;
         listSize+=1;
      }
        
      return listSize; 
   }

   
   //method #7: pritnInReverse (must be a Recursive method)
   /*
   this method uses recursion to traverse to the end of the list and print the data as it unwinds.
    */
   public void printInReverseRecursive(Node L)
   {
      // base case if I am at the end of the list stop.
      if (L==null){
      }
      // else move all the way to the end and print the data
      else{
        printInReverseRecursive(L.next);
        System.out.print(L.data + " ");
      }
   }   

   //================= end of your part ==============

   //method to print out the list
   public void printList() 
   {
      Node temp;
      temp = ListName;
      while (temp != null)
      {
         System.out.print(temp.data + "   ");
         temp = temp.next;
      }
   }
  
   //class to create nodes as objects
   private class Node
   {
      private int data;  //data field
      private Node next; //link field
       
      public Node(int item) //constructor method
      {
         data = item;
         next = null;
      }
   }
}

