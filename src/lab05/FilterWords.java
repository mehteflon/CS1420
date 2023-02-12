package lab05;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilterWords {
    public static void main (String[] args)
    {
        try (Scanner in = new Scanner(new File("C:\\Users\\willk\\IdeaProjects\\CS1420\\src\\lab05\\words.txt"));
            PrintWriter out = new PrintWriter("C:\\Users\\willk\\IdeaProjects\\CS1420\\src\\lab05\\fives.txt");)
        {
            while (in.hasNext())
            {
                String word;
                word = in.next();
                System.out.println(word);

                if (word.length() == 5)
                    out.write(word + "\n");

            }
        }
        catch (IOException e)
        {
            System.out.println("Could not read the words: " + e.getMessage());
        }
    }
}