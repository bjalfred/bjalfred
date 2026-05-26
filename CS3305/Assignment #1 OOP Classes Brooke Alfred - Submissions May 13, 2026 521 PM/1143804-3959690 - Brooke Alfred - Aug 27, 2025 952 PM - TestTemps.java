// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    1
// IDE Name:	   <IntelliJ>

import java.util.Scanner;
import java.util.Arrays;

public class TestTemps {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("Weather Tracker");

        int [] weather = new int[7]; //creating array for inputs

        System.out.println("Please enter the temperature for each day this week starting from Monday to Sunday: ");

        // for loop to set temperatures
        for (int i=0; i<weather.length; i++){
            System.out.println("Enter temperature " + (i+1) + " :");
            weather[i]=scanner.nextInt();
        }

        // creating temperature object
        DailyTemps temperatures = new DailyTemps(weather);

        // creating use for the set temp function.

        System.out.println("Would you like to change any temperatures (yes/no) ");
        scanner.nextLine(); // clearing out the scanner, so it does not stop abruptly
        String answer= scanner.nextLine();


        // setTemps while loop to update temperatures

        while (answer.equals("yes")){
            System.out.println("Pick a day (Monday=0- Sunday=6)");
            int newDay= scanner.nextInt();

            System.out.println("Enter the new temperature: ");
            int newTemp= scanner.nextInt();

            temperatures.setTemps(newDay, newTemp);

            System.out.println("Temperature updated");

            System.out.println("Would you like to change any other temperatures? (yes/no) ");
            scanner.nextLine();
            answer= scanner.nextLine();
        }

        if(answer.equals("no")) {
            // printing out temperatures as well as the warmest and coolest days
            temperatures.printTemps();

            System.out.println("The warmest day of the week is " + temperatures.Warmest());

            System.out.println("Number of freezing days is " + temperatures.Freezing() + " days.");
        }



    }
}