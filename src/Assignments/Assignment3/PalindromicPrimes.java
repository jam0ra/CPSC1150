/*
Program name: PalindromicPrimes.java
Purpose: to apply array and methods knowledge through palindromic primes
Code completed on October 28th, 2018
 */

package Assignments.Assignment3;

public class PalindromicPrimes {
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; count < 100; i++) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.printf("%10d", i); // new line after 10 numbers
                count++;
                if (count % 10 == 0 && i != 0)
                    System.out.println(); // new line

            }
        }
    }


    public static boolean isPrime(long n) {
        if (n < 2)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true; // else, true
    }

    public static long reverse(long number) {
        long reverse = 0;
        while (number != 0) {
            reverse *= 10; // number is ignored
            reverse += number % 10;
            number /= 10;
        }
        return reverse; // return the number
    }

    public static boolean isPalindrome(long number) {
        return (number == reverse(number)); // return boolean statement
    }
}