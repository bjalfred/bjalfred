// Name:		  Brooke Alfred
// Class:	  CS 3305/Section#2
// Term:		  Fall 2025
// Instructor:   Professor Bradley
// Assignment:   8
// IDE Name:     hashFunctions

import java.util.Scanner;

public class hashFunctions
{
    // sumProbes method takes in a hashatable and adds all the of the probes in the second
    //column together and returns it
    public static int sumProbes(int[][] hashTable){
        int sum=0; // sum variable

        //for every value in the hashtable
        for (int i = 0; i < hashTable.length; i++){
            sum+=hashTable[i][1];// add the second column to the sum
        }

        return sum;// return the sum
    }

    /* linear probing, take in a hashtable and the key if the spot is full
    (there is a collision) you look at the sport directly next to it and do
    that cycle until there is a free spot
     */

    public static void HF1 (int[][] table, int key) {
        int count=0; //counter variable for probe count

        int value= key%50; //value defined using the modulus of the table size (keeps value between 0-49)

        //while the table value is full
        while (table[value][0] != 0) {
            value = (value + 1) % 50; // the new value of the key is moved to the next spot (+1)
            count += 1; // everytime this is done count it.
        }

        table[value][0] = key; // once that while loops finishes set the table at the value number to the key (putting the right number in that place)
        table[value][1]=count; // sdd count of probes to the second column
    }

    /*
    Quadratic probing. Take in a hashtable and its keys keep a copy of the original value mod 50, and when a spot is full
    increase the power of the step by two  based on the amount of steps that have been made. keeps data more spread out.
    */
    public static void HF2 (int[][] table, int key) {
        int count=0; //count variable
        int originalKey=key%50; //original key value

        int value= originalKey; //setting value to the key to keep the original value of the key safe

        int step=0; // the variable we will use to increase the steps

        //while the spot is full
        while (table[value][0] != 0) {
            step+=1; // increment the step so you can further the distance
            value = (originalKey + (step*step) )% 50; // add the originalkey to the quadratic step mod by 50 to keep it from 0-49
            count += 1; //update the probe count

        }

        table[value][0] = key; // once that while loops finishes set the table at the value number to the key (putting the right number in that place)
        table[value][1]=count; // sdd count of probes to the second column

    }

    /*
    double hashing, using the first hash function key%50 and incrementing by the second hash function 30-key%25
     */

    public static void HF3(int[][] table, int key) {
        int count=0; //count for probes

        int valueH1= key%50; // Hash function 1, regular modulus
        int valueH2=30-key%25; // Hash function two provided by our instructor

        // while a spot is full
        while (table[valueH1][0] != 0 && count<50) {
            valueH1= (valueH1+valueH2)%50; // value of Hash 1 is equal to value incremented by Hash 2
            count+=1; //update probe count
        }
        // if the count hits 50 stop
        if (count==50){
            System.out.println("Unable to store in the table " + key);
        }
        else{
            //add values into the table
            table[valueH1][0] = key;
            table[valueH1][1]=count;
        }

    }

    /*
    My hash function looked at trying to make the most distinct numbers out of the list of keys given. All the numbers in the list have 4 digits
    I looked for the combinations of two-digit numbers that would bring the least amounts of collisions, found that it was the second and fourth digits.
    I turn it into a two-digit number, if that number is 1, I add 39 because the 40s block has the least amount of numbers there and a good amount of collisions at 1 using this adding scheme,
    else if the value us greater than 49(the list size) I subtract 50 once, and I halve that value to get it to a smaller size. I then use linear probing to resolve collisions.
     */
    public static void HF4(int[][] table, int key) {
        int count = 0;
        int value=0;

        String stringNums = Integer.toString(key); //turn number into a character array to extract the 2nd and 4th digits

        //extracting digits + looked up how to turn char into num
        value += (Character.getNumericValue(stringNums.charAt( 1))*10);
        value+= Character.getNumericValue(stringNums.charAt(3));

        // a lot of the values collide at if the number is around 50-53 so this is a guard to move it to a region that is not as crowded
        if (value == 1) {
            value=39;  // move to less crowded region
        }

        // if value is greater than 50 subtract 50 and divide by two to make numbers in bound of the list (happens once)
        if (value>=49 ){
            value-=50;
            value=value/2;
        }

        // Probe until empty spot or until it is performed20 times
        while (table[value][0] != 0 && count <=20) {
            value = value + 1; //linear probing
            count += 1; //updating probes
        }

        // if count is over twenty don't store the key
        if (count>=20) {
            System.out.println("Unable to store in the table " + key);
        }
        else {
            table[value][0] = key;   // store key
            table[value][1] = count; // store probe count
        }
    }

    public static void main(String[] args) {

        //hardcoded list

    int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

    Scanner scanner= new Scanner(System.in); //scanner for options
    boolean running= true; //boolean for while loop

        //while loop
    while (running) {

        //menu
        System.out.println("-----MAIN MENU--------------------------------------");
        System.out.println("1.\tRun HF1 (Division method with Linear Probing)");
        System.out.println("2.\tRun HF2 (Division method with Quadratic Probing)");
        System.out.println("3.\tRun HF3 (Division method with Double Hashing)");
        System.out.println("4.\tRun HF4 (Student Designed HF");
        System.out.println("5.\tExit program");

        System.out.println("Enter option number:");
        int option= scanner.nextInt();

        switch (option) {
            //Linear Probing
            case 1:
                int[][] table= new int[50][2]; //creating the hash table
                // doing the operation on every key in the list
                for (int i = 0; i < keys.length; i++) {
                    int key = keys[i];
                    HF1(table, key);
                }

                //printing according to assignment instructions
                System.out.println("Hash table resulted from HF1: ");
                System.out.println();

                System.out.println("Index\tKey\t\tProbes");
                System.out.println("------------------------");

                for(int i = 0; i < table.length; i++) {
                    if (table[i][0]>0){
                        System.out.println(" "+i+"\t\t"+ table[i][0] + "\t " + table[i][1]);
                    }
                }
                System.out.println("------------------------");
                System.out.println();

                System.out.println("Sum of probe values = "+sumProbes(table) +" probes.");

                break;
                //Quadratic probing
            case 2:
                table= new int[50][2]; //creating the hash table
                // applying hf2 to every key in the list
                for (int i = 0; i < keys.length; i++) {
                    int key = keys[i];
                    HF2(table, key);
                }

                //printing according to assignment instructions
                System.out.println("Hash table resulted from HF2: ");
                System.out.println();

                System.out.println("Index\tKey\t\tProbes");
                System.out.println("------------------------");

                for(int i = 0; i < table.length; i++) {
                    if (table[i][0]>0){
                        System.out.println(" "+i+"\t\t"+ table[i][0] + "\t " + table[i][1]);
                    }
                }
                System.out.println("------------------------");
                System.out.println();

                System.out.println("Sum of probe values = "+sumProbes(table) +" probes.");
                break;
            case 3:
                table= new int[50][2]; //creating the hash table
                // applying double hashing to every key
                for (int i = 0; i < keys.length; i++) {
                    int key = keys[i];
                    HF3(table, keys[i]);
                }
                // printing according to assignment instructions
                System.out.println("Hash table resulted from HF3: ");
                System.out.println();

                System.out.println("Index\tKey\t\tProbes");
                System.out.println("------------------------");

                for(int i = 0; i < table.length; i++) {
                if (table[i][0]>0){
                    System.out.println(" "+i+"\t\t"+ table[i][0] + "\t " + table[i][1]);
                }
                }
                System.out.println("------------------------");
                System.out.println();

                System.out.println("Sum of probe values = "+sumProbes(table) +" probes.");
                break;
            case 4:
                table= new int[50][2]; //creating the hash table
                // my hash function
                for (int i = 0; i < keys.length; i++) {
                    int key = keys[i];
                    HF4(table, keys[i]);
                }
                // printing according to assignment instructions
                System.out.println("Hash table resulted from HF4: ");
                System.out.println();

                System.out.println("Index\tKey\t\tProbes");
                System.out.println("------------------------");

                for (int i = 0; i < table.length; i++) {
                    if (table[i][0]>0){
                        System.out.println(" "+i+"\t\t"+ table[i][0] + "\t " + table[i][1]);
                    }
                }
                System.out.println("------------------------");
                System.out.println();

                System.out.println("Sum of probe values = "+sumProbes(table) +" probes.");
                break;
            case 5:
                //shutdown menu
                System.out.println("Shutting down...");
                running= false;

        }
    }
    }
}