// Name:		  brooke alfred
// Class:	  CS 3305/Section#2
// Term:		  Fall 2025
// Instructor:   Professor Bradley
// Assignment:   9
// IDE Name:     Reachability Matrix
import java.util.Scanner;


public class ReachabilityMatrix {

    /*
    This method takes in the 2d input matrix and prints it out into rows
     */
    public static void printMatrix(int[][] matrix) {
        //nested for loop to print the 2d array according to document instructions
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
    This method takes in a 2d reachability matrix and prints it out in rows
    as well as create the reachability table by testing different paths
     */
    public static void printReachabilityMatrix(int[][] matrix, int nodes) {

        // Creating the reachability table

        int[][] reachable = new int[nodes][nodes]; // new table to manipulate values
        for (int i = 0; i < nodes; i++) {
            for (int j = 0; j < nodes; j++) {
                reachable[i][j] = matrix[i][j]; //copying the matrix into the new array
            }
            reachable[i][i] = 1; // all diagonals are set to one because a node can reach it self
        }


        for (int k = 0; k < nodes; k++) { //keeps track of node
            for (int i = 0; i < nodes; i++) { //keeps track of row traveled
                for (int j = 0; j < nodes; j++) { //keeps track of column travled
                    if (reachable[i][k] == 1 && reachable[k][j] == 1) { // if there is a direct path from node to node
                        reachable[i][j] = 1; // the new input is 1
                    }
                }
            }
        }

        // Step 3: Fill reachability matrix with new values
        int [][] reachabilitymatrix = new int[nodes][nodes];
        for (int i = 0; i < nodes; i++) { //keeps track of row value
            for (int j = 0; j < nodes; j++) { //keeps track of column value
                int count = 0; //resetting count for each node
                for (int k = 0; k < nodes; k++) { // keeps track of k (representative node)
                    if (reachable[i][k] == 1 && matrix[k][j] == 1) count+=1; // of these paths ==1 add one
                }
                if (matrix[i][j] == 1) count++; // include direct edge
                reachabilitymatrix[i][j] = count;
            }
        }

        //nested for loop to print 2d reachability array according to document instructions
        for (int i = 0; i < reachabilitymatrix.length; i++) {
            for (int j = 0; j < reachabilitymatrix[i].length; j++) {
                System.out.print(reachabilitymatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    /*
    This method takes in an input matrix and calculates the in degrees by
    summing the collumns
     */
    public static void printDegrees(int[][] matrix) {
        //using a for loop to print out according to assignment instructions
        for (int i = 0; i < matrix.length; i++) {
            int inDegree = 0; //creating a new indegree value for each node
            for (int j = 0; j < matrix.length; j++) {
                inDegree += matrix[j][i]; // sum column
            }
            System.out.println("Node " + (i+1) + " in-degree is : " + inDegree);
        }
    }

    /*
    This method takes in an input matrix and calculates the in degrees by
    summing the rows
     */
    public static void printOutDegrees(int[][] matrix) {
        //nested for loop to print out like assignment instructions
        for (int i = 0; i < matrix.length; i++) {
            int outDegree = 0; //creating a new int variable for each node
            for (int j = 0; j < matrix.length; j++) {
                outDegree += matrix[i][j]; // sum row
            }
            System.out.println("Node " + (i +1)+ " out-degree is: " + outDegree);
        }
    }

    /*
    This method looks for when there is an edge pointing back to itself
    (finding all of the diagonals that equal 1)
     */
    public static void printSelfLoops(int[][] matrix) {
        int SelfLoops = 0;

        //for loop to count the self loops
        for (int i = 0; i < matrix.length; i++) {
            // if the diagonal== 1 add to self loops if not skip
            if (matrix[i][i] == 1) {
                SelfLoops+=1;
            }
        }

        System.out.println("Total self-loops in graph: " + SelfLoops);

    }

    /*
    This method takes in a input matrix, and finds the amount of paths of length n
    (the amount of nodes in the graph) from a start node to an end node by multiplying their outputs
    then summing the diagonals to get the total amount of cycles.
     */
    public static int printCycles(int[][] matrix, int length) {
        int n = length ;// length of the graph


        // copy input matrix into another temp matrix for the ending result
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = matrix[i][j];

        // Multiply matrix
        for (int l = 1; l < length; l++) {
            int[][] temp = new int[n][n]; //create a new temp array for manipulation

            //using a nested for loop to move throughout the array

            for (int i = 0; i < n; i++)//moves through the rows of the input matrix
                for (int j = 0; j < n; j++) { //moves through the columns of the matrix
                    int sum = 0; // resets sum for each pass
                    for (int k = 0; k < n; k++)
                        sum += result[i][k] * matrix[k][j]; // multiplies the result of the  row by result of the column
                    temp[i][j] = sum; // adds that sum to the temp array
                }
            result = temp; // overwrites the temp array with the new value
        }

        // Sum diagonal entries to count cycles
        int totalCycles = 0;
        for (int i = 0; i < n; i++)
            totalCycles += result[i][i]; // looks at the diagonals and adds them together

        return totalCycles; // returns that result
    }

    /*
    Finding direct paths which means summing the whole array because the input matrix is binary
     */
    public static int printPathsOfLength1(int[][] matrix) {
        int total = 0;
        //for loop to add everything in the array together
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix.length; j++)
                total += matrix[i][j]; //adding all the inputs together
        return total; // returning the total
    }

    /*
    Multiply the matrix by itself n (length) times to get the matrix we want
    then sum the entire 2d array to get the total amount of paths
     */

    public static int printPathsOfLengthN(int[][] matrix, int Length) {
        int n = Length;
        int[][] result = new int[n][n]; //creating a new array to manipulate values

        //copying the matrix into result
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[i][j] = matrix[i][j];

        for (int z = 1; z < Length; z++) { //make sure this is done n amount of times by uing length
            int[][] temp = new int[n][n]; // new temp array to store new values

            for (int i = 0; i < n; i++) //tracking the rows
                for (int j = 0; j < n; j++) { //tracking the columns
                    int sum = 0; //resetting the sum for each node
                    for (int k = 0; k < n; k++)
                        sum += result[i][k] * matrix[k][j]; // the result we are looking for is the result multiplication of the tracked rown and column by the new variable
                    temp[i][j] = sum; //adding that sum to the array
                }
            result = temp; //setting result== to the temp array
        }

        // Sum all entries
        int total = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                total += result[i][j];

        return total;

    }

    /*
        this method takes in an input matrix, sums all paths for said matrix,
        then finds the next matrix by multiplying it by the same matrix, and does it again
        until it does it n times
     */
    public static int printPathsOfLength1toN(int[][] matrix, int Length) {
        int n = matrix.length;
        int totalPaths = 0;

        //create a copy of the input matrix for manipulation
        int[][] powerMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                powerMatrix[i][j] = matrix[i][j];
            }
        }

        //sum all paths of current matrix
        for (int z = 1; z <= Length; z++) {
            // Sum all paths of current length
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    totalPaths += powerMatrix[i][j];
                }
            }

            // makes the next matrix by multiplying by itself
            if (z < Length)  { //this check makes sure it is done 3 times
                int[][] nextPower = new int[n][n]; //temp matrix for manipulation
                for (int i = 0; i < n; i++) { //keeps track of rows
                    for (int j = 0; j < n; j++) { // keeps tracks of columns
                        int sum = 0; // resets the sum for each node
                        for (int k = 0; k < n; k++)  { //intermediate variable representing the current node we are at
                            sum += powerMatrix[i][k] * matrix[k][j]; // multiplies the node representations together to get the new value
                        }
                        nextPower[i][j] = sum; //set that equal to that temp node
                    }
                }
                powerMatrix = nextPower; // update for next iteration
            }
        }
        return totalPaths; //after completion return the number

    }

    /*
    This method takes in a input matrix, and finds the amount of cycles from 1 to n
    from a start node to an end node by multiplying their outputs then summing the diagonals
    to get the total amount of cycles for that power, then multiplies the array to get the next power
    and completes the same process.
     */
    public static int printCyclesOfLength1toN(int[][] matrix, int Length) {
        int total = 0;
        int n = matrix.length;
        int[][] power = new int[n][n]; // array for manipulation

        //copying the input matrix into the new array
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                power[i][j] = matrix[i][j];

        for (int z = 1; z<= Length; z++) {
            // Sums all the diagonal entries
            for (int i = 0; i < n; i++)
                total += power[i][i];

            // adjusting the power
            if (z < Length) {
                int[][] next = new int[n][n]; //new temp array for manipulation
                for (int i = 0; i < n; i++) //keeps track of the rows value
                    for (int j = 0; j < n; j++) { //keeps track of the columns value
                        int sum = 0; //reset the sum for each node
                        for (int k = 0; k < n; k++) // uses k as a representation of the node we are manipulating
                            sum += power[i][k] * matrix[k][j]; // get the product of the row and column for said node
                        next[i][j] = sum; // add that value to the array
                    }
                power = next; //set the array equal to the manipulated one
            }
        }

        return total; //return the total

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //scanner for inputs
        boolean running = true; // boolean for while loop
        int[][] inputmatrix = null; //variable for array to make it reachable across cases
        int nodes=0; //variable for length

        while (running) {
            //menu
            System.out.println("----------------MAIN MENU---------------");
            System.out.println("1.\tEnter graph data");
            System.out.println("2.\tPrint outputs");
            System.out.println("3.\tExit Program");
            System.out.println("Enter option number: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // making sure that nodes are not above 5
                    System.out.println("Enter amount of nodes (max 5 min 1):");
                    nodes = scanner.nextInt();
                    while (nodes > 5 || nodes<1 ) {
                        System.out.println("You can only enter up to five nodes. Enter again:");
                        nodes = scanner.nextInt();
                    }

                    //creating the input matrix in a nxn fashion
                    inputmatrix = new int[nodes][nodes];

                    // Read the input matrix
                    for (int i = 0; i < nodes; i++) {
                        for (int j = 0; j < nodes; j++) {
                            System.out.println("Enter node [" + i + "," + j + "]:");
                            inputmatrix[i][j] = scanner.nextInt();
                        }
                    }

                    break;

                case 2:
                    //making sure data is entered to compute
                    if (nodes<1){
                        System.out.println("Please enter graph data first.");
                        break;
                    }
                    else {
                        //printing out according to assignment instructions
                        System.out.println("Input Matrix:");
                        printMatrix(inputmatrix);
                        System.out.println("Reachability Matrix:");
                        printReachabilityMatrix(inputmatrix, nodes);

                        System.out.println("In degrees:");
                        printDegrees(inputmatrix);

                        System.out.println("Out-degrees:");
                        printOutDegrees(inputmatrix);

                        System.out.println("Self-loops:");
                        printSelfLoops(inputmatrix);

                        System.out.println("Total number of cycles of length " + nodes + " edges: " + printCycles(inputmatrix, nodes));
                        System.out.println("Total number of paths of length 1 edge: " + printPathsOfLength1(inputmatrix));
                        System.out.println("Total number of paths of length " + nodes + " edges: " + printPathsOfLengthN(inputmatrix, nodes));
                        System.out.println("Total number of paths of length 1 to " + nodes + " edges: " + printPathsOfLength1toN(inputmatrix, nodes));
                        System.out.println("Total number of cycles of length 1 to " + nodes + " edges: " + printCyclesOfLength1toN(inputmatrix, nodes));
                    }

                    break;

                case 3:
                    System.out.println("Shutting down...");
                    running = false;
                    break;
            }
        }
    }

}
