package assignment06;

public class FractionTester {

    private int numerator;
    private int denominator;
    public static void main (String[] args)
    {
        System.out.println("Fraction tester: ");

        Fraction f = new Fraction (2, 3);
        Fraction g = new Fraction (1, 4);
        Fraction h = new Fraction (5, 1);

        System.out.println ("Fraction f contains: " + f);
        System.out.println ("Fraction g contains: " + g);
        System.out.println ("Fraction h contains: " + h);

        System.out.println("Testing numerator accessor method: " + f.getNumerator());
        System.out.println("Testing numerator accessor method: " + g.getNumerator());
        System.out.println("Testing denominator accessor method: " + f.getDenominator());
        System.out.println("Testing denominator accessor method: " + g.getDenominator());

        System.out.println("Testing multiply method. Right hand side: " + f + ". Left hand side: " + g + ". Result: " + (f.multiply(g)) + ".");
        System.out.println("Testing multiply method. Right hand side: " + g + ". Left hand side: " + h + ". Result: " + (g.multiply(h)) + ".");
        System.out.println("Testing divide method. Right hand side: " + f + ". Left hand side: " + g + ". Result: " + (f.divide(g)) + ".");
        System.out.println("Testing divide method. Right hand side: " + g + ". Left hand side: " + h + ". Result: " + (g.divide(h)) + ".");



        System.out.println("Fraction tester end.");
    }

}
