// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    1
// IDE Name:	   <IntelliJ>

import java.util.Arrays;
import java.util.ArrayList;

public class DailyTemps {
    // variables to keep track of temps
    int Monday;
    int Tuesday;
    int Wednesday;
    int Thursday;
    int Friday;
    int Saturday;
    int Sunday;


    public DailyTemps(int[] temperatures){
        // setting weekday variable to each temp to make it easier for me to understand

        Monday= temperatures[0];
        Tuesday = temperatures[1];
        Wednesday = temperatures[2];
        Thursday = temperatures[3];
        Friday= temperatures[4];
        Saturday = temperatures[5];
        Sunday= temperatures[6];
    }

    public void setTemps(int dayNum, int temp){
        //using a new array to reset temps using the index(dayNum) and new temp(temp)
        int [] days= {Monday, Tuesday , Wednesday, Thursday, Friday, Saturday, Sunday};
        days[dayNum]=temp;

    }

    public int Freezing(){
        //creating temp array (days)
        int [] days= {Monday, Tuesday , Wednesday, Thursday, Friday, Saturday, Sunday};
        int freezingDays=0; //counter

        // using a for loop to traverse through the array and an if statement to add 1 to the counter if it is less than 32 degrees.
        for (int i=0; i<days.length; i++){
            if (days[i]<32){
                freezingDays+=1;
            }
        }

        return freezingDays;
    }

    public String Warmest(){
        int [] days= {Monday, Tuesday , Wednesday, Thursday, Friday, Saturday, Sunday};
        String [] daysname= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"}; // second array to return the string name of the day;
        int highestIndex=0;

        // Traversing through the temperature array (days) and comparing the current i to the current highest index.
        //Updates highestIndex only if temp is higher, making sure that the first highest day is only counted.

        for (int i=1; i< days.length; i++) {
            if (days[i]>days[highestIndex]){
                highestIndex=i;
            }
        }

        //setting highestIndex to the names of the days to return the string
        return daysname[highestIndex]  ;
    }

    public void printTemps(){

        int [] days= {Monday, Tuesday , Wednesday, Thursday, Friday, Saturday, Sunday};
        String [] daysname= {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // using the same two array format I use a for loop with the string names(daysname) and temps (days) print in the correct format.

        //using a for loop to print out the name and the temp.
        for (int i=0; i<7; i++){
            if (i==0 || i==1 ||i==6 || i==4){
            System.out.println( daysname[i] + "\t\t" + days[i]); //using if statements and tabs to format correctly.
            }
            if (i==2 || i==3 ||i==5){
                System.out.println( daysname[i] + "\t" + days[i]);
            }

        }

    }
}
