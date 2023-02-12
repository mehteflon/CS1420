package testing;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.io.IOException;


public class testing {
    public static void main (String[] args)
    {
        File filename = new File("C:\\Users\\willk\\IdeaProjects\\CS1420\\src\\testing\\five.txt");

        try {
            String secretWord;
            secretWord = pickRandomWord("C:\\Users\\willk\\IdeaProjects\\CS1420\\src\\testing\\five.txt");
            System.out.println(secretWord);
        } catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + filename);
        }

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

    public static String pickRandomWord (String filename) throws FileNotFoundException
    {
        int length = countWords(filename);
        Random random = new Random();
        int secretWordNumber = random.nextInt(length);

        String[] wordArray = new String[length]; // Creates string array of size of list of words

        File file = new File(filename);
        Scanner input = new Scanner(file);

        int i = 0;

        while (input.hasNextLine()) {
            wordArray[i] = input.nextLine();
            i++;
        }

        String secretWord = wordArray[secretWordNumber];

        return secretWord;
    }
}


