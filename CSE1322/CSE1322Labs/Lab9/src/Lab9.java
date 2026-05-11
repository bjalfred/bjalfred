import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Lab 9

public class Lab9 {
    public static String diff(File text1, File text2 ) throws FileNotFoundException {
        String Text1 = "";
        String Text2 = "";


        Scanner scan1 = null;
        Scanner scan2 = null;
        String differences = "";


        try {
            scan1 = new Scanner(text1);
            scan2 = new Scanner(text2);
            ArrayList<String> linesOf1 = new ArrayList<>();
            ArrayList<String> linesOf2 = new ArrayList<>();


            while (scan1.hasNextLine()) {
                Text1 = scan1.nextLine();
                linesOf1.add(Text1);
            }

            while (scan2.hasNextLine()) {
                Text2 = scan2.nextLine();
                linesOf2.add(Text2);
            }


            differences = "";

            for (int i = 0; i < linesOf1.size() && i < linesOf2.size(); i++) {

                if (linesOf1.get(i).equals(linesOf2.get(i))) {
                    continue;
                }
                if (!(linesOf1.get(i).equals(linesOf2.get(i)))) {
                    differences += "\n Line " + (i + 1) + "\n < " + linesOf1.get(i) + "\n > " + linesOf2.get(i);
                }


            }
            if (linesOf1.size() != linesOf2.size()) {
                return differences + "\n Files have different numbers of lines";
            }


        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
        finally {
            if (scan1 != null) {
                scan1.close();
            }
            if (scan2 != null) {
                scan2.close();
            }
        }
    if (differences.equals("")){
        return "Files are identical";
    }
    return differences;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner= new Scanner(System.in);

        String text1;
        String text2;

            System.out.println("[Diff Detector]");

            System.out.println("Enter the name of file 1: ");
             text1= scanner.nextLine();

            System.out.println("Enter the name of file 2: ");
            text2= scanner.nextLine();

            File firstText= new File(text1);
            File secondText= new File(text2);

            System.out.println(diff(firstText, secondText));
            System.out.println("Program complete");
        }


    }
