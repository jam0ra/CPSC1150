package Labs.Lab7;

/* Code completed on October 24th, 2018
Program name: WarGame.java
Purpose: To demonstrate methods and top-down design using the card game "War"
Do NOT touch Main method, printRoundInfo, or printRoundResult
*/

import java.util.Scanner;

public class WarGame{
    public static void main(String[] args){
        final int ROUND = 10;
        int user, comp, score = 0;
        for (int r=1; r < ROUND +1; ++r) {
            comp = genInput();
            user = getInput();
            printRoundInfo(r, user, comp);
            score = printRoundResult(score, user, comp);
        }
        System.out.println("End of Game!");
    }

    public static int getInput() {
        // TODO: prompt user to enter a number between 1 and 52,
        Scanner input = new Scanner(System.in); //import scanner
        int userInput; // define input as an int type variable
        do {
            System.out.println("Enter a number between 1 and 52: ");
            userInput = input.nextInt();
            //		 then validate and return it
            if (userInput < 1 || userInput > 53)
                System.out.println("Error, invalid entry. Please enter an integer between 1 and 52.");
        }
        while(userInput < 1 || userInput > 52); // while the entry is invalid, loop until valid
        return userInput; // return the userInput which will be card
    }


    public static int genInput(){
        //TODO : generate and return an integer number between 1 and 52
        int compInput;
        compInput = (int)(Math.random()*53);
        return compInput;
        // no need to validate because the range is 1-52
    }


    public static String getSuit(int card){
        String suit; //suit must be a string
        if (card >= 1 && card <= 13)
            suit = "Spades";
        else if (card >= 14 && card <= 26)
            suit = "Hearts";
        else if (card >= 27 && card <= 39)
            suit = "Clubs";
        else //range will always be <53 so no need for a parameter
            suit = "Diamonds";
        return suit;

    }

    public static String getRank(int card){
        //TODO : generate and return a rank
        String rank = "";
        if (card == 1 || card == 14 || card == 27 || card == 40)
            rank = "Ace";
        else if (card == 11 || card == 24 || card == 37 || card == 50)
            rank = "Jack";
        else if (card == 12 || card == 25 || card == 38 || card == 51)
            rank = "Queen";
        else if (card == 13 || card == 26 || card == 39 || card == 52)
            rank = "King";
        else if (card > 13)
            rank += card%13; // dividing by 13 will generate the number, as each set is up to 13
        else // if not Ace, Jack, Queen, or King, then Simply return the number
            rank += card;
        return rank;
    }

    public static void printRoundInfo(int r, int user, int comp){

        System.out.print("R" + r + ": ");
        System.out.print("Computer card is " + getRank(comp) + " of " + getSuit(comp));
        System.out.println("; User card is " + getRank(user) + " of " + getSuit(user));
    }

    public static int printRoundResult(int score, int user, int comp){
        int winner = findWinner(user, comp);
        switch (winner){
            case 0 : score *=2;
                System.out.println("It’s tie – user score is " + score);
                break;
            case 1 : score +=1;
                System.out.println("User wins – user score is " + score);
                break;
            default :
                System.out.println("Computer wins – user score is " + score);
                break;
        }
        return score;
    }

    public static int findWinner(int user, int comp){
        //TODO: find the winner and return 0, 1 or -1 if it is tie,
        int winner;

        user %= 13; //find the number from any set
        comp %= 13;
        if (user == 0) // if %13 == 0, then value is king which is 13
            user = 13;
        if (comp == 0)
            comp = 13;
        if (user  > comp)
            winner = 1;
        else if (user %13 < comp%13)
            winner = -1;
        else if (user %13 == comp%13)
            winner = 0;
        else if (user %13 == 0)
            winner = 1;
        else
            winner = -1;
        //user wins or computer wins
        return winner;
    }

    // add more methods if needed.
}
