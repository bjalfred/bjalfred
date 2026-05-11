//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Lab 6

import java.util.Scanner;

public class Lab6 {
    public static void main(String[] args) {
        FibIteration fibIterate= new FibIteration();
        FibFormula fibonacci= new FibFormula();
        Scanner scanner= new Scanner(System.in);

        System.out.println("Find which position in the Fibonacci Sequence? ");
        int position= scanner.nextInt();

        System.out.println("Fibonacci using Binet's Formula of " + position + " is "+ fibonacci.calculateFib(position));
        System.out.println("Fibonacci using iteration of "+ position + " is "+ fibIterate.calculateFib(position));
        System.out.println("Program complete");
    }
}