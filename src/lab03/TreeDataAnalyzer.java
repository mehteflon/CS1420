/*
Will Graham u0982574
Lab 03 -- (TreeDataAnalyzer.java
*/

package lab03;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TreeDataAnalyzer {
    public static void main(String[] args) throws IOException
    {
        File filename = new File("src/lab03/forest.txt"); // File object represents path to the forest.txt file
        Scanner file = new Scanner(filename); // Opens file for reading (scanning)

        // Work goes under here
        String treeName;
        int treeCount;

        while (file.hasNext())
        {
            treeName = file.next(); // Uses the scanner to scan the next word from the file
            treeCount = file.nextInt(); // Uses the scanner to scan next int from file
            System.out.println("Tree: " + treeName + " has a count of " + treeCount + ".");
        }

        file.close();

        // Reopen the file.  (Build a new Scanner, store it in our file
        // variable.  The new Scanner scans from the beginning of the file.)

        file = new Scanner(filename);

        // Create a few variables for keeping track of the 'best' tree
        // found so far.

        String bestTreeName = null;
        int bestTreeCount = 0;

        // Loop, read in values, attempt to find the tree with the
        // highest count.

        int loopCount = 0;
        while (file.hasNext())
        {
            // Advance the counter.

            loopCount++;

            // Read in the data

            treeName = file.next(); // Use the scanner, scan the 'next' word from the file.
            treeCount = file.nextInt(); // Use the scanner, scan the 'next' int from the file.

            // If it's the first tree, or if the current tree count
            // is higher than the best one found so far, keep it.

            if (loopCount == 1 || treeCount > bestTreeCount) // The error was that this if statement was && instead of ||
            {
                // We've just read in the best tree so far.  Keep a copy
                // of it's data.

                bestTreeName = treeName;
                bestTreeCount = treeCount;
            }

            // Loop end.
        }

        // Print out the tree with the highest count.

        System.out.println("'Best' tree: " + bestTreeName + " has a count of " + bestTreeCount + ".");

        // Close the file.

        file.close();
    }
}