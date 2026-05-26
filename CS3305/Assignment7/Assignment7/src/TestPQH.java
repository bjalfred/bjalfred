// Name: Brooke Alfrd
// Class:	  CS 3305/Section#02
// Term:		  Fall 2025
// Instructor:   Professor Maxwell Bradley
// Assignment:   6
// IDE Name:     TestPQH

import java.util.ArrayList;
import java.util.Scanner;

public class TestPQH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType = null;
        String sElement = null;
        Integer iElement = null;
        boolean running = true;
        PQ_heap<String> stringQueue=null;
        PQ_heap<Integer> numQueue=null;
        ArrayList<String> sList;
        ArrayList nList;


        System.out.println("----------------MAIN MENU---------------");
        System.out.println("0.\tEnter Queue Type (integer or string)");
        System.out.println("1.\tEnqueue Element");
        System.out.println("1.\tDequeue Element");
        System.out.println("1.\tCheck is_Full");
        System.out.println("1.\tEnqueue Element");
        System.out.println("1.\tCheck is_Empty");
        System.out.println("1.\tPrint PQueue size");
        System.out.println("1.\tDisplay Front Element");
        System.out.println("1.\tPrint PQueue Elements");
        System.out.println("8.\tExit Program");

        System.out.println("Enter the data type (Integer or String) : ");
        dataType = scanner.nextLine();
        dataType = dataType.toLowerCase();

        //making sure user enters right thing

        if (!(dataType.equals("string") || dataType.equals("integer"))) {
            int count = 0;
            do {
                if (dataType.equals("string")) {
                    stringQueue = new PQ_heap<String>();
                    count += 1;
                } else if (dataType.equals("integer")) {
                    numQueue = new PQ_heap<Integer>();
                    count += 1;
                } else {
                    System.out.println("Enter valid data type (Integer or String) : ");
                    dataType = scanner.nextLine();
                    dataType = dataType.toLowerCase();
                    count = 0;
                }
            } while (count == 0);

        }
        else{
            if (dataType.equals("string")) {
                stringQueue = new PQ_heap<String>();
            }
            else if (dataType.equals("integer")) {
                numQueue = new PQ_heap<Integer>();
            }

        }

        while (running) {
            System.out.println("----------------MAIN MENU---------------");
            System.out.println("0.\tEnter Queue Type (integer or string)");
            System.out.println("1.\tEnqueue Element");
            System.out.println("2.\tDequeue Element");
            System.out.println("3.\tCheck is_Full");
            System.out.println("4.\tCheck is_Empty");
            System.out.println("5.\tPrint PQueue size");
            System.out.println("6.\tDisplay Front Element");
            System.out.println("7.\tPrint PQueue Elements");
            System.out.println("8.\tExit Program");

            System.out.println("Enter the an option");

            //users option statement
            System.out.println("Enter option number: ");
            int Option = scanner.nextInt();
            scanner.nextLine();


            switch (Option) {
                case 0:
                    System.out.println("Enter the data type (Integer or String) : ");
                    dataType = scanner.nextLine();
                    dataType = dataType.toLowerCase();

                    //making sure user enters right thing

                    if (!(dataType.equals("string") || dataType.equals("integer"))) {
                        int count = 0;
                        do {
                            if (dataType.equals("string")) {
                                stringQueue = new PQ_heap<>();
                                count += 1;
                            } else if (dataType.equals("integer")) {
                                numQueue = new PQ_heap<>();
                                count += 1;
                            } else {
                                System.out.println("Enter valid data type (Integer or String) : ");
                                dataType = scanner.nextLine();
                                dataType = dataType.toLowerCase();
                                count = 0;
                            }
                        } while (count == 0);

                    }
                    break;
                case 1:
                    System.out.println("Enter the element you would like to insert : "); //statement

                    if (dataType.equals("string")) {
                        //if the statement is a string take in the input
                        sElement = scanner.nextLine();

                        sList = new ArrayList<>(stringQueue.printElements()); //creating a new list using printed elements to use my helper method in heapSort
                        HeapSort.HeapSort2(sList); //putting list in priority order
                        System.out.println("Priority Queue before enqueueing " + sElement + " :  " +sList); // print out the PQ before addding element

                        stringQueue.enqueue(sElement); // enqueueing element

                        sList = new ArrayList<>(stringQueue.printElements()); //creating a new list to update the input aftter enqueuing
                        HeapSort.HeapSort2(sList); //putting list in priority order
                        System.out.println("Priority Queue after enqueueing " + sElement + " :  " + sList); // print out the PQ after ading element

                    } else if (dataType.equals("integer")) {
                        // getting the element
                        iElement = scanner.nextInt();

                        nList = new ArrayList<>(numQueue.printElements()); //creating a new list using printed elements to use my helper method in heapSort
                        HeapSort.HeapSort2(nList); //putting list in priority order
                        System.out.println("Priority Queue before enqueueing " + iElement + " :  " + nList); // print out the PQ before adding element

                        numQueue.enqueue(iElement); // enqueueing element

                        nList = new ArrayList<>(numQueue.printElements()); //creating a new list to update the input after enqueuing
                        HeapSort.HeapSort2(nList); //putting list in priority order
                        System.out.println("Priority Queue after dequeueing " + iElement + " :  " + nList); // print out the PQ after adding element

                    }

                    break;

                case 2:

                    if (dataType.equals("string")) {

                        //making sure we cant dequeue without a list

                        if (stringQueue.is_empty()){
                            System.out.println("The queue is empty");
                        }
                        else {

                            String frontElement = stringQueue.front();

                            sList = new ArrayList<>(stringQueue.printElements()); //creating a new list using printed elements to use my helper method in heapSort
                            HeapSort.HeapSort2(sList); //putting list in priority order
                            System.out.println("Priority Queue before dequeueing " + frontElement + " :  " + sList); // print out the PQ before dequeueing element

                            stringQueue.dequeue(); // dequeueing element

                            sList = new ArrayList<>(stringQueue.printElements()); //creating a new list to update the input aftter dequeuing
                            HeapSort.HeapSort2(sList); //putting list in priority order
                            System.out.println("Priority Queue after dequeueing " + sElement + " :  " + sList); // print out the PQ after removing element
                        }

                    } else if (dataType.equals("integer")) {
                        if (numQueue.is_empty()){
                            System.out.println("The queue is empty");
                        }
                        else {
                            Integer frontElement = numQueue.front();

                            nList = new ArrayList<>(numQueue.printElements()); //creating a new list using printed elements to use my helper method in heapSort
                            HeapSort.HeapSort2(nList); //putting list in priority order
                            System.out.println("Priority Queue before dequeueing " + frontElement + " :  " + nList); // print out the PQ before removing element

                            numQueue.dequeue(); // enqueueing element

                            nList = new ArrayList<>(numQueue.printElements()); //creating a new list to update the input aftter dequeueing
                            HeapSort.HeapSort2(nList); //putting list in priority order
                            System.out.println("Priority Queue after enqueueing " + frontElement + " :  " + nList); // print out the PQ after removing element
                        }

                    }

                    break;
                case 3:
                    if  (dataType.equals("string")  && stringQueue.is_full()) {
                        System.out.println("The queue is currently full, please remove some elements");
                    }
                    else if (dataType.equals("string")  && !stringQueue.is_full()) {
                        System.out.println("The queue is not full");
                    }

                    if  (dataType.equals("integer")  && numQueue.is_full()) {
                        System.out.println("The queue is currently full, please remove some elements");
                    }
                    else if (dataType.equals("integer")  && !numQueue.is_full()) {
                        System.out.println("The queue is not full");
                    }
                    break;
                case 4:
                    if  (dataType.equals("string")  && stringQueue.is_empty()) {
                        System.out.println("The queue is empty");
                    }
                    else if  (dataType.equals("string")  && !stringQueue.is_empty()) {
                        System.out.println("The queue is not empty");
                    }

                    if  (dataType.equals("integer")  && numQueue.is_empty()) {
                        System.out.println("The queue is empty");
                    }
                    else if( dataType.equals("integer")  && !numQueue.is_empty()) {
                        System.out.println("The queue is not empty");
                    }
                    break;

                case 5:
                    if (dataType.equals("string") ) {
                        if (stringQueue == null || stringQueue.is_empty()) {
                            System.out.println("The queue is empty");
                        } else {
                            System.out.println("Priority Queue Size: " + stringQueue.size());
                        }
                    }
                    if (dataType.equals("integer") ) {
                        if (numQueue == null || numQueue.is_empty()) {
                            System.out.println("The queue is empty");
                        } else {
                            System.out.println("Priority Queue Size: " + numQueue.size());
                        }
                    }
                    break;
                case 6:
                    if  (dataType.equals("string") && !stringQueue.is_empty()) {
                        System.out.println("The front element is  : " + stringQueue.front());
                    }
                    else{
                        System.out.println("The queue is empty");
                    }
                    if  (dataType.equals("integer") && !numQueue.is_empty()) {
                        System.out.println("The front element is  : " + numQueue.front());
                    }
                    else{
                        System.out.println("The queue is empty");
                    }
                    break;

                case 7:
                    if (dataType.equals("string") ) {
                        if (stringQueue == null || stringQueue.is_empty()) {
                            System.out.println("The queue is empty");
                        } else {
                            sList= new ArrayList<>(stringQueue.printElements());
                            stringQueue.pqPrint(sList);
                        }
                    }
                    if (dataType.equals("integer") ) {
                        if (numQueue == null || numQueue.is_empty()) {
                            System.out.println("The queue is empty");
                        } else {
                            numQueue.pqPrint(numQueue.printElements());
                        }
                    }
                    break;
                case 8:

                    //shutdown menu
                    System.out.println("Shutting down...");
                    running = false;

            }


        }
    }
}