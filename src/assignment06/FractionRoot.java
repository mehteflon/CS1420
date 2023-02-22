package assignment06;

import java.util.Scanner;

public class FractionRoot {
    public static void main (String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a numerator for a fraction: ");
        int numerator = input.nextInt();
        System.out.println("Please input a denominator for a fraction: ");
        int denominator = input.nextInt();



        System.out.println(numerator + denominator);
    }
}
