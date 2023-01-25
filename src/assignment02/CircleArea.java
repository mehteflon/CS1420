/*
    Will Graham u0982574
    January 19th 2023
    This is the first of 4 files in this assigment. This one calculates the area of a circle.
 */

package assignment02;

import java.util.Scanner; // Imports scanner class

public class CircleArea {
    public static void main(String[] args)
    {
        double radius; // Declares variable that will store what the user inputs for the circle's radius
        double area; // Declares variable that stores result of computation (area of a circle)

        Scanner input = new Scanner(System.in);
        System.out.print("Input a radius: "); // Prompts the user for input
        radius = input.nextDouble(); // Set's radius variable equal to whatever number the user inputs

        area = Math.PI*(radius*radius); // Calculates area of given circle
        System.out.print("The area of a circle with radius " + radius + " is " + area + "."); // Prints result of calculation
    }
}
