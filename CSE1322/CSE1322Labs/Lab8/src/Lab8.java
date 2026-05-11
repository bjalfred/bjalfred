//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Lab 8
import java.util.Scanner;

public class Lab8 {
    public static int differenceInSeconds(String timeA, String timeB) throws InvalidTimeException{
        String[] splitTimeA= timeA.split(":");
        String[] splitTimeB=timeB.split(":");

        if (splitTimeA.length != 3 || splitTimeB.length != 3){
            throw new InvalidTimeException("Timestamp must be in the format HH:MM:SS");
        }

        //timea parsing
        int hoursA =Integer.parseInt(splitTimeA[0]);
        int minutesA =Integer.parseInt(splitTimeA[1]);
        int secondsA =Integer.parseInt(splitTimeA[2]);

        //timeb parsing
        int hoursB =Integer.parseInt(splitTimeB[0]);
        int minutesB =Integer.parseInt(splitTimeB[1]);
        int secondsB =Integer.parseInt(splitTimeB[2]);

        if (hoursA<0 || hoursB<0  ){
            throw new InvalidTimeException("Hours must be greater than or equal to 0");
        }
        else if (hoursA>23 || hoursB>23 ){
            throw new InvalidTimeException("Hours must be less than 24");
        }
        else if (minutesA<0 || minutesB<0  ){
            throw new InvalidTimeException("Minutes must be greater than or equal to 0");
        }
        else if (minutesA>60 || minutesB>60 ){
            throw new InvalidTimeException("Minutes must be less than 60");
        }
        else if (secondsA<0 || secondsB<0  ){
            throw new InvalidTimeException("Hours must be greater than or equal to 0");
        }
        else if (secondsA>60 || secondsB>60 ){
            throw new InvalidTimeException("Seconds must be less than 60");
        }

        hoursA=hoursA*3600;
        minutesA=minutesA*60;
        hoursB= hoursB*3600;
        minutesB=minutesB*60;

        int newTimesA=hoursA+minutesA+secondsA;
        int newTimesB=hoursB+minutesB+secondsB;
        int difference;

        return difference= newTimesB-newTimesA;
    }

    public static void main(String[] args) throws InvalidTimeException {
        System.out.println("[Time Calculator]");

        Scanner scanner= new Scanner(System.in);

        boolean running=true;

        while(running){
            System.out.println("1. Calculate difference in seconds");
            System.out.println("2. Exit");
            System.out.println("Enter option: ");

            int Option= scanner.nextInt();

            switch(Option){
                case 1:
                    try {
                        scanner.nextLine();
                        System.out.println("Enter the start timestamp:");
                        String timeA = scanner.nextLine();
                        System.out.println("Enter the end timestamp:");
                        String timeB = scanner.nextLine();
                        differenceInSeconds(timeA,timeB);
                        System.out.println("The difference between " + timeA + " and " + timeB + " is "+ differenceInSeconds(timeA,timeB) +" seconds");
                    }
                    catch (InvalidTimeException e){
                        System.out.println(e.getMessage());
                    }
                    catch (NumberFormatException e){
                        System.out.println("You must enter integers for the hours, minutes, and seconds");
                    }
                    break;
                case 2:
                    System.out.println("Shutting off...");
                    running=false;
            }
        }

        }
    }
