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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.*;




public class Sorting {

    public static void main(String[] args) throws IOException {
        System.out.println(args[0] + " " + args[1]);

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
        Stopwatch timer = new Stopwatch();

        double timeA = 0;
        double timeB = 0;
        double timeC = 0;
        double timeD = 0;

        int algorithm= Integer.parseInt(args[1]);
        String name = "";
        // TODO: Perform Sorting and store the result in an  array
        //Switch statement to select the sorting algorithm
        switch (algorithm){
            case 0:
                name = "default";

                //sorting array a w/ time using the default
                Stopwatch timerA = new Stopwatch();
                defaultSort(a);
                timeA = timerA.elapsedTimeMillis();

                //sorting array b w/ time using the default
                Stopwatch timerB = new Stopwatch();
                defaultSort(b);
                timeB = timerB.elapsedTimeMillis();

                //sorting array c w/ time using the default
                Stopwatch timerC = new Stopwatch();
                defaultSort(c);
                timeC = timerC.elapsedTimeMillis();

                //sorting array d w/ time using the default
                Stopwatch timerD = new Stopwatch();
                defaultSort(d);
                timeD = timerD.elapsedTimeMillis();
                break;
            case 1:
                name = "bubble";

                //sorting array a w/ time using bubble sort
                timerA = new Stopwatch();
                bubbleSort(a);
                timeA = timerA.elapsedTimeMillis();

                //sorting array b w/ time using bubble sort
                timerB = new Stopwatch();
                bubbleSort(b);
                timeB = timerB.elapsedTimeMillis();

                //sorting array c w/ time using bubble sort
                timerC = new Stopwatch();
                bubbleSort(c);
                timeC = timerC.elapsedTimeMillis();

                //sorting array d w/ time using bubble sort
                timerD = new Stopwatch();
                bubbleSort(d);
                timeD = timerD.elapsedTimeMillis();
                break;
            case 2:
                name = "selection";

                //sorting array a w/ time using selection sort
                timerA = new Stopwatch();
                selectionSort(a);
                timeA = timerA.elapsedTimeMillis();

                //sorting array b w/ time using selection sort
                timerB = new Stopwatch();
                selectionSort(b);
                timeB = timerB.elapsedTimeMillis();

                //sorting array c w/ time using selection sort
                timerC = new Stopwatch();
                selectionSort(c);
                timeC = timerC.elapsedTimeMillis();

                //sorting array d w/ time using selection sort
                timerD = new Stopwatch();
                selectionSort(d);
                timeD = timerD.elapsedTimeMillis();
                break;
            case 3:
                name = "insertion";

                //sorting array a w/ time using insertion sort
                timerA = new Stopwatch();
                insertionSort(a);
                timeA = timerA.elapsedTimeMillis();

                //sorting array b w/ time using insertion sort
                timerB = new Stopwatch();
                insertionSort(b);
                timeB = timerB.elapsedTimeMillis();

                //sorting array c w/ time using insertion sort
                timerC = new Stopwatch();
                insertionSort(c);
                timeC = timerC.elapsedTimeMillis();

                //sorting array d w/ time using insertion sort
                timerD = new Stopwatch();
                insertionSort(d);
                timeD = timerD.elapsedTimeMillis();
                break;
            case 4:
                name = "merge";
                //call merge sort


                //sorting array a w/ time using merge sort
                timerA = new Stopwatch();
               mergeSort(a);
                timeA = timerA.elapsedTimeMillis();

                //sorting array a w/ time using merge sort
                timerB = new Stopwatch();
                mergeSort(b);
                timeB = timerB.elapsedTimeMillis();

                //sorting array a w/ time using merge sort
                timerC = new Stopwatch();
                mergeSort(c);
                timeC = timerC.elapsedTimeMillis();

                //sorting array a w/ time using merge sort
                timerD = new Stopwatch();
                mergeSort(d);
                timeD = timerD.elapsedTimeMillis();
                break;
            case 5:
                name = "quick";

                //sorting array a w/ time using quick sort
                timerA = new Stopwatch();
                quickSort(a);
                timeA = timerA.elapsedTimeMillis();

                //sorting array a w/ time using quick sort
                timerB = new Stopwatch();
                quickSort(b);
                timeB = timerB.elapsedTimeMillis();

                //sorting array a w/ time using quick sort
                timerC = new Stopwatch();
                quickSort(c);
                timeC = timerC.elapsedTimeMillis();

                //sorting array a w/ time using quick sort
                timerD = new Stopwatch();
                quickSort(d);
                timeD = timerD.elapsedTimeMillis();
                break;
            default:
                name = "default";

                //sorting array a w/ time using the default
                timerA = new Stopwatch();
                defaultSort(a);
                timeA = timerA.elapsedTimeMillis();

                //sorting array b w/ time using the default
                timerB = new Stopwatch();
                defaultSort(b);
                timeB = timerB.elapsedTimeMillis();

                //sorting array c w/ time using the default
                timerC = new Stopwatch();
                defaultSort(c);
                timeC = timerC.elapsedTimeMillis();

                //sorting array d w/ time using the default
                timerD = new Stopwatch();
                defaultSort(d);
                timeD = timerD.elapsedTimeMillis();
                break;
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        //TODO: Replace with your own netid
        String netID = "32362206";
        //TODO: Replace with the algorithm used
        String algorithmUsed = name + " sort";
        //TODO: Replace with the array used
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "a", timeA, timeStamp, netID, args[0]);
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "b", timeB, timeStamp, netID, args[0]);
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "c", timeC, timeStamp, netID, args[0]);
        StdOut.printf("%s %s %8.1f   %s  %s  %s\n", algorithmUsed, "d", timeD, timeStamp, netID, args[0]);
        // Write the resultant array to a file (Each time you run a program 4 output files should be generated. (one for each a,b,c, and d)
        saveToFile(a, "a.txt");
        saveToFile(b, "b.txt");
        saveToFile(c, "c.txt");
        saveToFile(d, "d.txt");
    }

    //Default sort
    public static int[] defaultSort(int[] array){
        Arrays.sort(array);
        return array;
    }


    //Bubble sort
    public static int[] bubbleSort(int[] array){
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
    public static int[] selectionSort(int[] array) {
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
    public static int[] insertionSort(int array[]) {
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
    //quick sort caller
    public static int[] quickSort(int[] array) {
        return quickSort(array, 0, array.length - 1);
    }

    //quick sort
    public static int[] quickSort(int[] array, int low, int high) {
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
            quickSort(array, low, j);
        }
        if (i < high) {
            quickSort(array, i, high);
        }
        return array;
    }

    //merge sort caller method
    public static int[] mergeSort(int[] array) {
        Sorting ob = new Sorting();
        ob.sort(array, 0, array.length - 1);
        return array;
    }

    //merge sort
    private static void mergeSort(int[] array, int l, int m, int r) {
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
            mergeSort(array, l, m, r);
            mergeSort(array, l, m, r);
        }
    }

    //method to save the 4 arrays to 4 different files
    public static void saveToFile(int[] array, String fileName) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i = 0; i < array.length; i++) {
            printWriter.println(array[i]);
        }
        printWriter.close();
    }

}






