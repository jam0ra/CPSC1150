/*
Exercise 2 [20 marks]: Write two overloaded methods that returns the average of an array with the following headers:
public static int average (int[] array)
public static double average(double[] array)
Write a test program (Arrays.java) that prompts the user to enter 5 double values, invoke this method and displays the average value.

Program name: Arrays.java
Code completed on October 24th, 2018
Purpose: to demonstrate and apply knowledge of arrays
 */

package Labs.Lab7;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] values; // declare double variable, arrays use square brackets
        values = new double[5];
        System.out.println("Please enter 5 double values: ");

        for (int i = 0; i < 5; i++) // ask for input until 5 values have been entered
            values[i] = input.nextDouble();

        System.out.printf("The average of the 5 values is: %.2f", average(values));
        input.close(); // close scanner
    }

    public static int average(int[] array) {
        int sum = 0;
        for (int values : array)
            sum += values; //add values together
        return sum / array.length;
    }

    public static double average(double[] array) {
        double sum = 0.0;
        for (double values : array)
            sum += values; //add the values together
        return sum / array.length; //find average
    }
}
