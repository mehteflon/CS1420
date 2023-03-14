/*
Will Graham u0982574

This is the FractionRoot class that calculates the square root of fractions.
*/

package assignment06;

import java.util.Scanner;

public class FractionRoot {
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Please input a numerator for a fraction: ");
        int numerator = input.nextInt();

        System.out.print("Please input a denominator for a fraction: ");
        int denominator = input.nextInt();

        System.out.print("Please enter an approximation count: ");
        int approximation = input.nextInt();

        Fraction userFraction = new Fraction(numerator, denominator); // Creates fraction object with user inputs

        Fraction half = new Fraction(1,2);

        Fraction currentx = userFraction.multiply(half); // Sets x0 to equal S/2


        // Below implements iterative formula that we were given
        for (int i = 0; i < approximation; i++)
        {
            Fraction calculate = ((currentx.add(userFraction.divide(currentx))).multiply(half));
            Fraction nextx = new Fraction(calculate.getNumerator(), calculate.getDenominator());
            currentx = nextx;
        }

        System.out.println("The square root of " + userFraction + " is approximately " + currentx + ".");
    }

    }