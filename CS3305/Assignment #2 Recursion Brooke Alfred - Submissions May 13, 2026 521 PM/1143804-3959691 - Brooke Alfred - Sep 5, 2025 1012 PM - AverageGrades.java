// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    2
// IDE Name:	   <IntelliJ>

import java.util.Scanner;

public class AverageGrades {
    /*
     find average ses recursion to find the average of grades in a class
     the parameter grades takes in the array the user enters
     the parameter index sees which grade we are at in the array
     it returns the total average found
    */
    public static double findAverage(int[]grades, int index){
        //using this method to recursively to sum the array;

        if (index>grades.length-1){
            return 0; // if the index bigger than the array length add zero;
        }
        else{
            double grade= grades[index];
            return (grade /grades.length) +findAverage(grades , index+1);
            //adding the current index to the recursive call of the next index;
        }

    }
    public static void main(String[] args) {
        boolean running = true; //while loop boolean

        Scanner scanner= new Scanner(System.in); //scanner for options

        //initializing arrays and other variables outside the loop so they can be shared in the switch statement
        int[] grades= null;
        int classSize=0;


        while (running){

            //menu prompt
            System.out.println("---------MAIN MENU---------");
            System.out.println("1.\tRead class size");
            System.out.println("2.\tRead class grades");
            System.out.println("3.\tCompute class average");
            System.out.println("4.\tExit program");
            System.out.println();

            System.out.println("Enter option number: ");

            int Option=scanner.nextInt();


            switch(Option){
                case 1:{
                    // initializing an array with the class' size
                    System.out.println("Enter class size: ");
                    int Size= scanner.nextInt();

                    //checking if the class size is valid and looping until the user inputs a valid value
                    if (Size<=0) {
                        do {
                            System.out.println("Class size cannot be negative, please enter a positive class size: ");
                            Size = scanner.nextInt();
                        } while (Size <=0);
                    }

                    //creates array based on size
                    grades= new int[Size];
                    System.out.println();
                    break;
                }
                case 2 : {
                    //using a for loop to enter the grades for each student, and setting them to the proper index.
                    System.out.println("Enter grades for each student: ");

                    for (int i=0; i<grades.length; i++){
                        // creating a loop so the user can see which value it is on
                        System.out.println("Enter grade for student "+ (i+1) + " : ");
                        int percentage= scanner.nextInt(); //using a scanner to find the correct values

                        //checking to see if valid grades were entered 0<=percentage<=100

                        if (percentage>100 || percentage<0) {
                            do {
                                System.out.println("Grades are based on the standard grading scale, please enter a valid grade: ");
                                percentage = scanner.nextInt();
                            } while (percentage > 100 || percentage < 0);
                        }

                        //setting valid grades up in the array
                        grades[i]=percentage;
                    }
                    System.out.println();
                    break;
                }
                case 3 : {
                    //printing out values/outputs

                    System.out.println("You entered class size:\t" + grades.length);
                    System.out.print("You entered grades:\t\t");

                    //using for loop to read what's in the array and using system.out.print to format it correctly

                    for (int i=0; i<grades.length; i++){
                        System.out.print(grades[i] +" ");
                    }
                    System.out.println();
                    double num=(findAverage(grades,0));
                    System.out.println("Class average:\t\t" + Math.round(num*100.0)/100.0);
                    System.out.println();
                    break;
                }
                case 4 : {
                    // shutting down prompt
                    System.out.println("Shutting down ...");
                    running=false;
                }
            }
        }

    }
}