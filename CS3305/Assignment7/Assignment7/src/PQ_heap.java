// Generic code for class priority_queue_heap for Assignment 7 

import java.util.ArrayList;

public class PQ_heap <E extends Comparable<E>>
{
    private Heap<E> heap;
	// Constructor method

    public PQ_heap(){
        heap = new Heap<>();
    } //using heap in my constructor
	
	// Return true if priority queue is empty; otherwise return false
   public boolean is_empty() {
       if (heap.getSize()==0){
           return true;
       }
       else{
           return false;
       }
   };
	
	// Return true if priority queue is full; otherwise return false
   public boolean is_full() {
       if (heap.getSize()>=heap.CAPACITY){
           return true;
       }
       else{
           return false;
       }
   };

	// Return (don't remove) the front element from the priority queue
	// Precondition: priority queue is not empty.
   public E front() {
       if (this.is_full()){
           return null;
       }
       else{
           return heap.getFront();
       }
   };

	// return number of elements in the queue
   public int size() {
       return heap.getSize();
   };
   
	// Remove the largest value from this priority queue and return it.
	// Precondition: priority queue is not empty.
   public E dequeue() {
       if (this.is_empty()){
           return null;
       }
       else{
          E removed= heap.remove();
           return removed;
       }
   };

    //helper method copying the raw list
    public ArrayList<E> printElements(){
        return heap.getElements(); // using the list helper method i made in heap to add elements

    }


    // Inserts the 'value' into the priority queue.
	// Precondition: priority queue is not full
   public void enqueue(E value) {
       if (this.is_full()){
           System.out.println("Queue is full, please dequeue to add more items"); //if queue is full dont add anymore
       }
       else{
           heap.add(value); // if not full add
       }
   };

    //helper method for printing instruction 7 // could not get the other levels no matter how hard i tried :(
    public void pqPrint(ArrayList<E> list) {
        int levelofTree = 0; // current level of the tree
        int index = 0;       // current node in the array

        while (index < list.size()) {
            int levelSize = (int) Math.pow(2, levelofTree); // max nodes at this level
            System.out.print("Index " + index + ":  ");     // print index for this level

            // print all nodes on this level
            for (int j = 0; j < levelSize && index < list.size(); j++, index++) {
                System.out.print(list.get(index) + " ");
            }

            System.out.println(); // move to next line for next level
            levelofTree+=1;        // move to next level
        }
    }
    }


