/*
    Will Graham u0982574
    January 19th 2023
    This is the third of 4 files in this assigment. This one converts degrees fahrenheit into degrees in celsius.
 */

package assignment02;
import java.util.Scanner; // Imports scanner class

public class Temperature {
    public static void main(String[] args)
    {
        int fahrenheit; // Declares variable that will hold user input (temperature in fahrenheit)
        int celsius; // Declares variable that will store result of conversion calculation


        Scanner input = new Scanner(System.in); // Creates scanner object
        System.out.print("Input degrees in farenheit that you want to convert to celsius: "); // Prompts user for input of temperature that they want to convert
        fahrenheit = input.nextInt(); // Set's variable that will store fahrenheit temp equal to user input

        celsius = ((fahrenheit - 32)*5)/9; // Converts fahrenheit temp to celsius
        System.out.print(fahrenheit + " degrees in farenheit is " + celsius + " degrees in celsius."); // Prints celsius temperature
    }
}
