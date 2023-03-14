/*
Will Graham u0982574

This is the FractionTester class that tests the fraction constructor and the fraction class methods.
*/


package assignment06;

public class FractionTester {

    private int numerator;
    private int denominator;
    public static void main (String[] args)
    {
        int errors = 0;
        System.out.println("Fraction tester: ");

        // Tests constructor when two arguments passed
        Fraction test1 = new Fraction (3, 5);
        System.out.println("Constructor with two arguments passed: " + test1);
        if ((test1.getNumerator() == 3 && test1.getDenominator() == 5) == false)
        {
            System.out.println("Error: constructor didn't set fraction up properly when passed two arguments.");
            errors++;

        }

        // Tests constructor when single argument passed
        Fraction test2 = new Fraction (2);
        System.out.println("Constructor with a single argument: " + test2);
        if (test2.getNumerator() != 2 || test2.getDenominator() != 1)
        {
            System.out.println("Error: constructor didn't set numerator and denominator correctly when passed a single argument.");
            errors++;
        }

        // Tests multiplication
        Fraction test3 = new Fraction(2, 3);
        System.out.println("Testing multiplication method with 3/5 * 2/3: " + test3.multiply(test1));
        if (((test3.multiply(test1)).toString()).equals("2/5") == false)
        {
            System.out.println("Error: multiplication method not working properly.");
            errors++;
        }

        // Tests division
        System.out.println("Testing division method with 3/5 divided by 2/3: " + test1.divide(test3));
        if (((test1.divide(test3).toString()).equals("9/10") == false))
        {
            System.out.println("Error: division method not working properly.");
            errors++;
        }

        // Tests toString
        System.out.println("Testing toString method on 2/3: " + test3.toString());
        if ((test3.toString()).equals("2/3") == false)
        {
            System.out.println("Error: toString method not converting fraction to string properly.");
            errors++;
        }

        // Tests getNumerator method
        System.out.println("Testing getNumerator method for 2/3: " + test3.getNumerator());
        if (test3.getNumerator() != 2)
        {
            System.out.println("Error: getNumerator method not working properly.");
            errors++;
        }

        // Tests getDenominator method
        System.out.println("Testing getDenominator method for 2/3: " + test3.getDenominator());
        if (test3.getDenominator() != 3)
        {
            System.out.println("Error: getDenominator method not working properly.");
            errors++;
        }

        // Tests reduction of fractions
        Fraction test4 = new Fraction(10,20);
        System.out.println("Testing to see if the fraction 10/20 is reduced properly: " + test4);
        if ((test4.toString()).equals("1/2") == false)
        {
            System.out.println("Error: fraction not being reduced properly.");
            errors++;
        }

        // Tests toDouble method
        System.out.println("Testing toDouble method: " + test4.toDouble());
        if (test4.toDouble() != 0.5)
        {
            System.out.println("Error: toDouble method not converting fraction to double correctly.");
            errors++;
        }

        // Tests negative denominator
        Fraction test5 = new Fraction(3,-7);
        System.out.println("Testing negative denominator handling: " + test5);
        if (test5.getNumerator() != -3)
        {
            System.out.println("Constructor not handling negative denominator properly.");
            errors++;
        }

        // Tests


        if (errors == 0)
        {
            System.out.println("All tests completed, no errors.");
        } else if (errors != 0)
        {
            System.out.println("All tests completed, errors found.");
            System.out.println("# of errors: " + errors);
        }

        System.out.println("Fraction tester end.");
    }

}
