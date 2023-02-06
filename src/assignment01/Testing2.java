package assignment01;

import java.util.Scanner;


import java.io.File;
public class Testing2 {
    public static void main (String[] args)
    {
        double largest = 0;

        for (int i = 0; i < 73; i++)
        {
            double random = Math.random();
            if (random > largest)
                largest = random;
        }

        System.out.println(largest);
    }
}
