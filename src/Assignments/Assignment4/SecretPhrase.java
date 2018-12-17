/*Code completed on November 18, 2018
        Author: John Jamora
        Title: Lab 9 - SecretPhrase.java
*/

package Assignments.Assignment4;

import javax.swing.JOptionPane;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class SecretPhrase {
    public static void main(String[] args) {
        String phrase;
        StringBuffer maskedPhrase;
        boolean gameWon;
        String guess;
        char letter;
        int tries = 0;

        phrase = phrase(); // store phrase locally
        gameWon = false;

        // make maskedPhrase
        maskedPhrase = maskPhrase(phrase);

        while (! gameWon) {
            guess = JOptionPane.showInputDialog(null, maskedPhrase +
                            "\nEnter a letter " + "to guess: ", "SecretPhrase Phrase Game",
                    JOptionPane.INFORMATION_MESSAGE);
            tries++; // count number of guesses
            // process the guess

            letter = guess.charAt(0);
            if (phrase.indexOf(Character.toLowerCase(letter)) < 0
                    && phrase.indexOf(Character.toUpperCase(letter)) < 0){  // not there
                JOptionPane.showMessageDialog(null, "Sorry, " + guess + " is not "
                                + "in the phrase.", "SecretPhrase Phrase Game",
                        JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                // letter is in the phrase
                if (phrase.indexOf(letter) >= 0) {
                    //	replace * with guessed letter
                    matchLetter(phrase, maskedPhrase, letter);
                }
                if (phrase.indexOf(Character.toUpperCase(letter)) >= 0){
                    matchLetter(phrase, maskedPhrase, Character.toUpperCase(letter));
                }
                if (phrase.indexOf(Character.toLowerCase(letter)) >= 0){
                    matchLetter(phrase, maskedPhrase, Character.toLowerCase(letter));
                }
            }

            if (phrase.equals(maskedPhrase.toString())) {
                double score = (double)phrase.length()/tries;

                JOptionPane.showMessageDialog(null, "Congratulations! You have " +
                                "won. The phrase was: " + phrase + "\nYour score is " +
                                Math.round(score * 100.0)/100.0, // round to 2 decimal places
                        "SecretPhrase Phrase Game", JOptionPane.INFORMATION_MESSAGE);
                gameWon = true;
            }

        } // process whole guess

    } // end of main

    public static void matchLetter(String phrase, StringBuffer maskedPhrase, char letter){
        for (int index = 0; index < phrase.length(); index++)
            if (phrase.charAt(index) == letter)
                maskedPhrase.setCharAt(index, letter);
    }

    public static StringBuffer maskPhrase(String phrase){
        StringBuffer maskedPhrase = new StringBuffer(phrase.length());
        for (int i = 0; i < phrase.length(); i++) {
            if (phrase.charAt(i) != ' ') {
                maskedPhrase.append('*');
            }
            else{
                maskedPhrase.append(' ');
            }
        }
        return maskedPhrase;
    }

    public static String phrase(){

        String[] arr= null;
        List<String> phrases = new ArrayList<String>();

        try
        {
            FileInputStream fis = new FileInputStream("Phrases.txt");
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(dis));
            String line;

            while ((line = buffer.readLine()) != null)
            {
                line = line.trim();
                if ((line.length()!=0))
                {
                    phrases.add(line);
                }
            }

            arr = (String[])phrases.toArray(new String[phrases.size()]);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        int random = (int)(Math.random()*phrases.size());
        return arr[random];
    }

} // end
