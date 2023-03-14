/*
Will Graham u0982574

This is the class that defines the fraction object as well as the methods that go with it.
*/

package assignment06;

public class Fraction {

    // Below are instance variables to be used later in the class
    private long numerator;
    private long denominator;
    public Fraction (long n, long d)
    {
        numerator = n; // Instance variable
        denominator = d; // Instance variable

        long gcd = numerator;
        long remainder = denominator;

        // Below is Euclids algorithm which finds the greatest common divisor (gcd)
        while (remainder != 0) {
            long temp = remainder;
            remainder = gcd % remainder;
            gcd = temp;
        }

        numerator = numerator/gcd; // reduces numerator
        denominator = denominator/gcd; // reduces denominator

        if (denominator < 0) // Checks to see if denominator is negative and if so standardizes it so numerator is negative instead
        {
            numerator = -numerator;
            denominator = -denominator;
        }

    }

    public Fraction (long n) // Second constructor that takes a single long as a parameter
    {
        numerator = n;
        denominator = 1;
    }

    public String toString() // Converts fraction object to a string
    {
        return this.numerator + "/" + this.denominator;
    }

    /**
     * Retrieves and returns numerator for given fraction
     * No params
     * @return the numerator of said fraction
     */
    public long getNumerator ()
    {
        return numerator;
    }

    /**
     * Retrieves and returns denominator for given fraction
     * No params
     * @return the denominator of said fraction
     */
    public long getDenominator ()
    {
        return denominator;
    }


    /**
     * Multiplies fraction by given fraction
     * Returns a new fraction that represents result of multiplication
     *
     * @param rightHandSide the fraction to multiply original fraction by
     * @return the product
     *
     * The numerators are multiplied (product of which is the new numerator), and the denominators are multiplied (product of which is the new denominator)
     */
    public Fraction multiply (Fraction rightHandSide)
    {
        // Work goes here, remember this is the left-hand size of the multiplication
        Fraction result;

        result = new Fraction(this.numerator * rightHandSide.numerator, this.denominator * rightHandSide.denominator);

        return result;
    }

    /**
     * Divides fraction by given fraction
     * Returns a new fraction that represents the result of the division
     *
     * @param rightHandSide the divisor fraction
     * @return the quotient
     *
     * Essentially, the original fraction is cross multiplied by the reciprocal of the divisor fraction.
     */
    public Fraction divide (Fraction rightHandSide)
    {
        Fraction result;

        result = new Fraction(this.numerator * rightHandSide.denominator,this.denominator * rightHandSide.numerator);

        return result;
    }

    /**
     * Adds a fraction to the given fraction
     * Returns a new fraction that represents the result of the addition
     *
     * @param rightHandSide the fraction to add
     * @return the sum of this fraction and the input fraction
     *
     * Method finds common denominator between two fractions by multiplying their denominators by each other.
     * Then their numerators are multiplied by the opposite denominator and added to find the new numerator
     */
    public Fraction add(Fraction rightHandSide)
    {
        long newNumerator = this.numerator * rightHandSide.denominator + rightHandSide.numerator * this.denominator;
        long newDenominator = this.denominator * rightHandSide.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Subtracts a function from given function
     * Returns a new fraction that represents the result of the subtraction
     *
     * @param rightHandSide the fraction to subtract from the given function
     * @return the result of the subtraction
     *
     * Method finds common denominator between two fractions by multiplying their denominators by each other.
     * Then their numerators are multiplied by the opposite denominator and added to find the new numerator
     */
    public Fraction subtract(Fraction rightHandSide)
    {
        long newNumerator = this.numerator * rightHandSide.denominator - rightHandSide.numerator * this.denominator;
        long newDenominator = this.denominator * rightHandSide.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    /**
     * Converts a fraction to a double value
     * No params
     * @return the result of fraction to double conversion
     * Divides numerator by denominator to produce double value.
     */
    public double toDouble ()
    {
        return (double) numerator / denominator;
    }
}