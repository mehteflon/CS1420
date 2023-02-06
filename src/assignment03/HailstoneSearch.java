/*
Will Graham u0982574
This is the hailstone.java program but adjusted to solve for n given a length of steps X.
*/

package assignment03;
import java.util.Scanner;

public class HailstoneSearch {
    public static void main(String[] args) {
        int X = 0; // Declares variable that will store user inputted number of steps
        int positive = 0; // Variable will store either 1 or 0 to indicate to the program whether the user input is positive or negative. Needs to be positive.
        Scanner input = new Scanner(System.in); // Creates scanner for user input

        while (positive == 0) // This will keep looping until the user inputs a positive integer
        {
            System.out.print("Enter the number of steps: ");
            X = input.nextInt();
            if (X >= 0)
                positive++; // If they enter a positive number, change positive variable to 1 so the loop terminates.
        }

        for (int n = 2; n <= 2000; n++) {
            int currentSteps = 0; // Tracks current number of steps
            int original = n; // Store the original value of n
            while (original != 1) {
                if (original % 2 == 0) { // If number is even
                    original = original / 2;
                    currentSteps++;
                } else if (original % 2 != 0) { // If number is odd
                    original = (original * 3) + 1;
                    currentSteps++;
                }
            }

            if (currentSteps == X) {
                System.out.println("The Hailstone sequence starting at " + n + " takes " + X + " steps to converge to 1.");
                return;
            }
        }
    }
}