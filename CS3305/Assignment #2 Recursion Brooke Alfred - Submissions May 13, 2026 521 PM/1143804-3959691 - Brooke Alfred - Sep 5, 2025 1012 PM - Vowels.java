// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    1
// IDE Name:	   <IntelliJ>

import java.util.Scanner;

public class Vowels {


    /*
     Count vowels uses recursion to find vowels in a string
     the parameter word takes in the string the user enters
     the parameter index sees which character we are at in the string
     it returns the total number of vowels found
    */

    public static int countVowels(String word, int index){
        //vowel counter
        int vowels=0;

        if (index>word.length()-1){
            //base case stops if the end of the word is met, returning the counter
            return vowels;
        }
        else{
            char vowelCheck=  word.charAt(index);
            if (vowelCheck=='a' || vowelCheck=='e' || vowelCheck=='i' || vowelCheck=='o' || vowelCheck=='u') {
                vowels += 1;
                // checking to see if the character is a vowel
            }

            //returning the amount of vowels I counted and moving forward a character using recursion
            return  vowels + countVowels(word, index+1) ;
        }

    }
    public static void main(String[] args) {
        boolean running = true;

        Scanner scanner= new Scanner(System.in);

        // setting up variables outside the array to make them accessible in all parts of switch statement
        String word=null;
        String originalWord=null;

        while (running){
            //menu

            System.out.println("---------MAIN MENU---------");
            System.out.println("1.\tRead input string");
            System.out.println("2.\tCompute number of vowels");
            System.out.println("3.\tExit program");
            System.out.println();

            System.out.println("Enter option number: ");

            int Option=scanner.nextInt();


            switch(Option){
                case 1:{
                    // taking in string
                    System.out.println("Enter a string: ");
                    scanner.nextLine();
                    word= scanner.nextLine();

                    //saving original string for printing in case two
                    originalWord=word;

                    // using a space as a delimeter to make all of this into one word for an easier checking
                    word= word.replace(" ", "");

                    //making the word lowercase to ensure that uppercase and lowercase values are counted
                    word= word.toLowerCase();

                    System.out.println();
                    break;
                }
                case 2 : {
                    if (word==null){
                        System.out.println("Please return to option one and enter a word.");
                        System.out.println();
                        break;
                    }
                    else {
                        // printing out outputs according to instructions
                        System.out.println("You entered string:\t" + originalWord);
                        System.out.println("Number of vowels:\t" + countVowels(word, 0));
                        System.out.println();
                    }
                    break;
                }
                case 3 : {
                    //shutting down prompt
                    System.out.println("Shutting down ...");
                     running=false;
                }
            }
            }




    }
}