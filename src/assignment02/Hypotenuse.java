/*
    Will Graham u0982574
    January 19th 2023
    This is the second of 4 files in this assigment. This one calculates the hypotenuse of a right triangle given the length of its two sides.
 */

package assignment02;

import java.util.Scanner; // Imports scanner class

public class Hypotenuse {
    public static void main(String[] args)
    {
        double side1; // Declares variable that will store length of side 1
        double side2; // Declares variable that will store length of side 2
        double hypotenuse; // Declares variable that will store the hypotenuse once calculated

        Scanner input = new Scanner(System.in);
        System.out.print("Input the length of side 1: "); // Prompts user to input length of side 1
        side1 = input.nextDouble();
        System.out.print("Input the length of side 2: "); // Prompts user to input length of side 2
        side2 = input.nextDouble();

        hypotenuse = Math.sqrt((side1*side1) + (side2*side2)); // Calculates the hypotenuse
        System.out.print("The hypotenuse of this triangle is: " + hypotenuse); // Print's result of calculation

    }
}
