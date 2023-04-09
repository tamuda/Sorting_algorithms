/******************************************************************************
 *  Compilation:  javac Sorting.java
 *  Execution:    java Sorting input.txt AlgorithmUsed
 *  Dependencies: StdOut.java In.java Stopwatch.java
 *  Data files:   http://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                http://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *
 *  A program to play with various sorting algorithms. 
 *
 *
 *  Example run:
 *  % java Sorting 2Kints.txt  2
 *
 ******************************************************************************/
import java.awt.desktop.QuitEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;

public class Sorting {


 /**
     * 
     * Sorts the numbers present in the file based on the algorithm provided.
     * 0 = Arrays.sort() (Java Default)
     * 1 = Bubble Sort
     * 2 = Selection Sort 
     * 3 = Insertion Sort 
     * 4 = Mergesort
     * 5 = Quicksort
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)  { 
        In in = new In(args[0]);
        
		  // Storing file input in an array
        int[] a = in.readAllInts();
        // TODO: Generate 3 other arrays, b, c, d where
        // b contains sorted integers from a (You can use Java Arrays.sort() method)
        int[] b = a;
        Arrays.sort(b);

        // c contains all integers stored in reverse order
        int[] c = new int[b.length];
        int j = 0;
        for (int i = b.length-1; i >= 0; i--){
            c[j] = b[i];
            j++;
        }

        // d contains almost sorted array
        int[] d = b;
        int swaps = (int)(0.1 * d.length);
        for (int l=0; l<=swaps;l++){
            StdRandom random = new StdRandom();
            StdRandom random2 = new StdRandom();
            int pos = random.uniform(d.length-1);
            int pos2 = random2.uniform(d.length-1);
            int temp = d[pos];
            d[pos] = d[pos2];
            d[pos2] = temp;
        }
        //(You can copy b to a and then perform (0.1 * d.length)  many swaps to acheive this.   
       
        //TODO: 
        // Read the second argument and based on input select the sorting algorithm
        //  * 0 = Arrays.sort() (Java Default)
        //  * 1 = Bubble Sort
        //  * 2 = Selection Sort 
        //  * 3 = Insertion Sort 
        //  * 4 = Mergesort
        //  * 5 = Quicksort
        //  Perform sorting on a,b,c,d. Pring runtime for each case along with timestamp and record those. 
        // For runtime and priting, you can use the same code from Lab 4 as follows:
        int algorithm= Integer.parseInt(args[1]);
        //Switch statement to select the sorting algorithm
        switch (algorithm){
            case 0:
                Arrays.sort(a);
                Arrays.sort(b);
                Arrays.sort(c);
                Arrays.sort(d);
                break;
            case 1:
                bubble_sort(a);
                bubble_sort(b);
                bubble_sort(c);
                bubble_sort(d);
                break;
            case 2:
                selection_sort(a);
                selection_sort(b);
                selection_sort(c);
                selection_sort(d);
                break;
            case 3:
                insertion_sort(a);
                insertion_sort(b);
                insertion_sort(c);
                insertion_sort(d);
                break;
            case 4:
                Sorting ob = new Sorting();
                ob.sort(a, 0, a.length - 1);
                ob.sort(b, 0, b.length - 1);
                ob.sort(c, 0, c.length - 1);
                ob.sort(d, 0, d.length - 1);
                break;
            case 5:
                quick_sort(a,0,a.length-1);
                quick_sort(b,0,b.length-1);
                quick_sort(c,0,c.length-1);
                quick_sort(d,0,d.length-1);
                break;
            default:
                Arrays.sort(a);
                Arrays.sort(b);
                Arrays.sort(c);
                Arrays.sort(d);
                break;
        }
         // TODO: For each array, a, b, c, d:  
        Stopwatch timer = new Stopwatch();
        // TODO: Perform Sorting and store the result in an  array

        double time = timer.elapsedTimeMillis();
        
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
          //TODO: Replace with your own netid
        System.out.println(timeStamp);
        String netID = "tbiswas2";
          //TODO: Replace with the algorithm used 
        String algorithmUsed = "insertion sort";
          //TODO: Replace with the  array used 
        String arrayUsed = "a";
         // StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, arrayUsed, time, timeStamp, netID, args[0]);
          // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
  }


    //Bubble sort
    public static int[] bubble_sort(int[] array){
        int length = array.length;
        boolean swapped = true;
        while (swapped){
            swapped= false;
            for (int i=0; i<=length-2;i++){
                if (array[i]>array[i+1]){
                        int temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        swapped = true;
                }
            }
            length--;
        }

        return array;
    }

    //selection sort
    public static int[] selection_sort(int[] array) {
        int length = array.length;
        for (int j = 0; j < length - 1; j++) {
            int minIndex = j;
            for (int i = j + 1; i < length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            if (minIndex != j) {
                int temp = array[j];
                array[j] = array[minIndex];
                array[minIndex] = temp;
            }
        }
        return array;
    }

    //insertion sort
    public static int[] insertion_sort(int array[]) {
        int length = array.length;
        for (int i = 1; i < length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }

        return array;
    }


    //quick sort
    public static int[] quick_sort(int[] array, int low, int high) {
        if (low > high) {
            return array;
        }
        int mid = low + (high - low) / 2;
        int pivot = array[mid];
        int i = low;
        int j = high;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
            quick_sort(array, low, j);
        }
        if (i < high) {
            quick_sort(array, i, high);
        }
        return array;
    }

    //merge sort
    private static void mergesort(int[] array, int l, int m, int r) {
            int n1 = m - l + 1;
            int n2 = r - m;

            // Create temp arrays
            int L[] = new int[n1];
            int R[] = new int[n2];
            for (int i = 0; i < n1; ++i)
                L[i] = array[l + i];
            for (int j = 0; j < n2; ++j)
                R[j] = array[m + 1 + j];

            int i = 0, j = 0;

            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    array[k] = L[i];
                    i++;
                }
                else {
                    array[k] = R[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                array[k] = L[i];
                i++;
                k++;
            }

            while (j < n2) {
                array[k] = R[j];
                j++;
                k++;
            }
        }

        // Main function that sorts arr l and r using merge
        void sort(int array[], int l, int r) {
            if (l < r) {
                // Find the middle point
                int m = l + (r - l) / 2;

                // Sort first and second halves
                sort(array, l, m);
                sort(array, m + 1, r);

                // Merge the sorted halves
                mergesort(array, l, m, r);
            }
        }
    }






