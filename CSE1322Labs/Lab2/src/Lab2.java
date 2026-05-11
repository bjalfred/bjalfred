//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab:2

import java.util.Scanner;

public class Lab2 {
    public static void main(String[] args){
    Scanner scanner= new Scanner(System.in);
    boolean running=true;
    int start=0;
    int end=0;
    int comparison=0;
    String word="Computer";

    while (running){
        System.out.println("1. Count from a number to another");
        System.out.println("2. Determine largest number");
        System.out.println("3. Type in word");
        System.out.println("4. Quit");

        System.out.println("Enter option: ");
        int Option= scanner.nextInt();

        // creating the menu
        switch(Option){
            case 1:
                System.out.println("Enter the start point: ");
                int startPoint= scanner.nextInt();
                start=startPoint;

                System.out.println("Enter the end point: ");
                int endPoint= scanner.nextInt();
                end=endPoint;

                if (start<end){
                    do{
                        System.out.println(start);
                        start+=1;
                        System.out.println(start);
                    }while(start!=end);
                    System.out.println("Done counting.");
                    break;
                }
                if (start>end){
                    do{
                        System.out.println(start);
                        start-=1;
                        System.out.println(start);
                    }while(start!=end);
                    System.out.println("Done counting");
                    break;
                }
                if (start==end){
                    System.out.println("Start and end are the same!");
                    System.out.println("Done counting.");
                    break;
                }break;
            case 2:
                System.out.println("This option will display the largest number entered. Enter 0 when done.");

                int Number = scanner.nextInt();
                do {
                    System.out.println("Enter a number (current largest is " + comparison + ")");
                    Number= scanner.nextInt();
                    //need help stopping the double printing
                    if (Number > comparison) {
                        comparison = Number;

                    }
                }while(Number!=0);
                if (Number==0){
                    System.out.println("The largest number entered was "+ comparison);
                }break;
            case 3:
                String wordCheck;
                System.out.println("Type in the word 'Computer'");

                do {
                    scanner.nextLine();
                    wordCheck = scanner.nextLine();


                    if (wordCheck.equals(word)) {
                        System.out.println("Correct!");
                    }
                    else {
                        System.out.println("Incorrect. You must type 'Computer': ");

                    }
                }while(! wordCheck.equals(word));
                break;
            case 4:
                System.out.println("Shutting off...");
                running=false;
                break;
        }
    }

        }
    }
