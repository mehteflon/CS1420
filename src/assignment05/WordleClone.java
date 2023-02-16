/**
 * @author Will Graham u0982574
 * @version February 14, 2023
 *
 * This application is a clone of the New York Times' "Wordle"
 */

package assignment05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * My wordle clone application.
 */
public class WordleClone
{
	public static void main(String[] args)
	{
		// Prepare the console scanner (note the variable name)
		
		Scanner console = new Scanner(System.in);
		
		// Below is welcome message + explanation of the game
		
		System.out.println("Welcome to my Wordle clone.");
		System.out.println("You have six guesses to guess the secret word.");
		System.out.println("Each guess is scored and printed back to you:");
		System.out.println("  Incorrect letters are replaced with -,");
		System.out.println("  Correctly placed letters are capitalized,");
		System.out.println("  Correct but misplaced letters are lowercase.");
		
		// Choose the winning, secret word from a text file of words.
		String filename = "C:\\Users\\willk\\IdeaProjects\\CS1420\\src\\assignment05\\five.txt";
		File file = new File(filename);

		String secretWord = null; // Initializes variable that stores the winning word

		try
		{
			secretWord = pickRandomWord(filename);
			System.out.println(secretWord);
		} catch (FileNotFoundException e)
		{
			System.out.println("File not found: " + filename);
		}
		
		// Loop, allow the user to make guesses.
		
		int guessCount = 1;  // Which guess they're on.
		
		while (guessCount <= 6)
		{
			// Give prompt, input a guess.  For input robustness, take the first word
			//   on each line.  (Input a line, then scan the first word from that line.)

			System.out.print("Enter guess #" + guessCount + ": ");
			String line = console.nextLine();
			if (line.trim().length() == 0)  // Skip blank lines (remove whitespace from ends, check length)
				continue;
			Scanner lineScanner = new Scanner(line);  // A second, temporary Scanner
			String guess = lineScanner.next();
			lineScanner.close();
			
			// Validate the guess. (Check the word against the list of words.)
			// If the guess is not a valid word, restart the loop.

			if (isValidWord(guess, filename) == false) // Method checks to make sure inputted word is in five.txt
			{
				System.out.println("That is not a valid word. Please try again.");
				continue;
			}

			guessCount++; // Counts each guess
			

			String scoredGuess = scoreGuess(guess, secretWord); // scoredGuess variable stores scored guess for later printing
			System.out.println ("Guess: " + guess);
			System.out.println ("Score: " + scoredGuess);

			String upperCaseAnswer = new String(guess.toUpperCase());

			if (scoredGuess.equals(upperCaseAnswer)) // Checks to see if user has one
			{
				System.out.println("You won!");
				break;
			}
		}

		if (guessCount == 7) // Checks to see if they've made all their guesses, if they have it means they haven't won since the above block of code would have run if that were the case
		{
			System.out.println("You lost.  The word was " + secretWord + ".");
		}
		console.close();
	}


	/**
	 * Given a filename, this method returns a count of the number of
	 * words in the file.  (Note that word length is not checked here.)
	 * 
	 * @param filename the name of an existing text file
	 * @return the count of words in the file
	 */
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
	
	/* TODO: Write the contract, function header, and function that picks a random
	 * word.  You'll need to know how many words are in the file, make a call
	 * to countWords above for that step.  Look in 'main' to figure out
	 * the function name, parameters, and return type.  This function is static.
	 */

	public static String pickRandomWord (String filename) throws FileNotFoundException
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
	
	/**
	 * Given a word and a filename, this method determines if the word
	 * is in the file.  True is returned if the word is in the file,
	 * and false is returned otherwise.  
	 * 
	 * Note that the word should not have any whitespace in it, or it 
	 * won't match anything scanned from the file.  (No special check
	 * is done here for that case.)  The reason is that this function
	 * uses the .next() function from the Scanner class, and this
	 * strips away whitespace.
	 * 
	 * @param word a String without whitespace
	 * @param filename the name of an existing text file
	 * @return true iff the word was found in the file.
	 */
	public static boolean isValidWord (String word, String filename)
	{
		try
		{
			Scanner input = new Scanner(new File(filename));
			while (input.hasNextLine())
			{
				if (input.nextLine().trim().equals(word))
				{
					return true;
				}
			}
			return false;
		} catch (FileNotFoundException e) {
			System.out.println("The file could not be found: " + e.getMessage());
			return false;
		}
	}
	
	/**
	 * This method returns a copy of the input String, but with the 
	 * character at the specified position changed to the given letter.
	 * Position must be a valid position in the String or the results
	 * are undefined.  
	 * 
	 * Note that this function does not alter the original String, it
	 * just returns a copy with a letter replaced.  Here is an example
	 * of how this method can be used.
	 * 
	 * word = replaceLetter(word, 1, 'a');
	 * 
	 * If word originally contained "put", the word would now contain
	 * "pat".   
	 * 
	 * 
	 * @param s any non-empty string
	 * @param position a valid position in the string
	 * @param letter a letter to put in the string
	 * @return a copy of the original string, with a letter replaced
	 */
	public static String replaceLetter(String s, int position, char letter)
	{
		return s.substring(0,position) + letter + s.substring(position+1);
	}
	
	/**
	 * Given a user's guess and a Wordle answer, this method 'scores' the guess.
	 * It returns something that looks like a copy of the guess:  Guess characters
	 * appear to be replaced with a '-' if they do not exist in the answer.  They
	 * remain unchanged if they exist in the answer but are in the wrong spot.
	 * They are changed to uppercase if they're in the correct spot.
	 * 
	 * This function requires five character strings of letters.
	 * 
	 * For example:
	 *      answer: miter
	 *      guess:  timid
	 *      score:  tIm--
	 *      
	 * Note that each letter in the guess or answer is only scored once.  Thus,
	 * even though there were multiple i's in the guess, only one was scored.
	 * 
	 * @param guess a five letter string
	 * @param answer a five letter string
	 * @return the wordle score for that guess
	 */
	public static String scoreGuess (String guess, String answer)
	{
		String score = "-----";

		for (int i = 0; i < 5; i++) // Loops through each character of guess and answer and checks against each other, updates answer and score accordingly
		{
			char guessChar = guess.charAt(i);
			char answerChar = answer.charAt(i);

			if (guessChar == answerChar)
			{
				score = replaceLetter(score, i, Character.toUpperCase(guessChar));
				answer = replaceLetter(answer, i, '-');
			}
		}

		for (int i = 0; i < 5; i++) // Loops through characters in the guess
		{
			char guessChar = guess.charAt(i);

			for (int k = 0; k < 5; k++) // Loops through characters in answer and checks with each character of guess
			{
				char answerChar = answer.charAt(k);

				if (answerChar != '-' && answerChar == guessChar)
				{
					if (score.contains(String.valueOf(guessChar)) == false) // Checks to make sure we don't repeat any letters (char should only 
					{
						score = replaceLetter(score, i, guessChar);

					}
				}
			}
		}
		return score;
	}

}
