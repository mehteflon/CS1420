/*
    Will Graham u0982574
    January 19th 2023
    This is the fourth of 4 files in this assigment. This one converts decimal numbers to 8 bit binary.
 */

package assignment02;
import java.util.Scanner; // Imports scanner class

public class Binary {
    public static void main(String[] args)
    {
        int n; // Declares variable "n" that will store users input

        Scanner input = new Scanner(System.in); // Creates scanner that will be used for user input
        System.out.print("Enter a number: ");
        n = input.nextInt(); // Sets n equal to the users input

        int first = 0;
        int second = 2;
        int third = 4;
        int fourth = 8;
        int fifth = 16;
        int sixth = 32;
        int seventh = 64;
        int eighth = 128;

        // Block of code below uses successive division to convert from decimal to binary

        eighth = n/eighth;
        seventh = (n-(eighth*128))/64;
        sixth = (n-((eighth*128)+(seventh*64)))/32;
        fifth = (n-((eighth*128)+(seventh*64)+(sixth*32)))/16;
        fourth = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)))/8;
        third = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)+(fourth*8)))/4;
        second = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)+(fourth*8)+(third*4)))/2;
        first = (n-((eighth*128)+(seventh*64)+(sixth*32)+(fifth*16)+(fourth*8)+(third*4)+(second*2)))/1;

        // Block of code below prints binary version of user input
        System.out.printf("The decimal number %d ", n);
        System.out.printf("is %d%d%d%d%d%d%d%d", eighth, seventh, sixth, fifth, fourth, third, second, first);
        System.out.print(" in binary.");
    }
}