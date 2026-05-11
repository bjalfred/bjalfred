//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Assignment: Lab 5

import java.util.Scanner;

public class Assignment5 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String DNAreversed="";
        String DNAinversed="";

        System.out.println("[DNA Reverser and Translator]");
        System.out.println("Enter a sequence: ");
        String DNA= scanner.nextLine();

        if (DNALib.validator(DNA)){
            DNAreversed=DNALib.stringReverser(DNA);
            DNAinversed=DNALib.stringInverser(DNAreversed);
            System.out.println("Your DNA sequence reversed and translated is:");
            System.out.println(DNALib.stringTranslator(DNAinversed));
        }
        else{
            System.out.println("Your DNA sequence is not valid.");
        }



        }
    }