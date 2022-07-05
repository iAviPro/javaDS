package sorts;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/** 
 * ######## HEAP ########
 * Two conditions to make a heap:
 * a. The binary tree should be a complete binary tree - i.e. hieght of tree should be (log n) and the leaf nodes shoul dbe added left -> right
 * b. Value of root should be greater than or equal to all its children - MAx Heap and vice versa if Min Heap
 * 
 * 
 * ######### HEAP REPRESENTATION ##########
 * Root labelled as 0
 * A heap can be represented as an array where a node with label i in array has left child at 2*i+1 and right child at 2*i+2
 * A node with label i will have its parent at floor((i-1)/2)
 * 
 * ############################### HEAP SORT ALGORITHM #############################
 * 1. build a heap from the given array by inserting each element in the heap DS
 * 2. Swap each element from the top / root of the heap and put it in the last of the array
 * 3. Re-heapify / balance the complete BT to be a heap.
 * 
 */
public class HeapSort {

    // create heap of a given array
    public static void buildHeap(int[] arr) {
        for(int i = arr.length/2-1; i>=0;i--) {
            heapify(arr, i, arr.length);
        }
    }
    public static void heapify(int[] arr, int i, int max) {
        // initialise largest as root, and then its left and right labels
        int largest = i, left = 2*i+1, right  = 2*i+2;
        //if left label is not greater than the max length then compare the largest value between left or root node
        if (left < max && arr[left] > arr[largest]) {
            largest = left;
        } 
        // if right label is not greater than the max length then compare the largest value between right or root node
        if (right < max && arr[right] > arr[largest]) {
            largest = right;
        } 
        // if largest variable is not equal to root then swap the node and the largest value and again recursively heapify
        if (largest != i) {
            //swapping
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // again heapifying the changed array
            heapify(arr, largest, max);
        }
    }

    public static int[] heapSort(int[] arr) {
        // create a heap by inserting each element of the array to heap
        buildHeap(arr);
        // once array is converted to heap then iterate through the heapified array and 
        // swap the first (root) node to the last node and then re-heapify the remaining array
        for (int i = arr.length - 1; i >= 0; i--) {
            // swap the first / root element with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
             heapify(arr,0,i);
        }
       return arr;
    }
    // driver main method
    public static void main(String[] args) {
        // initialise the array
        int[] arr = {8, 11, 9, 02, 10, 16};
        // call heapsort
        heapSort(arr);
        // print each element of the heap sorted array
        System.out.println("Sorted Array (by Heap Sort) is: ");
        IntStream.of(arr).forEach(i -> System.out.printf("%d ",i));
       // System.out.println(heapSort(arr));
       //printArray(arr);
    }
}
