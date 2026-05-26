// Name:		  Brooke Alfred
// Class:	  CS 3305/Section#
// Term:		  Fall 2025
// Instructor:   Professor Bradley
// Assignment:   4
// IDE Name:	  <IntelliJ>
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        boolean running = true; // creating a boolean to use in the while loop
        Scanner scanner = new Scanner(System.in); //creating a scanner object
        MyStack<String> newStack = new MyStack<String>(); //create a stack object
        String originalSen=null; // sentence tracker
        String reversedSen=""; //reversed sentence variable for popping


        while (running) {

            //menu prompt
            System.out.println("-----------------MAIN MENU---------------");
            System.out.println("1.\tRead input string of words");
            System.out.println("2.\tReverse string and display outputs ");
            System.out.println("3.\tExit program");
            System.out.println();

            System.out.println("Enter option number: ");

            int Option = scanner.nextInt();//option scanner


            switch (Option) {
                //delimiting the string and adding to the stack
                case 1: {
                    scanner.nextLine();//washer
                    System.out.println("Enter a sentence: ");
                    String sentence = scanner.nextLine(); // sentence scanner to be used in the method call
                    originalSen=sentence;

                    String[] senSplit= sentence.split(" "); //string array created using the space delimiter

                    for (int i=0; i<senSplit.length; i++) {
                        newStack.push(senSplit[i]); // adding each word on to the stack
                    }
                    break;
                }
                //returning the reverse string
                case 2: {
                    //printing data according to assignment instructions
                    if (newStack.countNodes() == 0) {
                        //prints if stack is empty
                        System.out.println("Stack content before reversing the string is: Stack is empty ");
                    } else {

                        //popping the stack into the reversed sentence
                        while(newStack.isEmpty()==false){
                            reversedSen+=newStack.pop() + " ";
                        }

                        System.out.println("Entered sentence:\t" + originalSen); //original sentence
                        System.out.print("Reversed sentence:\t" + reversedSen); // altered sentence


                        System.out.println();
                    }
                    break;
                }
                //exit program
                case 3: {
                    // shutting down prompt
                    System.out.println("Shutting down ...");
                    running=false;

            }
            }
        }
    }
}
