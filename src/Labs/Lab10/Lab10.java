package Labs.Lab10;

/*
 * Sort array
 * Use every element in the array as the key to compare to and find out the average
 *
 * Author: John Jamora
 * Code completed on: November 21st, 2018
 * Lab 10: Time Complexity and Algorithms
 */

import java.util.Arrays; // used for array sort

public class Lab10 {
    public static void main(String[] args) {
        System.out.printf("\n%10s%-25s\n", " ", "Average Number of Comparisons");
        System.out.printf("%-10s%12s%20s\n", "n", "Linear Search", "Binary Search");
        System.out.println("-------------------------------------------");
        for (int size = 10; size < 1000000; size *= 10) {
            int[] list = genArray(size); //generates an array of random integers with the given size.
            Arrays.sort(list);
            // use every element as the key
            for (int i = 0; i < list.length; i++){
                linearSearch(list, list[i]);
                binarySearch(list, list[i]);
            }
            double avgLnS = averageSearch(list.length, linearComparisons); // calculate average number of comparisons
            double avgBS = averageSearch(list.length, binaryComparisons);
            System.out.printf("%-10d%-20.2f%-20.2f\n", size, avgLnS, avgBS);
        }
    }


    /*
    generates a random array given size, domain is also the array size
     */
    public static int[] genArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++){
            array[i] = (int)(Math.random()*size); // make the domain size
        }
        return array;
    }

    public static int linearComparisons = 0; // public variable, allows reference in main (remember scope of variables)

    /*
    linear search, however we are interested in the number of comparisons so return value is useless
     */
    public static int linearSearch(int []array, int key){
        int arraySize = array.length;
        for (int i = 0; i < arraySize; i++) {
            // return the index of the element if the element is found
            if (array[i] == key) {
                linearComparisons++;
                return i;
            }
            else{
                linearComparisons++;
            }
        }
        // return -1 if the element is not found
        return -1;
    }


    /*
    Calculates average number of comparisons, can be used for linear and binary search
     */
    public static double averageSearch(int size, int comparisons){
        return (double)comparisons/(double)size; // cast to double
    }

    public static int binaryComparisons = 0; // public variable, allows reference in main (remember scope of variables)

    /*
    binary search, however we are interested in the number of comparisons so return value is useless
     */
    public static int binarySearch(int []array, int key){
        int low = 0;
        int high = array.length - 1;

        while(high >= low) {
            int mid = (low + high) / 2;
            if (key < array[mid]) {
                high = mid - 1;
                binaryComparisons++;
            } else if (key == array[mid]) {
                binaryComparisons++;
                return mid;
            } else {
                binaryComparisons++;
                low = mid + 1;
            }
        }
        // else return -1
        return -low - 1;
    }

    /*
    an alternate version of binary search using recursion instead of an iterative approach
     */
    @SuppressWarnings("Duplicates") // for intelliJ IDEA
    public static int recursiveBS(int[] array, int low, int high, int key){
        if (high >= 1){
            int mid = 1 + (high - 1) / 2;

            if (low == high || low == mid || mid == high){
                return -1; // not found
            }

            // if the mid is key, no need to continue
            if (array[mid] == key){
                return mid;
            }

            // use left (lesser) half
            if (array[mid] > key){
                return recursiveBS(array, 1, mid - 1, key);
            }

            // use right (greater) half
            else{
                return recursiveBS(array, mid+1, high, key);
            }
        }
        return -1; // if not found, return -1
    }

    public static int recursiveBSComparisons = 0; // public variable, allows countRecursive to reference
    /*
    counts number of comparisons
     */
    @SuppressWarnings("Duplicates") // for intelliJ IDEA
    public static int countRecursiveBS(int[] array, int low, int high, int key){
        if (high >= 1){
            int mid = 1 + (high - 1) / 2;

            if (low == high || low == mid || mid == high){
                recursiveBSComparisons++;
                return -1; // not found
            }

            // if the mid is key, no need to continue
            if (array[mid] == key){
                recursiveBSComparisons++;
                return mid;
            }

            // use left (lesser) half
            if (array[mid] > key){
                recursiveBSComparisons++;
                return countRecursiveBS(array, 1, mid - 1, key);
            }

            // use right (greater) half
            else{
                recursiveBSComparisons++;
                return countRecursiveBS(array, mid+1, high, key);
            }
        }
        return recursiveBSComparisons; // returns number of comparisons
    }
}

