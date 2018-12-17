package Labs.Lab8;

import javax.swing.*;

public class Matrix {
    public static void main(String[] args) {
        int menuOption;
        do {
            String menu = JOptionPane.showInputDialog(null, "M is a matrix with random positive " +
                    "double values less than 100. \nChoose one of the following options to resume the program:" +
                    "\n \n1 : Create M \n2 : Display M \n3 : Check whether M is symmetric \n4 : Multiply M with a coefficient" +
                    "\n5 : Square M \n6 : Quit the program");
            menuOption = Integer.parseInt(menu);
            switch (menuOption) {
                case 1: // Create M
                    genMatrix();
                    break;
                case 2: // Display M
                    printMatrix();
                    break;
                case 3: // Check whether M is Symmetric
                    isSymmetric();
                    break;
                case 4: // Multiply M with a coefficient
                    Multiply();
                    break;
                case 5: // Square M
                    Square();
                    break;
                case 6: // Quit the program
                    System.out.println("Program has been terminated. Thank you.");
                    System.exit(0);
                    break;
                default: // If else, then invalid entry
                    JOptionPane.showMessageDialog(null, "Invalid input. Please choose one of " +
                            "the 6 menu options.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        } while (menuOption != 6);
    }


    public static double[][] genMatrix(){
        String rows = JOptionPane.showInputDialog(null,"Enter the number of rows: ");
        String columns = JOptionPane.showInputDialog(null,"Enter the number of rows: ");
        int row = Integer.parseInt(rows);
        int column = Integer.parseInt(columns);
        JFrame f = new JFrame();
        double[][] matrix = new double[row][column];
        double number = 1;
        for(int i = 0; i < row; i++)
            for(int j = 0; j < column; j++)
                matrix[i][j] = 2*(i + j);

        for (int i = 0; i < row; i ++)
            for (int j = 0; j < column; j++)

                matrix[i][j] = number * Math.random()*100;

        JOptionPane.showMessageDialog(null, "The matrix generated is: \n" + matrix,
                "Generate M", JOptionPane.INFORMATION_MESSAGE);
        return matrix;
    }

    public static double[][] printMatrix(){
        double[][] matrix;
        String rows = JOptionPane.showInputDialog(null,"Enter the number of rows: ");
        String columns = JOptionPane.showInputDialog(null,"Enter the number of rows: ");
        int row = Integer.parseInt(rows);
        int column = Integer.parseInt(columns);
        JFrame f = new JFrame();
        matrix = new double[row][column];
        double number = 1;
        for(int i = 0; i < row; i++)
            for(int j = 0; j < column; j++)
                matrix[i][j] = 2*(i + j);

        for (int i = 0; i < row; i ++)
            for (int j = 0; j < column; j++)

                matrix[i][j] = number * Math.random()*100;

        JOptionPane.showMessageDialog(null, "The matrix generated is: \n" + matrix,
                "Generate M", JOptionPane.INFORMATION_MESSAGE);
        return matrix;
    }

    public static void isSymmetric(){
    }

    public static void Multiply(){

    }

    public static void Square(){

    }
}

