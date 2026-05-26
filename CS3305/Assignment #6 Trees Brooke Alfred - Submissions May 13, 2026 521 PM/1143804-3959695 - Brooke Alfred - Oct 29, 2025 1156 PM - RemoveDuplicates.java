// Name: Brooke Alfrd
// Class:	  CS 3305/Section#02
// Term:		  Fall 2025
// Instructor:   Professor Maxwell Bradley
// Assignment:   6
// IDE Name:     RemoveDuplicates
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {
/*
Method listInOrder- takes in the root of the tree as well as a list. The method works just like the inorder function
but puts the inputs the values into an array list so it can remove duplicates easily.
 */
    public static ArrayList<String> listInOrder( BST.TreeNode<String> root, ArrayList<String> list){
        if (root==null) return list;
        listInOrder(root.left,list);// recursive call shown in BST class
        list.add(root.element); // instead of printing the elements out like the inorder method, we will add them to a list
        listInOrder(root.right,list);// recursice call shown in BST class
        return list;
    }

    public static void main(String[] args) {

        Scanner scanner= new  Scanner(System.in); //scanner for recursive call
        BST<String> input = new BST<>(); //creating the BST object
        boolean running = true; //boolean for while loop

        //instantiated null variables so they can be accessed in multiple parts of the switch statement if needed
        String wordSalad=null;
        String saveWords=null;
        ArrayList<String> elements = null;
        ArrayList<Integer> indexes=null;


        while(running) {

            //menu
            System.out.println("-----------------MAIN MENU---------------");
            System.out.println("1.\tRead input string");
            System.out.println("2.\tRemove duplicates and display outputs");
            System.out.println("3\tExit program");

            // scanner for user choice
            System.out.print("Enter option number: ");
            int Option  = scanner.nextInt();
            scanner.nextLine();

            switch (Option) {
                case 1:
                    // getting the string that will be put into the BST
                    System.out.println("Enter a string with spaces in between each word: ");
                    wordSalad = scanner.nextLine();
                    //saving the original word
                    saveWords = wordSalad;
                    // using string split to put that word into an array
                    String[] words= wordSalad.split(" ");

                    //using a for loop to add all words to the array list
                    for (int i=0;i<words.length;i++) {
                        input.insert(words[i]);
                    }
                    break;
                case 2:
                    //creating an array list to hold the words, creating an index array to save the indexes that need to be removed
                    elements=new ArrayList<>();
                    indexes=new ArrayList<>();

                    //using the input to put the words in inorder format
                    listInOrder(input.root,elements);

                    // if statement to control if tree is empty
                    if (elements.isEmpty()){
                        System.out.println("Please insert input string to find duplicates.");
                    }
                    else {
                        // inputting the values of the indexes of repeated words into indexes
                        for (int i = 0; i < elements.size() - 1; i++) {
                            //because the elements were put in order any duplicates will be right next to each other, you only have to compare i and i+1
                            if ((elements.get(i)).equals(elements.get(i + 1))) {
                                indexes.add(i);
                            }
                        }

                        //moving backwards to keep the elements from shifting im taking out the indexes that should be removed
                        for (int i = indexes.size() - 1; i >= 0; i--) {
                            elements.remove((int) indexes.get(i));
                        }

                        //printing out the before and after
                        System.out.println("Original text: ");
                        System.out.println(saveWords);

                        System.out.println("Processed text:");
                        for (int i = 0; i < elements.size(); i++) {
                            System.out.print(elements.get(i) + " ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    //shutdown menu
                    System.out.println("Shutting down...");
                    running= false;
            }

        }



    }
}