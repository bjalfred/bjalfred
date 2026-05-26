
// Name: Brooke Alfrd
// Class:	  CS 3305/Section#02
// Term:		  Fall 2025
// Instructor:   Professor Maxwell Bradley
// Assignment:   6
// IDE Name:     MyTestBST

import java.util.Scanner;


public class MyTestBST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType= null;
        BST<Integer> numtree = null;
        BST<String> stringtree = null;
        int Option;
        String sElement=null;
        int iElement;

        // forcing level 0. printing menu options
        System.out.println(" ----------------MAIN MENU---------------");
        System.out.println("0.\tEnter Tree Data Type (integer or string)");
        System.out.println("1.\tInsert Data Element");
        System.out.println("2.\tDelete Data Element");
        System.out.println("3.\tSearch for Data Element");
        System.out.println("4.\tPrint Tree Size");
        System.out.println("5.\tPath from Root to Data Element");
        System.out.println("6.\tCheck if Empty Tree");
        System.out.println("7.\tPrint Preorder Traversal");
        System.out.println("8.\tPrint Inorder Traversal");
        System.out.println("9.\tPrint Postorder Traversal");
        System.out.println("10.\tExit program");

        //having user instantiate initial tree
        System.out.println("Enter the data type (Integer or String) : ");
        dataType= scanner.nextLine();
        dataType=dataType.toLowerCase();

        //making sure user enters right thing

        if (!(dataType.equals("string") || dataType.equals("integer"))){
            int count=0;
            do {
                if (dataType.equals("string") || dataType.equals("integer")){
                    count+=1;
                }
                else{
                    System.out.println("Enter valid data type (Integer or String) : ");
                    dataType= scanner.nextLine();
                    dataType=dataType.toLowerCase();
                    count=0;
                }
            } while (count==0);

        }


        //if statement to instantiate tree based on the right element
        if (dataType.equals("integer")){
            numtree = new BST<Integer>();
        }
        else if (dataType.equals("string")) {
            stringtree = new BST<String>();
        }

        //boolean for while loop
        boolean running= true;

        while (running){
            //menu options again
            System.out.println(" ----------------MAIN MENU---------------");
            System.out.println("0.\tEnter Tree Data Type (integer or string)");
            System.out.println("1.\tInsert Data Element");
            System.out.println("2.\tDelete Data Element");
            System.out.println("3.\tSearch for Data Element");
            System.out.println("4.\tPrint Tree Size");
            System.out.println("5.\tPath from Root to Data Element");
            System.out.println("6.\tCheck if Empty Tree");
            System.out.println("7.\tPrint Preorder Traversal");
            System.out.println("8.\tPrint Inorder Traversal");
            System.out.println("9.\tPrint Postorder Traversal");
            System.out.println("10\tExit program");

            //users option statement
            System.out.println("Enter option number: ");
            Option=scanner.nextInt();
            scanner.nextLine();

            //switch case to handle each input from the user
            switch(Option) {

                // repeat of the forced zero if the user wants to do multiple trees
                case 0:
                    System.out.println("Enter the data type (Integer or String) : ");
                    dataType= scanner.nextLine();
                    dataType=dataType.toLowerCase();

                    if (!(dataType.equals("string") || dataType.equals("integer"))){
                        int count=0;
                        do {
                            if (dataType.equals("string") || dataType.equals("integer")){
                                count+=1;
                            }
                            else{
                                System.out.println("Enter valid data type (Integer or String) : ");
                                dataType= scanner.nextLine();
                                dataType=dataType.toLowerCase();
                                count=0;
                            }
                        } while (count==0);

                    }

                    if (dataType.equals("integer")){
                        numtree = new BST<Integer>();
                    }
                    else if (dataType.equals("string")) {
                        stringtree = new BST<String>();
                    }
                    break;
                //inserting elements
                case 1:
                    System.out.println("Enter the element you would like to insert : "); //statement

                    if (dataType.equals("string")) {
                        //if the statement is a string take in the input
                        sElement = scanner.nextLine();

                        System.out.print("BST before inserting " + sElement + " (Inorder):  "); // print out the tree before adding the word into the tree
                        stringtree.inorder();
                        System.out.println();

                        System.out.print("BST after inserting " + sElement + " (Inorder):  "); // print out the tree after adding the word to the tree
                        stringtree.insert(sElement);
                        stringtree.inorder();
                        System.out.println();
                    } else if (dataType.equals("integer")) {
                        // getting the element
                        iElement = scanner.nextInt();

                        System.out.print("BST before inserting " + iElement + " (Inorder):  "); //print out the tree before adding the integer to the tree
                        numtree.inorder();
                        System.out.println();

                        System.out.print("BST after inserting " + iElement + " (Inorder):  "); // print out the tree after adding integer to the tree
                        numtree.insert(iElement);
                        numtree.inorder();
                        System.out.println();
                    }

                    break;

                case 2:

                    System.out.println("Enter the element you would like to delete : ");

                    if (dataType.equals("string") && ! stringtree.isEmpty()) {
                        sElement = scanner.nextLine();

                        // if the element exists delete it
                        if (stringtree.search(sElement)) {
                            System.out.print("BST before deleting" + sElement + " (Inorder):  "); //print out the tree before deleting the word from the tree
                            stringtree.inorder();
                            System.out.println();

                            System.out.print("BST after deleting " + sElement + " (Inorder):  "); //print out the tree after deleting the word from the tree
                            stringtree.delete(sElement);
                            stringtree.inorder();
                            System.out.println();
                        } else {
                            System.out.println("Element not found"); // if not found in the tree let the user know
                        }
                    } else if (dataType.equals("integer") && ! numtree.isEmpty()) {

                        iElement = scanner.nextInt(); //entering element to be deleted

                        //if the element exists proceed with deletion
                        if (numtree.search(iElement)) {
                            System.out.print("BST before deleting " + iElement + " (Inorder):  "); //print out the tree before deleting the integer from the tree
                            numtree.inorder();
                            System.out.println();

                            System.out.print("BST after deleting" + iElement + " (Inorder):  "); //print out the tree after deleting the integer from the tree
                            numtree.delete(iElement);
                            numtree.inorder();
                            System.out.println();
                        } else {
                            System.out.println("Element not found"); // let the user know that the integer isn not in the tree
                        }
                    }
                    else{
                        System.out.println("There are no nodes in tree"); // let user know no nodes in tree
                    }
                    break;


                case 3:
                    System.out.println("Enter the element you would like to search for: "); //prompt

                    //outer if statement making sure that it differs between word trees and num trees and if they have nodes
                    if (dataType.equals("string") && ! stringtree.isEmpty()) {
                        sElement = scanner.nextLine(); //element to look for
                        // if element exists in the tree print true;
                        if (stringtree.search(sElement)) {
                            System.out.print("Is " + sElement + " in the tree? ");
                            System.out.print("True");
                            System.out.println();
                        } else {
                            // if it doesnt exist print false
                            System.out.print("Is " + sElement + " in the tree? ");
                            System.out.print("False");
                            System.out.println();
                        }
                    } else if (dataType.equals("integer") &&  ! numtree.isEmpty()) {
                        iElement = scanner.nextInt(); // element to look for

                        //if element exists in the tree print true;
                        if (numtree.search(iElement)) {
                            System.out.print("Is " + iElement + " in the tree? ");
                            System.out.print("True");
                            System.out.println();;
                        } else {
                            //if element exists in the tree print false;
                            System.out.print("Is " + iElement + " in the tree? ");
                            System.out.print("False");
                            System.out.println();
                        }
                    }
                    else{
                        System.out.println("There are no nodes in the tree."); //tell the user that there are no nodes
                    }

                    break;

                case 4:
                    // differ based on type of trees, and whether the tree is empty or not
                    //print the tree size
                    if (dataType.equals("string") && !stringtree.isEmpty()) {
                        System.out.println("Tree size: " + stringtree.size);
                    } else if (dataType.equals("integer") && numtree.getRoot()!= null) {
                        System.out.println("Tree size: " + numtree.size);
                    }
                    else{
                        // if there is nothing in the tree tell user that
                        System.out.println("There are no nodes in tree");
                    }
                    break;

                case 5:
                    // differing based on data type + whether the tree has nodes

                    if (dataType.equals("string") && !stringtree.isEmpty()) {
                        //printing out prompts according to document
                        System.out.println("Enter an element to find the path: ");
                        sElement = scanner.nextLine();
                        System.out.print("\nA path from the root to " + sElement + " is: ");

                        // using code found in testBST to print out the elements with tweaks
                        java.util.ArrayList<BST.TreeNode<String>> path = stringtree.path(sElement);
                        for (int i = 0; path != null && i < path.size(); i++)
                            System.out.print(path.get(i).element + " ");
                        System.out.println();
                    }
                    else if  (dataType.equals("integer") && ! numtree.isEmpty()) {
                        //printing out prompts according to document
                        System.out.println("Enter an element to find the path: ");
                        iElement = scanner.nextInt();
                        System.out.print("\nA path from the root to " + iElement + " is: ");

                        // using code found in testBST to print out the elements with tweaks
                        java.util.ArrayList<BST.TreeNode<Integer>> path = numtree.path(iElement);
                        for (int i = 0; path != null && i < path.size(); i++)
                            System.out.print(path.get(i).element + " ");
                        System.out.println();
                    }
                    else{
                        System.out.println("There are no nodes in the tree"); // if the tree has no nodes tell user
                    }

                    break;
                case 6:
                    // differs based on whether the tree is full, and element type
                    if (dataType.equals("string")) {
                        // if tree is empty print true else print false
                        if (stringtree.isEmpty()) {
                            System.out.print("Is tree empty? ");
                            System.out.print("True");
                            System.out.println();
                        } else {
                            System.out.print("Is tree empty? ");
                            System.out.print("False");
                            System.out.println();
                        }
                    }
                    else if (dataType.equals("integer")) {
                        // if tree is empty print true else print false

                        if (numtree.isEmpty()) {
                            System.out.print("Is tree empty? ");
                            System.out.print("True");
                            System.out.println();
                        }
                        else{
                            System.out.print("Is tree empty? ");
                            System.out.print("False");
                            System.out.println();
                        }
                    }
                    break;

                case 7:
                    // if the tree is not empty print, takes into account element type
                    if (dataType.equals("string") && ! stringtree.isEmpty()) {
                        System.out.print("Preorder: ");
                        stringtree.preorder();
                        System.out.println();
                    }
                    else if (dataType.equals("integer") && ! numtree.isEmpty()) {
                        System.out.print("Preorder: ");
                        numtree.preorder();
                        System.out.println();
                    }
                    else{
                        System.out.println("There are no nodes in the tree."); // if no nodes in tree tell user
                    }
                    break;

                case 8:
                    // if the tree is not empty print, takes into account element type
                    if (dataType.equals("string") && ! stringtree.isEmpty()) {
                        System.out.print("Inorder: ");
                        stringtree.inorder();
                        System.out.println();
                    }
                    else if (dataType.equals("integer") && ! numtree.isEmpty()) {
                        System.out.print("Inorder: ");
                        numtree.inorder();
                        System.out.println();
                    }
                    else{
                        System.out.println("There are no nodes in the tree."); //if no nodes in tree tell user
                    }
                    break;

                case 9:
                    // if the tree is not empty print, takes into account element type
                    if (dataType.equals("string") && ! stringtree .isEmpty()) {
                        System.out.print("Postorder: ");
                        stringtree.postorder();
                        System.out.println();
                    }
                    else if (dataType.equals("integer") && ! numtree.isEmpty()) {
                        System.out.print("Postorder: ");
                        numtree.postorder();
                        System.out.println();
                    }
                    else{
                        System.out.println("There are no nodes in the tree."); //if no nodes in tree tell user
                    }
                    break;

                case 10:
                    //shutdown menu
                    System.out.println("Shutting down...");
                    running= false;
            }

        }

    }
}