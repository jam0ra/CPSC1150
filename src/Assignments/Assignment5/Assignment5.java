package Assignments.Assignment5;

import java.util.Scanner;

public class Assignment5{
    public static void main(String[] args)  {
        // generate a random array of the size of 20
        int [] list1 = genArray(20);
        printArray("The array before partition: ", list1);
        int pivot = partition(list1);
        printArray("The array After partition: ", list1);

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        System.out.println(reverseDisplay(input.next()));

        int[] list2 = {3, 4, 5, 5, 5, 5, 4, 5};
        //int[] list2 = {3, 4, 5, 5, 6, 5, 5, 4, 5};

        if (isConsecutiveFour(list2))
            System.out.println("The list has consecutive fours");
        else
            System.out.println("The list has no consecutive fours");

    }
    //develop more methods to finish this assignment.

    /*
    Generates random array of given size, with domain of size
     */
    public static int[] genArray(int size){
        int[] list = new int[size];
        for (int i = 0; i < size; i++){
            list[i] = (int)(Math.random()*size + 1); // include size, > 0
        }
        return list;
    }

    /*
    Quick sorts a list using 1st element as the pivot
     */
    public static int partition(int[] list) {
        int pivotIndex = 0;
        int lowIndex = pivotIndex + 1;
        int highIndex = list.length - 1; // implement at most list.length comparisons
        int pivot = list[pivotIndex];

        while (highIndex > lowIndex) { // if highIndex < lowIndex then leave lowIndex alone
            while (lowIndex <= highIndex && list[lowIndex] <= pivot) {
                lowIndex++;
            }
            while (lowIndex <= highIndex && list[highIndex] > pivot) {
                highIndex--;
            }
            if (highIndex > lowIndex) {
                int temp = list[highIndex];
                list[highIndex] = list[lowIndex];
                list[lowIndex] = temp;
            }
        }

        while (highIndex >= lowIndex && list[highIndex] >= pivot){ // continue until the highIndex < pivotIndex
            highIndex--;
        }

        if (highIndex > pivotIndex) {
            int temp = list[highIndex];
            list[highIndex] = list[pivotIndex];
            list[pivotIndex] = temp;
            return highIndex;
        }
        else {
            return pivotIndex;
        }
    }

    /*
    Displays what the array is and shows all the elements of the array
     */
    public static void printArray(String message, int[] list){
        System.out.print(message); // print String once
        for (int x = 0; x < list.length; x++){
            System.out.print(list[x] + ", "); // add commas to separate each array element
        }
        System.out.println();
    }

    /*
    Recursive method that reverses a given string
     */
    public static String reverseDisplay(String value){
        if (value.isEmpty()){ // if its empty just return nothing
            return value;
        }
        else{
            return reverseDisplay(value.substring(1))+value.charAt(0); //takes substring from index 1 & appends 1st char
        }
    }

    /*
    Checks for 4 consecutive numbers in an int array
     */
    public static boolean isConsecutiveFour (int[] values){
        int counter = 1;
        for (int i = 0; i < values.length - 1; i++){
            if (values[i] == values [i + 1]){
                counter ++;
                if (counter == 4){
                    return counter == 4; // end loop if true
                }
            }
            else{
                counter = 1; // not consecutive, reset counter
            }
        }
        return (counter == 4); // else, it should return false
    }

}