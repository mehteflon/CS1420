package assignment03;
import java.util.Scanner;

public class HailstoneSearch {
    public static void main(String[] args) {
        int steps = 0; // Declares variable that will store user inputted number of steps
        int positive = 0; // Variable will store either 1 or 0 to indicate to the program whether the user input is positive or negative. Needs to be positive.
        Scanner input = new Scanner(System.in); // Creates scanner for user input

        while (positive == 0) // This will keep looping until the user inputs a positive integer
        {
            System.out.print("Enter the number of steps: ");
            steps = input.nextInt();
            if (steps >= 0)
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

            if (currentSteps == steps) {
                System.out.println("The starting number n is: " + n);
                return;
            }
        }
        System.out.println("There is no number in the range [2,2000] that produces that number of steps.");
    }
}