/*
Program name: Triangle.java
Purpose: To calculate the perimeter of a triangle using array and methods
Code completed on October 28th, 2018
*/

package Assignments.Assignment3;

import java.util.Scanner; // import scanner

public class Triangle {
    public static void main(String[] args) {
        int x1, x2, x3, y1, y2, y3;


        String repeat;
        do {
            System.out.println("This program calculates the perimeter of a Triangle."); // explain program

            getCoordinates(); // step 1: get the coordinates
            x1 = getCoordinates()[0];
            y1 = getCoordinates()[1];
            x2 = getCoordinates()[2];
            y2 = getCoordinates()[3];
            x3 = getCoordinates()[4];
            y3 = getCoordinates()[5];

            if (!verifyTriangle(x1, y1, x2, y2, x3, y3)) {
                // step 2: verify that the points don't make a line
                System.out.println("Error, please enter coordinates that do not form a line.");
            }
            else
                verifyTriangle(x1, y1, x2, y2, x3, y3);
            calculatePerimeter(x1, y1, x2, y2, x3, y3);

            double perimeter = calculatePerimeter(x1, y1, x2, y2, x3, y3);

            System.out.printf("The perimeter of a Triangle with Point 1 (%d, %d), " +
                    "Point 2 (%d, %d) and Point 3 (%d, %d) is " + perimeter, x1, y1, x2, y2, x3, y3);

            Scanner input = new Scanner(System.in);
            System.out.println("Would you like to repeat the program?");
            repeat = input.nextLine();
            input.close();

        }
        while(repeat.equalsIgnoreCase("yes"));

        System.out.println("End of the program.");
    }

    public static int[] getCoordinates(){
        Scanner input = new Scanner(System.in); // create scanner
        int coordinates[] = new int[6]; // define array
        String[]axis = {"x-coordinate", "y-coordinate", "x-coordinate", "y-coordinate", "x-coordinate", "y-coordinate"};
        int[] point = {1, 1, 2, 2, 3, 3};

        // 6-entries
        for (int i = 0; i < 6; i++) {
            do {
                System.out.println("Please enter the " + axis[i] + " of Point " + point[i] + ":");
                coordinates[i] = input.nextInt();
                if (coordinates[i] < 0 || coordinates[i] > 40) // if input is wrong, state why
                    System.out.println("Error, invalid entry. Please enter an integer between 1 and 40.");
            }
            while (coordinates[i] < 0 || coordinates[i] > 40); // repeats if the input is invalid
        }

        return coordinates;
    }

    public static boolean verifyTriangle(int x1, int y1, int x2, int y2, int x3, int y3){
        x1 = getCoordinates()[0];
        y1 = getCoordinates()[1];
        x2 = getCoordinates()[2];
        y2 = getCoordinates()[3];
        x3 = getCoordinates()[4];
        y3 = getCoordinates()[5];
        boolean line;

        if (y1 == y2 && y2 == y3)
            line = true;
        else if (x1 == x2 && x2 == x3)
            line = true;
        else if (x1 % y1 == 0 && x2 % y2 == 0 && x3 % y3 == 0)
            line = true;
        else if (y1 % x1 == 0 && y2 % x2 == 0 && y3 % x3 == 0)
            line = true;
        else
            line = false;

        return line;
    }

    public static double calculatePerimeter(int x1, int y1, int x2, int y2, int x3, int y3){
        x1 = getCoordinates()[0];
        y1 = getCoordinates()[1];
        x2 = getCoordinates()[2];
        y2 = getCoordinates()[3];
        x3 = getCoordinates()[4];
        y3 = getCoordinates()[5];

        double distance1, distance2, distance3, perimeter;
        distance1 = Math.sqrt(Math.pow(x2-x1,2) + (Math.pow(y2-y1,2)));
        distance2 = Math.sqrt(Math.pow(x3-x2,2) + (Math.pow(y3-y2,2)));
        distance3 = Math.sqrt(Math.pow(x1-x3,2) + (Math.pow(y1-y3,2)));
        perimeter = distance1 + distance2 + distance3;
        return perimeter;
    }
}
