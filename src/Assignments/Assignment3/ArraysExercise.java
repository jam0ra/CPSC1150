/*

 */

package Assignments.Assignment3;

import java.util.Scanner;

public class ArraysExercise {
    public static void main(String[] args) {
        getArray();
        printArray();
        /*
        findMax();
        System.out.println(findMax());
        findMin();
        System.out.println(findMin());
        findMaxIndex();
        System.out.println(findMaxIndex());
        findMinIndex();
        System.out.println(findMinIndex());
        isSortedAscend();
        isSortedAscend();
        isSortedDescend();
        isSortedDescend();
        swapNeighbor();
        System.out.println(swapNeighbor());
        merge();
        getArray();
        merge(); */
        // call getArray and create an array named arr1
        // call printArray given arr1
        // call findMax given arr1
        // print the return value of findMax
        // call findMin given arr1
        // print the return value of findMin
        // call findMaxIndex given arr1
        // print the return value of findMaxIndex
        // call findMinIndex given arr1
        // print the return value of findMinIndex
        // call isSortedAscend given {2, 5, 7, 9} and print the result
        // call isSortedAscend given {2, 15, 7, 29} and print the result
        // call isSortedDescend given {2, 5, 7, 9} and print the result
        // call isSortedDescend given {25, 15, 7, 2} and print the result
        // call swapNeighbor given arr1
        // print the result of calling swapNeighbor given arr1
        // call merge given {2, 6, 9} and {-1, 5, 11, 12} and print the result
        // call getArray and create an array named arr2
        // call merge given arr1 and arr2

    }

    public static int[] getArray(){
        Scanner input = new Scanner(System.in);
        int length;

        System.out.println("How many integers would you like to enter?");
        length = input.nextInt();

        int[] arr1 = new int[length];

        for(int i = 0; i < length; i++){
            System.out.printf("Enter Integer %d: ",(i + 1));
            arr1[i] = input.nextInt();
        }

        return arr1;
    }

    public static int[] printArray(){
        int length = getArray().length;
        int[] arr1 = new int[length];
        int counter = 0;
        for (int i = 0; i < length; i++){
            System.out.print("\t");
            arr1[i] = getArray()[i];
            counter++;
            if (counter == 5)
                System.out.println();
            else
                System.out.print("");

        }return arr1;
    }

/*public static int[] findMax(){

    }

    public static int[] findMin(){

    }

    public static int[] findMaxIndex(){

    }

    public static int[] findMinIndex(){

    }

    public static int[] isSortedAscend(){

    }

    public static int[] isSortedDescend(){

    }

    public static int[] swapNeighbor(){

    }

    public static int[] merge(){

    }*/

}