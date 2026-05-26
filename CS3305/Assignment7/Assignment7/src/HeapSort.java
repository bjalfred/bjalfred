// Class HeapSort.java 
// Textbook - Listing 23.9, Page 878

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class HeapSort {
    /**
     * Heap sort method
     */
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new Heap<E>();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }


    // adding helper method to print PQ elements in order
    public static <E extends Comparable<E>> void HeapSort2(ArrayList<E> list) {
        // Create a Heap of elements
        Heap<E> heap = new Heap<E>();

        // Add elements to the heap
        for (int i = 0; i < list.size(); i++)
            heap.add(list.get(i));

        // Remove elements from the heap and overwrite list

        // looked up instanceof keyword on stack overflow
        //basically printing integers in descending order, so it can look right when dequeueing, doing it the regular way for strings
        if(!list.isEmpty() && list.get(0) instanceof Integer){
            for (int i = 0; i < list.size(); i++) {
                list.set(i, heap.remove());
            }
        }
        else {
            for (int i = list.size() - 1; i >= 0; i--)
                list.set(i, heap.remove());
        }
    }
}