package review;

import java.awt.*;

public class Review {

    public static void main (String[] args) {
        //Assume you have an existing array of integers named temperatures. The task is to find out how many
        //locations in the array have a positive number followed by a negative number: ..., 12, -4, ... Write a few
        //lines of code that counts how many times in temperatures a positive number is followed by a negative
        //number. Put the result in a variable named coldFrontCount. (Again declare variables you use.)

        String[] temperatures = {"test", "test", null, "test", "test", null, "test", "test", "test", null};

        int nullCount = 0;

        for (int i = 0; i < temperatures.length; i++) {
            if (temperatures[i] == null) {
                nullCount++;
            }
        }

        System.out.println(nullCount);
    }
}
