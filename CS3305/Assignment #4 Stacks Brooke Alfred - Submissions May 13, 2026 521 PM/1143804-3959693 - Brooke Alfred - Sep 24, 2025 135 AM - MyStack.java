// Name:		  Brooke Alfred
// Class:	  CS 3305/Section#
// Term:		  Fall 2025
// Instructor:   Professor Bradley
// Assignment:   4
// IDE Name:	  <IntelliJ>



public class MyStack <E> {
    public Node FIFO; // making the starting node on the stack filo=first in first out

    public MyStack (){
        FIFO=null; // initializing FIFO by pointing it null;
    }

    /*
    Method adds an element to the top of the list
    Element is the data needed to make the node
    */
    public void push(E element) {
        if (FIFO==null){
            FIFO= new Node(element); // if FIFO is null, set the node to FIFO
        }
        else{
            // If FIFO is not null, set temp.next to current FIFO, replace FIFO with temp. (adding on the top of the list)
            Node temp= new Node(element);
            temp.next= FIFO;
            FIFO=temp;
        }

    }

    /*
    Method looks at the data on the top of the list and returns it, and removes the top element.
     */
    public E pop(){
        E data= FIFO.data; // setting a variable for the data we need to return.
        FIFO=FIFO.next; // removes the top element.
        return data; // returns data.
    }

    /*
    This method returns the data at the top of the list.
     */
    public E top(){
        return FIFO.data; //returning the data fot the top element.
    }

    /*
    This method traverses through the stack and returns the number of nodes in the list
     */
    public int countNodes(){

        Node temp= FIFO;
        int counter=0; // counter to use in while loop

        if (FIFO==null){
            return 0; // if node is null return 0
        }
        else {
            //else traverse through the list and add 1 for every node
            while (temp != null) {
                temp = temp.next; // moving through the list by setting temp to temp.next
                counter += 1;// adding one everytime a node is moved forwarder
            }
            return counter; // return number of nodes count
        }
    }

    public boolean isEmpty(){
        if (FIFO==null){
            return true;// if there is no node return true it is empty
        }
        else{
            return false; // if the FIFO node is not empty return false.
        }
    }

    public void printStack(){
        Node temp=FIFO;
        // while temp is not null, print out the data
        while (temp!=null) {
            System.out.print(temp.data + " "); // printing out data for each node.
            temp = temp.next; //moving the nodes forward.
        }
    }


// private node class
    private class Node {
        private E data; //making the data storing element
        private Node next; // setting a pointer for the next function

        public Node(E newData){
            data=newData; // data is equal to whatever data type.
            next=null; //points to null to show ending of the list
        }
    }
}





