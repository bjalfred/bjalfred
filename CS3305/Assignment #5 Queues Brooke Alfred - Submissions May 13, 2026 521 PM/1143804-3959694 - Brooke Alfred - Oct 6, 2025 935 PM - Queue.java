// Name:		  Brooke Alfred
// Class:	  CS 3305/Section#2
// Term:		  Fall 2025
// Instructor:   Professor Bradley
// Assignment:   5
// IDE Name:	  <IntelliJ>



public class Queue <E> {
    public Node startQ; // making the starting node on the queue
    public Node endQ; //making the end pointer on the queue for dequeueing purposes

    /*
    Overloaded constructor, has a start pointer and an ending pointer, so we can add on the back and remove from the front.
     */
    public Queue (){
        startQ=null; // initializing startQ by pointing it null;
        endQ=null;
    }

    /*
    Method adds an element to the back of the list
    Element is the data needed to make the node
    */
    public void Enqueue(E element) {
        Node myelement= new Node(element);
        if (startQ==null){
            startQ= myelement; // if there is no current list set the node to startQ which is the front of the line
            endQ= myelement; //making a tail pointer to help with dequeueing;
        }
        else{
            // If there is at least one person in line, waitingINLine signifies the next person coming after
            Node waitingInLine= new Node(element);
            endQ.next= waitingInLine;
            endQ=waitingInLine; //pushing the tail back one for the next
        }

    }

    /*
    Method looks at the data on the top of the list and returns it, and removes the top element.
     */
    public E Dequeue(){
        E data= startQ.data; // setting a variable for the data we need to return.
        startQ=startQ.next; // removes the top element.
        if (startQ == null) endQ = null; // queue is empty, reset tail
        return data; // returns data of the node removed.
    }

    /*
    This method returns the data at the top of the queue.
     */
    public E Front (){
        return startQ.data; //returning the data fot the first in line element.
    }

    /*
    This method traverses through the stack and returns the number of nodes in the list
     */
    public int size(){

        Node temp= startQ;
        int counter=0; // counter to use in while loop

        if (startQ==null){
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
    /*
    this method returns a boolean iuf startQ is null, so if there is no head pointer, the queue is empty
     */
    public boolean isEmpty(){
        if (startQ==null){
            return true;// if there is no node return true it is empty
        }
        else{
            return false; // if the FIFO node is not empty return false.
        }
    }
    /*
    This method uses a while loop to print out the data for each node
     */
    public void printQueue(){
        Node temp=startQ;
        // while temp is not null, print out the data
        while (temp!=null) {
            System.out.print(temp.data + " "); // printing out data for each node.
            temp = temp.next; //moving the nodes forward.
        }
    }


    // private node class implemented from the linked list class from asignment 3
    private class Node {
        private E data; //making the data storing element
        private Node next; // setting a pointer for the next function

        public Node(E newData){
            data=newData; // data is equal to whatever data type.
            next=null; //points to null to show ending of the list
        }
    }
}
