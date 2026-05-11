import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

//Class: CSE 1321 L
//Section: W05
//Term: Summer 2025
//Instructor: Justin McClung
//Name: Brooke Alfred
//Lab: Lab 10

public class Lab10 {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner= new Scanner(System.in);
        ArrayList<Alarm> currentAlarms= new ArrayList<>();
        boolean running= true;

        try {

            while (running) {
                System.out.println("1. Create new alarm");
                System.out.println("2. View all alarms");
                System.out.println("3. Quit");

                System.out.println("Enter option: ");
                int Option = scanner.nextInt();

                switch (Option) {
                    case 1:
                        scanner.nextLine();
                        System.out.println("Enter alarm name: ");
                        String Name = scanner.nextLine();
                        System.out.println("Enter alarm timer in seconds: ");
                        int Timer = scanner.nextInt();
                        Alarm newAlarm = new Alarm(Name, Timer);
                        newAlarm.start();
                        currentAlarms.add(newAlarm);
                        System.out.println(newAlarm.name + " is currently at " + (newAlarm.timer / 1000) + " seconds");
                        break;
                    case 2:
                        System.out.println("Here are all the alarms still running: ");
                        for (int i = currentAlarms.size() - 1; i >= 0; i--) {
                            if (currentAlarms.get(i).timer<= 0) {
                                currentAlarms.remove(i);
                            }
                        }
                        for (int i=0; i<currentAlarms.size(); i++){
                            System.out.println(currentAlarms.get(i).toString());
                        }
                        break;
                    case 3:
                        System.out.println("Stopping all alarms...");
                        for (int i = currentAlarms.size() - 1; i >= 0; i--) {
                            currentAlarms.get(i).interrupt();
                            currentAlarms.remove(currentAlarms.get(i));
                        }
                        if (currentAlarms.isEmpty()) {
                            System.out.println("All alarms have been stopped");
                            System.out.println("Shutting off...");
                            running = false;
                        }

                }
            }
        }
        catch (InputMismatchException e){
            System.out.println("Invalid timer: Timer must be a whole number");

        }




    }
}