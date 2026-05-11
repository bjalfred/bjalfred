//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Lab 7

import java.util.Scanner;


public class Lab7 {
    public static int recursiveMultiply(int a, int b) {
        if (b == 0) {
            return 0;
        } else {
            return a + recursiveMultiply(a, b - 1);
        }
    }

    public static int recursiveDivision(int a, int b) {
        if (b == 0) {
            return -1;
        }
        if (a < b) {
            return 0;
        } else {
            return 1 + recursiveDivision(a - b, b);
        }
    }

    public static int recursiveRemainder(int a, int b) {
        if (b == 0) {
            return -1;
        }
        if (a < b) {
            return a;
        } else {
            return recursiveRemainder(a - b, b);
        }
    }

    public static String recursiveEcho(String a, int b) {
        if (b == 0) {
            return "";
        } else {
            return a + recursiveEcho(a, b - 1);
        }

    }

    public static boolean recursiveReverse(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        if (a.length()==b.length() && !b.equals(a)){
            if (b.equals(a)) {
                return true;
            }
            else{
                return recursiveReverse(a.substring(1), b.substring(0, b.length() - 1));
            }

        }
        else{
            return false;
        }

        // still returning true even when the words dont match as long as they are the same length.
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        boolean running=true;

        while (running) {
            System.out.println("1. Multiply 2 numbers: ");
            System.out.println("2. Divide 2 numbers: ");
            System.out.println("3. Mod 2 numbers: ");
            System.out.println("4. Echo sentence: ");
            System.out.println("5. Determine if reverse ");
            System.out.println("6. Quit ");

            System.out.println("Enter option: ");
            int Option = scanner.nextInt();

            switch (Option) {
                case 1:
                    int number1;
                    int number2;
                    System.out.println("Enter the first number: ");
                    number1 = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    number2 = scanner.nextInt();
                    System.out.println("Your product is " + recursiveMultiply(number1, number2));
                    break;
                case 2:
                    System.out.println("Enter the first number: ");
                    number1 = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    number2 = scanner.nextInt();
                    System.out.println("Your quotient is " + recursiveDivision(number1, number2));
                    break;
                case 3:
                    System.out.println("Enter the first number: ");
                    number1 = scanner.nextInt();
                    System.out.println("Enter the second number: ");
                    number2 = scanner.nextInt();
                    System.out.println("Your modulus is " + recursiveRemainder(number1, number2));
                    break;
                case 4:
                    String sentence;
                    scanner.nextLine();
                    System.out.println("Enter your sentence: ");
                    sentence = scanner.nextLine();
                    System.out.println("Repeat how many times?");
                    number1 = scanner.nextInt();
                    System.out.println("Your sentence repeated " + number1 + " times is ");
                    System.out.println(recursiveEcho(sentence, number1));
                    break;
                case 5:
                    String sentence1;
                    String sentence2;
                    scanner.nextLine();
                    System.out.println("Enter a sentence: ");
                    sentence1 = scanner.nextLine();
                    System.out.println("Enter another sentence: ");
                    sentence2 = scanner.nextLine();

                    if (recursiveReverse(sentence1, sentence2)==true) {
                        System.out.println("The sentences are the opposite of each other");
                    } else {
                        System.out.println("The sentences are NOT the opposite of each other");
                    }
                    break;
                case 6:
                    System.out.println("Shutting off...");
                    running = false;
            }
        }



    }
}