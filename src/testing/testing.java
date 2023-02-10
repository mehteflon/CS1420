package testing;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;


public class testing {
    public static void main (String[] args)
    {
        String secretWord;
        secretWord = pickRandomWord("/Users/willgraham/IdeaProjects/CS 1420 - Spring 2023/src/testing/five.txt");

    }

    public static int countWords (String filename)
    {
        int wordCount = 0;

        try
        {
            Scanner input = new Scanner(new File(filename));

            while (input.hasNextLine())
            {
                String line = input.nextLine();
                String[] words = line.split(" ");
                wordCount += words.length;
            }
            input.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filename);
        }
        return wordCount;
    }

    public static String pickRandomWord (String filename)
    {
        int length = countWords(filename);
        Random random = new Random();
        int secretWordNumber = random.nextInt(length + 1);

        String[] wordArray = new String[length]; // Create a string array of size of the length of the word list

        File file = new File(filename);
        Scanner input = new Scanner(file);

        int i = 0;

        while (input.hasNextLine())
        {
            wordArray[i] = input.nextLine();
            i++;
        }

        String secretWord = wordArray[secretWordNumber - 1];

        return secretWord;
    }
}


