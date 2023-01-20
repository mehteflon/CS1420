/*
    Will Graham u0982574
    January 19th 2023
    This is the third of 4 files in this assigment. This one converts degrees fahrenheit into degrees in celsius.
 */

package assignment02;
import java.util.Scanner;

public class Temperature {
    public static void main(String[] args)
    {
        int fahrenheit;
        int celsius;


        Scanner input = new Scanner(System.in);
        System.out.print("Input degrees in farenheit that you want to convert to celsius: ");
        fahrenheit = input.nextInt();

        celsius = ((fahrenheit - 32)*5)/9;
        System.out.print(fahrenheit + " degrees in farenheit is " + celsius + " degrees in celsius.");
    }
}
