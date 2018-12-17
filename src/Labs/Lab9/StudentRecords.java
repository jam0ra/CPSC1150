package Labs.Lab9;

/*
Code completed on November 9, 2018
Author: John Jamora
Title: Lab 9 - StudentRecords.java
 */

import java.io.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class StudentRecords {
    public static void main(String[] args) {

        int menuOption; // initialize the menu options

        do {
            String menu = JOptionPane.showInputDialog(null,
                    "Please select one of the following 4 options:\n\n"
                            + "Press 1 to create a new course score file. \n"
                            + "Press 2 to search into an existing course score file. \n"
                            + "Press 3 to add more record to an existing course score file. \n"
                            + "Press 4 to quit the program.",
                    "StudentRecords.java", JOptionPane.INFORMATION_MESSAGE);
            menuOption = Integer.parseInt(menu);

            // call methods
            switch (menuOption) {
                case 1:
                    createFile();
                    break;
                case 2:
                    searchFile
                            ();
                    break;
                case 3:
                    addToFile();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null,"The program has been terminated.",
                            "Goodbye", JOptionPane.PLAIN_MESSAGE);
                    System.exit(0); // close program
                default:
                    JOptionPane.showMessageDialog(null, "Invalid input. Please choose one of "
                            + "the 4 menu options.", "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        while (menuOption != 4); // loop program until user quits the program

    }

    public static void createFile(){
        Boolean continueInput;
        do {
            String createFile = JOptionPane.showInputDialog(null,
                    "Please enter the new file name (with the extension):", "File Creator",
                    JOptionPane.INFORMATION_MESSAGE);
            File file = new File(createFile); // create new file
            if (!file.exists()) { // if file does not exist, then we can create a new one under this name
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "New file " + createFile + " created.");
                continueInput = false; // file created, so break
            } else {
                JOptionPane.showMessageDialog(null, "File already exists! " +
                                "Please choose a different name.",
                        "Error!",JOptionPane.ERROR_MESSAGE);
                continueInput = true; //loop
            }
        }
        while (continueInput); //continue the process until a valid input is given
    }

    public static void searchFile() {
        Boolean continueInput = true;
        do {
            String fileName = JOptionPane.showInputDialog(null, "Please enter the file name " +
                            "that you would like to search (with the extension):",
                    "File Search", JOptionPane.INFORMATION_MESSAGE);
            File file = new File(fileName); // initialize file object

            if (file.exists()) { // check if file exists
                try {
                    // read file
                    String name = JOptionPane.showInputDialog(null, "Enter full name: ",
                            "File Search", JOptionPane.INFORMATION_MESSAGE);
                    Scanner input = new Scanner(file);
                    while (input.hasNextLine()) {
                        String student = input.nextLine();
                        if (student.contains(name)){ // assume the name exists (check pdf)
                            JOptionPane.showMessageDialog(null, "The student record found "
                                    + "is: " + student,"File Search", JOptionPane.INFORMATION_MESSAGE);
                            continueInput = false;
                        }
                    }
                }
                catch (IOException e){ //exception for FileReader & BufferedReader
                    e.printStackTrace();
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "File does not exist! ",
                        "Error!", JOptionPane.ERROR_MESSAGE);
                continueInput = true; // re-prompt user for file name (in case of typo)
            }
        }
        while (continueInput == true); // repeat the program until it goes through
    }

    public static void addToFile() {
        Boolean continueInput, numberError;
        do {
            String fileName = JOptionPane.showInputDialog(null,
                    "Please enter the file name that you would like to"
                            + " search (with the extension):", "File Search", JOptionPane.INFORMATION_MESSAGE);
            File file = new File(fileName);
            if (file.exists()){
                try (FileWriter fw = new FileWriter(file, true); // appends new input, instead of overwriting
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter output = new PrintWriter(bw)) {
                    String name = JOptionPane.showInputDialog(null,
                            "Please enter full name: ", "Add Data To File",
                            JOptionPane.INFORMATION_MESSAGE);

                    do {
                        try {
                            String scoreInput = JOptionPane.showInputDialog(null,
                                    "Please enter the score: ", "Add Data To File",
                                    JOptionPane.INFORMATION_MESSAGE);
                            double score = Double.parseDouble(scoreInput);
                            NumberFormat nf = new DecimalFormat("##.##"); // only use decimals when needed
                            output.println(name + "\t" + (nf.format(score)));
                            numberError = false;
                        } catch (NumberFormatException nfe) {
                            JOptionPane.showMessageDialog(null, "Score must be a number. " +
                                    "Please try again.", "Error!", JOptionPane.ERROR_MESSAGE);
                            numberError = true;
                        }
                    }
                    while (numberError); // ask for score until a number is given
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(null, "Data added to file.",
                        "Add Data To File", JOptionPane.INFORMATION_MESSAGE);
                continueInput = false; //end program if successful
            }
            else{
                JOptionPane.showMessageDialog(null, "File does not exist!",
                        "Error!",JOptionPane.ERROR_MESSAGE);
                continueInput = true;
            }
        } while (continueInput);
    }
}

