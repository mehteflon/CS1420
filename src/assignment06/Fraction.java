package assignment06;

public class Fraction {
    private int numerator;
    private int denominator;
    public Fraction (int n, int d)
    {

        numerator = n;
        denominator = d;
    }

    public String toString()
    {
        return this.numerator + "/" + this.denominator;
    }

    public int getNumerator ()
    {
        return numerator;
    }

    public int getDenominator ()
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

        result = new Fraction(this.numerator / rightHandSide.numerator, this.denominator / rightHandSide.denominator);

        return result;
    }
}
