package assignment06;

public class Fraction {

    // Below are instance variables to be used later in the class
    private long numerator;
    private long denominator;
    public Fraction (long n, long d)
    {
        numerator = n;
        denominator = d;

        long gcd = numerator;
        long remainder = denominator;

        while (remainder != 0) {
            long temp = remainder;
            remainder = gcd % remainder;
            gcd = temp;
        }
    }

    public Fraction (long n)
    {
        numerator = n;
        denominator = 1;
    }

    public String toString()
    {
        return this.numerator + "/" + this.denominator;
    }

    public long getNumerator ()
    {
        return numerator;
    }

    public long getDenominator ()
    {
        return denominator;
    }

    public Fraction multiply (Fraction rightHandSide)
    {
        // Work goes here, remember this is the left-hand size of the multiplication
        Fraction result;

        result = new Fraction(this.numerator * rightHandSide.numerator, this.denominator * rightHandSide.denominator);

        return result;
    }

    public Fraction divide (Fraction rightHandSide)
    {
        Fraction result;

        result = new Fraction(this.numerator / rightHandSide.numerator,this.denominator / rightHandSide.denominator);

        return result;
    }
}
