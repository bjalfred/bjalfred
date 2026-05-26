// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    3
// IDE Name:	   <IntelliJ>

import java.util.Scanner;

public class TestMyStack
{
    public static void main (String[] args)
    {
        boolean running = true; // creating a boolean to use in the while loop
        Scanner scanner= new Scanner(System.in); //creating a scanner object
        MyStack<Integer> newStack = new MyStack<Integer>(); //create a stack object

        while (running) {

            //menu prompt

            System.out.println("---------MAIN MENU---------");
            System.out.println("1.\tPush element");
            System.out.println("2.\tPop element");
            System.out.println("3.\tGet top element");
            System.out.println("4.\tGet stack size");
            System.out.println("5.\tIs empty stack?");
            System.out.println("6.\tPrint stack");
            System.out.println("7.\tExit program");
            System.out.println();

            System.out.println("Enter option number: ");

            int Option = scanner.nextInt(); //option scanner


            switch (Option) {
                //pushing item on to the stack
                case 1: {
                    System.out.println("What number do you want the node to hold? ");
                    int data= scanner.nextInt(); // data scanner to be used in the method call

                    System.out.println("Pushing value " + data + " on the top of the stack.");

                    //printing data according to assignment instructions
                    if (newStack.countNodes()==0){
                        //printing if stack is empty
                        System.out.println("Stack content before pushing " + data + " is: Stack is empty ");
                    }
                    else{
                        System.out.print("Stack content before pushing " + data + " is:  ");
                        System.out.print("[");
                        newStack.printStack(); //printing stack before method call
                        System.out.print("]");
                        System.out.println();
                    }

                    System.out.print("Stack content after pushing "+ data +" is: ");
                    newStack.push(data);
                    System.out.print("[");
                    newStack.printStack(); // printing stack after method call
                    System.out.print("]");
                    System.out.println();

                    break;
                }
                //popping item off the stack
                case 2:{
                    //printing data according to assignment instructions
                    if (newStack.countNodes()==0){
                        //prints if stack is empty
                        System.out.println("Stack content before popping is: Stack is empty ");
                    }
                    else{
                        int value= newStack.top();
                        System.out.print("Stack content before popping " + value + " is:  ");
                        System.out.print("[");
                        newStack.printStack(); //printing stack before method call
                        System.out.print("]");
                        System.out.println();

                        System.out.print("Stack content after popping "+ value +" is: ");
                        newStack.pop();
                        System.out.print("[");
                        newStack.printStack(); // printing stack after method call
                        System.out.print("]");
                        System.out.println();
                    }
                    break;
                }
                //peeking at the top element
                case 3: {
                    if (newStack.isEmpty()){
                        System.out.println("The stack is empty"); // if stack is empty
                    }
                    else{
                        System.out.println("The top element is: " + newStack.top()); //print top element
                    }
                    break;
                }
                // is the stack empty?
                case 4: {
                    if(newStack.isEmpty()){
                        System.out.println("The stack is empty"); // if isEmpty returns true, the stack size is empty
                    }
                    else {
                        System.out.println("The size of the stack is : " + newStack.countNodes()); // if isEmpty returns false print stack size
                    }
                    break;
                }
                case 5: {
                    if (newStack.isEmpty()){
                        System.out.println("The stack is empty"); // if isEmpty returns true print <-
                    }
                    else{
                        System.out.println("The stack is not empty"); // if isEmpty returns false print <-
                    }

                    break;
                }
                //printing the stack
                case 6: {
                    if (newStack.countNodes()==0){
                        System.out.println("Stack is empty "); // if the stack is empty, nothing can be printed
                    }
                    else{
                        System.out.print("[");
                        newStack.printStack(); // else print the stack
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