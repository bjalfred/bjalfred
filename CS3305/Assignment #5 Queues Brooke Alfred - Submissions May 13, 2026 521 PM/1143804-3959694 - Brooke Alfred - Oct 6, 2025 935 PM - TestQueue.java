// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    5
// IDE Name:	   <IntelliJ>

import java.util.Scanner;

public class TestQueue
{
    public static void main (String[] args)
    {
        boolean running = true; // creating a boolean to use in the while loop
        Scanner scanner= new Scanner(System.in); //creating a scanner object
        Queue<Integer> newQueue = new Queue<Integer>(); //create a queue object

        while (running) {

            //menu prompt

            System.out.println("--------MAIN MENU--------");
            System.out.println("1.\tEnqueue element");
            System.out.println("2.\tDequeue element");
            System.out.println("3.\tGet front element");
            System.out.println("4.\tGet queue size");
            System.out.println("5.\tIs empty queue?");
            System.out.println("6.\tPrint queue");
            System.out.println("7.\tExit program");
            System.out.println();

            System.out.println("Enter option number: ");

            int Option = scanner.nextInt(); //option scanner


            switch (Option) {
                //putting an element onto the queue
                case 1: {
                    System.out.println("What number do you want the node to hold? ");
                    int data= scanner.nextInt(); // data scanner to be used in the method call

                    System.out.println("Enqueuing value " + data + " to the front of the queue.");

                    //printing data according to assignment instructions
                    if (newQueue.size()==0){
                        //printing if queue is empty
                        System.out.println("Queue content before enqueuing  " + data + " is: Queue is empty ");
                    }
                    else{
                        System.out.print("Queue content before enqueuing " + data + " is:  ");
                        System.out.print("[");
                        newQueue.printQueue(); //printing queue before method call
                        System.out.print("]");
                        System.out.println();
                    }

                    System.out.print("Queue content after enqueuing "+ data +" is: ");
                    newQueue.Enqueue(data);
                    System.out.print("[");
                    newQueue.printQueue(); // printing queue after method call
                    System.out.print("]");
                    System.out.println();

                    break;
                }
                //popping item off the stack
                case 2:{
                    //printing data according to assignment instructions
                    if (newQueue.size()==0){
                        //prints if Queue is empty
                        System.out.println("Queue content before dequeuing is: Queue is empty ");
                    }
                    else{
                        int value= newQueue.Front();
                        System.out.print("Queue content before dequeuing " + value + " is:  ");
                        System.out.print("[");
                        newQueue.printQueue(); //printing queue before method call
                        System.out.print("]");
                        System.out.println();

                        System.out.print("Queue content after dequeuing "+ value +" is: ");
                        newQueue.Dequeue();
                        System.out.print("[");
                        newQueue.printQueue(); // printing queue after method call
                        System.out.print("]");
                        System.out.println();
                    }
                    break;
                }
                //looking at the front element
                case 3: {
                    if (newQueue.isEmpty()){
                        System.out.println("The queue is empty"); // if the queue is empty
                    }
                    else{
                        System.out.println("The front element is: " + newQueue.Front()); //print the front element
                    }
                    break;
                }
                // is the stack empty?
                case 4: {
                    if(newQueue.isEmpty()){
                        System.out.println("The queue is empty"); // if isEmpty returns true, the stack size is empty
                    }
                    else {
                        System.out.println("The size of the queue is : " + newQueue.size()); // if isEmpty returns false print queue size
                    }
                    break;
                }
                case 5: {
                    if (newQueue.isEmpty()){
                        System.out.println("The queue is empty"); // if isEmpty returns true print <-
                    }
                    else{
                        System.out.println("The queue is not empty"); // if isEmpty returns false print <-
                    }

                    break;
                }
                //printing the stack
                case 6: {
                    if (newQueue.size()==0){
                        System.out.println("Queue is empty "); // if the queue is empty, nothing can be printed
                    }
                    else{
                        System.out.print("[");
                        newQueue.printQueue(); // else print the queue
                        System.out.print("]");
                        System.out.println();
                    }
                    break;
                }
                //exit
                case 7:{
                    // shutting down prompt
                    System.out.println("Shutting down ...");
                    running=false;}
            }
        }
    }
}