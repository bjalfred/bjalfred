// Name:		  Brooke Alfred
// Class:	  CS 3305/Section#2
// Term:		  Fall 2025
// Instructor:   Professor Bradley
// Assignment:   5
// IDE Name:	  <IntelliJ>

import java.util.Scanner;
import java.util.Arrays;


public class RadixSort {
    /*
    This method takes in the users integer array to compare numbers and see the max number of digits in this array.
     */
    public static int countDigits(int[] numbers) {
        int max = 0; // variable to keep track of the largest number of digits
        int divideDigit = 0;// used to store numbers[i]
        int counter = 0;// counter used to count the number of digits

        // for loop going through each number in the array
        for (int i = 0; i < numbers.length; i++) {
            divideDigit = numbers[i];

            if (divideDigit == 0) {
                counter += 1; // if the number is single digit, automatically count is as one digit
            } else {
                while (divideDigit > 0) {
                    divideDigit = divideDigit / 10; // divide the number by ten until it is zero (java has built in floor divisionn for intgers)
                    counter += 1; // add one for each time this loops
                }
            }

            if (max < counter) {
                max = counter; // if the counter is bigger on one iteration max=counter;
                counter = 0; // reset the digits
            }
        }
        return max;
    }
    /*
    This method takes in the number we found from Count Digits and the integer array to create a radix sort that loops and overwrites the array
    by sorting by single digits
     */
    public static int[] extractDigits(int passes, int[] numbers) {

        int number = 0; // variable used to hold numbers[i]
        int digit=0; // used after the division to hold single digits

        // for loop K to loop around the amount of passes-1, this variable os used to also increment the divisor when singling out digits. k goes from 0 to passes-1
        for (int k=0; k<passes; k++) {

            int divisor = (int) Math.pow(10, k); // putting 10 to the power of k and casting it to an int. I had to look this up because java cannot use the ** operator like python.

            // creating 10 queue objects (buckets Q0-Q9)
            Queue<Integer> Q0 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q1 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q2 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q3 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q4 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q5 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q6 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q7 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q8 = new Queue<Integer>(); //create the buckets for the radix sort
            Queue<Integer> Q9 = new Queue<Integer>(); //create the buckets for the radix sort

            // second for loop i. i loops over the inputted array list to single out digits.
            for (int i = 0; i < numbers.length; i++) {
                number = numbers[i];
                digit = (number / divisor) % 10; // Digit is setting up the modulus division needed to sety up each digit. As we saw in k, it goes from 0-passes-1

                // switch case to enqueue into different buckets based on the digit gained
                switch (digit) {
                    case 0:
                        Q0.Enqueue(number);
                        break;
                    case 1:
                        Q1.Enqueue(number);
                        break;
                    case 2:
                        Q2.Enqueue(number);
                        break;
                    case 3:
                        Q3.Enqueue(number);
                        break;
                    case 4:
                        Q4.Enqueue(number);
                        break;
                    case 5:
                        Q5.Enqueue(number);
                        break;
                    case 6:
                        Q6.Enqueue(number);
                        break;
                    case 7:
                        Q7.Enqueue(number);
                        break;
                    case 8:
                        Q8.Enqueue(number);
                        break;
                    case 9:
                        Q9.Enqueue(number);
                        break;
                }
                }
            // back in the k loop we dequeue the buckets in order.
            int index = 0;// used because some buckets have more than one number in it
            while (!Q0.isEmpty()) {
                numbers[index++] = Q0.Dequeue(); // overwriting numbers and accounting for if there are multiple numbers in said queue. this is thew same for all while loops
            }
            while (!Q1.isEmpty()) {
                numbers[index++] = Q1.Dequeue();
            }
            while (!Q2.isEmpty()) {
                numbers[index++] = Q2.Dequeue();
            }
            while (!Q3.isEmpty()) {
                numbers[index++] = Q3.Dequeue();
            }
            while (!Q4.isEmpty()) {
                numbers[index++] = Q4.Dequeue();
            }
            while (!Q5.isEmpty()) {
                numbers[index++] = Q5.Dequeue();
            }
            while (!Q6.isEmpty()) {
                numbers[index++] = Q6.Dequeue();
            }
            while (!Q7.isEmpty()) {
                numbers[index++] = Q7.Dequeue();
            }
            while (!Q8.isEmpty()) {
                numbers[index++] = Q8.Dequeue();
            }
            while (!Q9.isEmpty()) {
                numbers[index++] = Q9.Dequeue();
            }
        }
        return numbers;
    }



    public static void main (String[] args)
    {
        boolean running = true; // creating a boolean to use in the while loop
        Scanner scanner= new Scanner(System.in); //creating a scanner object

        int Size=0; // variable needed to initialize the array;
        int[] integers=null; // integer array variable needed to be used in multiple switch cases;
        String origIntegers="["; // String object made to store the original array for printing;

        while (running) {

            //menu prompt

            System.out.println("---------MAIN MENU---------");
            System.out.println("1.\tRead Array Size");
            System.out.println("2.\tRead Array Values");
            System.out.println("3.\tRun Radix Sort and print outputs");
            System.out.println("4.\tExit Program");
            System.out.println();

            System.out.println("Enter option number: ");

            int Option = scanner.nextInt(); //option scanner


            switch (Option) {
                //getting size of the array;
                case 1: {
                    System.out.println("What is the size of your array?");
                    Size = scanner.nextInt(); // scanner used to take in the size;
                    break;
                }
                //reading inputs for the array
                case 2: {
                    System.out.println("Enter in the values for your array (positive values only): ");
                    integers= new int[Size];

                    // for loop used to take in the numbers
                    for (int i=0; i<integers.length; i++){
                        System.out.println("Enter number " + (i+1));
                        int enterNum= scanner.nextInt();
                        // check to make sure no negative values are being inputted.
                        while (enterNum<0) {
                            System.out.println("Invalid input. Enter a positive number: ");
                            enterNum = scanner.nextInt();
                        }

                        integers[i]=enterNum;// putting these values into the array

                        origIntegers+=enterNum +", "; // creating the orginal string array object
                    }
                    origIntegers+="]"; // closing off the string
                    break;
                }
                //Running radix sort
                case 3: {
                    int passes= countDigits(integers); //saving countDigits returned int as passes

                    int[] newIntegers =extractDigits(passes,integers); // making a new array variable to keep the return from extractDigits

                    //printing according to assignment instructions

                    System.out.println("Array values before sorting:\t" + origIntegers);
                    System.out.println("Array values after sorting:\t"+ Arrays.toString(newIntegers) );
                    integers=null;
                    break;
                }
              //Exit program
                case 4: {
                    // shutting down prompt
                    System.out.println("Shutting down ...");
                    running=false;}
                }
            }
        }

    }

