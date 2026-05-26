// Name:		  Brooke Alfred
// Class:	  CS 3305/Section#
// Term:		  Fall 2025
// Instructor:   Professor Bradley
// Assignment:   4
// IDE Name:	  <IntelliJ>

import java.util.Scanner;

public class TestPalindrome {
    public static void main(String[] args) {

        MyStack<Character> newStack = null; //stack variable tracker
        boolean running = true; // creating a boolean to use in the while loop
        Scanner scanner = new Scanner(System.in); //creating a scanner object
        String originalWord=null; // sentence tracker
        char [] wordSplit = new char[0];
        String noSpaces=null;


        while (running) {

            //menu prompt
            System.out.println("-----------------MAIN MENU---------------");
            System.out.println("1.\tRead input string");
            System.out.println("2.\tCheck palindrome and display output ");
            System.out.println("3.\tExit program");
            System.out.println();

            System.out.println("Enter option number: ");

            int Option = scanner.nextInt();//option scanner


            switch (Option) {
                //taking in a word and reversing it by adding to the stack
                case 1: {
                    newStack = new MyStack<Character>(); //create a stack object
                    scanner.nextLine();//washer
                    System.out.println("Enter a word or sentence (without any punctuation marks) : ");
                    String word = scanner.nextLine();// word scanner to be used in the method call
                    word = word.toLowerCase();// making the check not affected by upper/lower case letters

                    originalWord=word;// keeping track of the original word/sentence
                    noSpaces = word.replaceAll(" ",""); // keeping track of a sentence without spaces to check if it is a palindrome
                    wordSplit = noSpaces.toCharArray(); // word turned into a character array

                    for (int i = 0; i < wordSplit.length; i++) {
                        newStack.push(wordSplit[i]); // adding each character on to the stack
                        }
                    break;
                }
                //returning the reverse string
                case 2: {
                    char[] stackedWord= new char[newStack.countNodes()]; //making a new array to add the popped stack into it

                    for (int i=0; i<stackedWord.length ; i++){
                        stackedWord[i]= newStack.pop(); // popping off the stack into the array, so I can compare the original word + new word
                    }

                    for (int i=0; i<stackedWord.length ; i++){
                        newStack.push(stackedWord[i]); // popping off the array into the stack, just in case someone wants to check the palindrome twice
                    }

                    boolean isPalindrome = true; // judgement boolean
                    String newWord= new String(stackedWord); //creating a string object out of the char array

                    if(!newWord.equals(noSpaces)){
                        isPalindrome=false; // if the words are not equal, boolean is now false
                    }

                    if (stackedWord.length == 0) {
                        //prints if a new char array is empty
                        System.out.println("Stack content before reversing the string is: Stack is empty ");
                    }
                    else if (isPalindrome) {
                        //if true, print out the word is a palindrome
                        System.out.println("Entered sentence:\t" + originalWord); //original sentence
                        System.out.print("Judgement:\tPalindrome "); // if it passes, it is a palindrome
                        System.out.println();
                    }
                    else{
                        // if false, print out that the word is not a palindrome.
                        System.out.println("Entered sentence:\t" + originalWord); //original sentence
                        System.out.print("Judgement:\tNot palindrome "); // if it doesn't pass, it isn't a palindrome
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
