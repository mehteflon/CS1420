/*
Will Graham u0982574
This program puts the hailstone sequence into practice.
 */

package assignment03;
import java.util.Scanner;

public class Hailstone {
    public static void main(String[] args) {
        int n = 0; // Declares variable that will store user inputted number
        int positive = 0; // Variable will store either 1 or 0 to indicate to the program whether the user input is positive or negative. Needs to be positive.
        Scanner input = new Scanner(System.in); // Creates scanner for user input

        while (positive == 0) // This will keep looping until the user inputs a positive integer
        {
            System.out.print("Enter a number: ");
            n = input.nextInt();
            if (n > 0)
                positive++; // If they enter a positive number, change positive variable to 1 so the loop terminates.
        }

        System.out.println(n);

        int steps = 0; // Tracks how many steps required to complete sequence

        while (n != 1) // Checks to see if number is 1, if not, need to do more work to get hailstone sequence.
        {
            int even = 0; // Variable stores whether its even/odd
            even = n % 2; // Uses modulus to determine even/odd

            if (even == 0) // If number is even
            {
                n = n / 2;
                System.out.println(n);
                steps++;
            } else if (even != 0) { // If  number is odd
                n = (n * 3) + 1;
                System.out.println(n);
                steps++;
            }
        }

        System.out.println("It took " + steps + " steps to complete the hailstone sequence.");
    }
}
