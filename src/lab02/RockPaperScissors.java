/**
 * Will Graham u0982574
 * January 17, 2023
 *
 * This program is a simple rock, paper, scissors game between a human participant and the computer.
 */

package lab02;
import java.util.Scanner;

public class RockPaperScissors
{
	public static void main(String[] args)
	{
		// Create a Scanner object.
		
		Scanner input = new Scanner(System.in);

		// Create two String variables.  Name them computerWord and userWord.
		// Initialize them to empty strings, i.e. "".


		String computerWord = "";
		String userWord = "";
		
	    // Make a random integer between [0...2].  If the random integer is a
	    //   0, set computerWord to "rock", if it's a 1, set computerWord
	    //   to "paper", otherwise set computerWord to "scissors".

		int value = (int) (Math.random() * 3);

		if (value == 0)
			computerWord = "rock";
		else if (value == 1)
			computerWord = "paper";
		else if (value == 2)
			computerWord = "scissors";
		
		// Using a Boolean flag, create an input loop that asks the player to enter
		//   their guess.  Print reasonable instructions.  Do not allow the program 
		//   to proceed until the player enters either "rock", "paper", or "scissors".
		//   Store it in userWord.

		boolean userInputIsOk = false;


		while ( ! userInputIsOk )
		{
			System.out.print("Enter rock, paper, or scissors: ");
			userWord = input.next();

			if (userWord.equals("rock"))
				userInputIsOk = true;
			else if (userWord.equals("paper"))
				userInputIsOk = true;
			else if (userWord.equals("scissors"))
				userInputIsOk = true;
		}


		
		// Print out the user's guess:  "You picked rock.", etc.
		// Print out the computer's guess:  "I picked rock.", etc.

		System.out.println("You picked " + userWord + ".");
		System.out.println("I picked " +computerWord + ".");
		
	    // Write a few 'if' statements to determine the result of the game and
	    //   print out the winner:  "I win",  "You win", "It's a tie"
	    // If the strings contain equal text, its a tie.
	    //  else if the player picks "rock" and the computer picks "scissors", the player wins,
	    //  else if ... (etc.)
		
		if (userWord.equals(computerWord))
			System.out.println("It's a tie.");
		else if (userWord.equals("rock") && computerWord.equals("scissors"))
			System.out.println("You win.");
		else if (userWord.equals("scissors") && computerWord.equals("paper"))
			System.out.println("You win.");
		else if (userWord.equals("paper") && computerWord.equals("rock"))
			System.out.println("You win.");
		else
			System.out.println("I win.");
	}
}
