package sorts;
/* *****************General Merge Sort Implementation****************** */

/* Merge sort algorithm divides the Input Array into two halves.
* It sorts the two halves individually and then merges them to form a sorted array.
* It uses an auxillary array (a temporary array) to sort.
* Space Complexity: O(N)
* Time Complexity: O(N logN) compares with max. (6N logN) array accesses */

/**
 * @author: Aviral Nigam
*/

import java.util.Scanner;

public class MergeSort {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int N;
        System.out.println("Enter the Size of the Input array: ");
        N = in.nextInt(); // Input the array size
        //Initializing arrays
        int[] a = new int[N]; // Input array initialized
        int[] aux = new int[N]; //Auxillary array initialized
        //User input array
        System.out.println("\nEnter "+N+" elements to be sorted: ");
        for (int i = 0; i <N ; i++) {
            a[i] = in.nextInt();
        }
        System.out.println("\nElements Entered are: ");
        //copying the input array to an auxillary array
        for (int j = 0; j < N; j++) {
            System.out.print(a[j]+ " ");
        }
        int lo=0;
        sort(a, aux, lo, N-1);
        printSortedArray(a, N);
    }
    public static void sort(int[] a, int[] aux, int lo, int hi) {
        if (lo >= hi)
            return;
        int mid = lo + (hi - lo) / 2; // computes the value of mid point
        sort(a, aux, lo, mid); // sorts the first half
        sort(a, aux, mid + 1, hi); // sorts the second half
        merge(a, aux, lo, mid, hi); // merge two halves
    }
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        //merge the two sorted arrays.
        //Convention: if both the array have an equal value, then the first one is copied
        for (int k = lo; k <=hi ; k++) {
            aux[k]=a[k];
        }
        int i=lo; int j=mid+1; int k=lo;
        while(i <= mid && j <= hi) {
            //if the left element is smaller or equal to the element in the right
            //then copy the left element from the auxillary into the array.
            if(aux[i] <= aux[j]) {
                a[k]=aux[i];
                i++;
            }
            else {
                a[k]=aux[j];
                j++;
            }
            k++;
        }
        //copy the remaining elements on the left sub-array
        while (i <= mid) {
            a[k] = aux[i];
            k++;
            i++;
        }
    }
    public static void printSortedArray(int[] a, int N) {
        //to print the output array in sorted order using MergeSort
        System.out.println("\nElements in Sorted Order: ");
        for (int i = 0; i < N ; i++) {
            System.out.print(a[i] + " ");
        }

    }
}
