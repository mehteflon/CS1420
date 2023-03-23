/*
 * A collection of unit tests for Assignment #7.  To make this work, you'll need to
 * follow a few steps to get JUnit tests set up in your project.
 *
 *     Find an @Test annotation above one of the functions below.
 *     It should be in red indicating that JUnit5 is not installed.
 *     Hover over it, and it will suggest JUnit4 along with more options.
 *     Do not install JUnit4.  Instead, look at the additional suggested
 *     options and select to install JUnit5.  Follow the prompts and
 *     JUnit5 will be installed for you.
 *
 *     That's it!  You should not need to adjust dependencies or
 *     install additional tools.  (Installing JUnit5 can be complex,
 *     but the above strategy is simple.)
 *
 *     I've already imported the needed classes (and functions) for
 *     JUnit5 assertions.  See below.
 *
 *  Peter Jensen
 *
 * Modified by:
 * @author ***Will Graham***
 * @version ***3/16/2023***
 */
package assignment07;

import java.awt.*;
import java.util.Arrays;  // OK in tests, not allowed in ArrayExercises

// Imports for JUnit 5

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/* I generated unit tests for all the functions in ArrayExercises.
 * To run the tests, just run this code.
 */
public class ArrayExercisesTest
{
	/* This is my first example unit test.  A unit test is just a piece of
	 * code that calls some method or builds some object, and tests
	 * for errors.  The code/test design is up to the programmer.
	 *
	 * The unit test library provides functions for 'asserting' correctness.
	 * I use assertEquals below.  If the two values are not equal, the
	 * unit test library throws an exception and records a failure.
	 *
	 * There are other assert functions in the unit test library that are
	 * useful for noting errors.  If the function below completes without
	 * recording a failure, then the test is marked as a success.
	 */
	@Test
	public void testRandomArray01()
	{
		// Call the function, ask for an array of thirty elements.

		int[] result;
		int size = 30;

		result = ArrayExercises.randomArray(size);  // This calls the function I'm testing.

		// The function has a specific contract that guarantees things
		//  about it's return value.  Check to make sure the method
		//  call did what it was supposed to.

		// Make sure the size of the result array is correct.

		assertEquals(size, result.length);  // If unequal, an error is recorded.

		// Make sure the required numbers [0..n-1] are in the array.

		numberLoop:  for (int n = 0; n < size; n++)  // Notice that I labeled this loop
		{
			// Search for n in the array.  When found, move on to the next n.

			for (int pos = 0; pos < size; pos++)
				if (result[pos] == n)
					continue numberLoop;  // Found it, continue the outer loop.

			// If we get this far, the number n was not found.  This is an error.

			fail("Number missing from random array: " + n + " in " + Arrays.toString(result));  // Record an error
		}

		// If the number loop completes without failing, all tests pass!
		//   (When this method ends normally, the test is marked as passing.)
	}

	/* I wanted two unit tests for my function.  The first one, above,
	 *   just makes sure the basic operation of 'randomArray' is
	 *   correct.  This second unit test makes sure the 'randomness'
	 *   is correct.  A truly random shuffle has equal likelihood
	 *   of any outcome.  I repeatedly generate random arrays,
	 *   then I count up results, and then check to make
	 *   sure that each outcome occurred with similar probability.
	 *
	 * Because random numbers may produce results
	 *   that look uneven, I loop many times to reduce the likelihood
	 *   of random results looking like an error.
	 *
	 * I do not expect students to study this code - it is poor code.
	 *   (I don't like the way I'm counting permutations.)  There
	 *   are better ways, but you haven't seen the required lectures
	 *   yet, so I'm using a more primitive solution.  I expect your
	 *   unit tests to be much less complex.
	 */
	@Test
	public void testRandomArray02()
	{
		// An array of three has six permutations.

		// Counts of how many times each permutation appears.

		int count012 = 0;
		int count021 = 0;
		int count102 = 0;
		int count120 = 0;
		int count201 = 0;
		int count210 = 0;

		// Repeatedly generate arrays (1,000,000 times).

		for (int count = 0; count < 1_000_000; count++)
		{
			// Generate an array of 3 elements.

			int[] result = ArrayExercises.randomArray(3);  // This calls the function I'm testing.

			// Keep counts of each permutation in the array.

			if (result[0] == 0 && result[1] == 1)       // [0, 1, 2]
				count012++;
			else if (result[0] == 0 && result[1] == 2)  // [0, 2, 1]
				count021++;
			else if (result[0] == 1 && result[1] == 0)  // [1, 0, 2]
				count102++;
			else if (result[0] == 1 && result[1] == 2)  // [1, 2, 0]
				count120++;
			else if (result[0] == 2 && result[1] == 0)  // [2, 0, 1]
				count201++;
			else // only other possibility is [2, 1, 0]
				count210++;
		}

		// Check each permutation.  It should occur 166,666 times on average.  Accept
		//   anything within +/- 3,000.

		if (Math.abs(166_666 - count012) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count012);

		if (Math.abs(166_666 - count021) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count021);

		if (Math.abs(166_666 - count102) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count102);

		if (Math.abs(166_666 - count120) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count120);

		if (Math.abs(166_666 - count201) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count201);

		if (Math.abs(166_666 - count210) > 3_000)
			fail("Permutation [0, 1, 2] appears an unexpected number of times:  " + count210);

		// If execution completes without failing, the test passes!
		//   (When this method ends normally, the test is marked as passing.)
	}


	@Test
	public void testReverseOrder01() // tests with simple char array
	{
		// Set up a char[], call the ArrayExercises.reverse(...) function.
		// Test the array to make sure the function did its job.
		char[] symbols = {'a', 'b', 'c', 'd'};
		ArrayExercises.reverseOrder(symbols);

		// Test the array to make sure the function did its job.
		char[] expected = {'d', 'c', 'b', 'a'};
		assertArrayEquals(expected, symbols);
	}

	@Test
	public void testReverseOrder02() { // tests with char array containing digits
		char[] symbols = {'1', '2', '3', '4', '5'};
		ArrayExercises.reverseOrder(symbols);

		char[] expected = {'5', '4', '3', '2', '1'};
		assertArrayEquals(expected, symbols);
	}

	@Test
	public void testReverseOrder03() { // tests with char array containing uppercase letters
		char[] symbols = {'A', 'B', 'C', 'D', 'E', 'F'};
		ArrayExercises.reverseOrder(symbols);

		char[] expected = {'F', 'E', 'D', 'C', 'B', 'A'};
		assertArrayEquals(expected, symbols);
	}

	@Test
	public void testReverseOrder04() { // tests with empty char array
		char[] symbols = {};
		ArrayExercises.reverseOrder(symbols);

		char[] expected = {};
		assertArrayEquals(expected, symbols);
	}

	@Test
	public void testReverseOrder05() { // tests with single element char array
		char[] symbols = {'a'};
		ArrayExercises.reverseOrder(symbols);

		char[] expected = {'a'};
		assertArrayEquals(expected, symbols);
	}

	/* Note:  You'll want more unit test functions.  Cut-and-paste existing tests, but increase
	 * the number in the function names.  Make sure to include @test before each function header.
	 *
	 * testReverseOrder01
	 * testReverseOrder02
	 * testReverseOrder03  ...etc...
	 *
	 * You can then put different test code in each test to be thorough.
	 */

	@Test
	public void testCount01() { // tests with integer array and target integer
		Integer[] values = {1, 2, 3, 1, 4, 1, 5};
		int target = 1;

		int actual = ArrayExercises.count(values, target);
		int expected = 3;

		assertEquals(expected, actual);
	}

	@Test
	public void testCount02() { // tests with string array and target string
		String[] values = {"apple", "banana", "orange", "apple", "apple", "banana"};
		String target = "apple";

		int actual = ArrayExercises.count(values, target);
		int expected = 3;

		assertEquals(expected, actual);
	}

	@Test
	public void testCount03() { // tests with object array containing mix of types and null values, with null target
		Object[] values = {1, "apple", null, 2, "banana", null, "orange"};
		Object target = null;

		int actual = ArrayExercises.count(values, target);
		int expected = 2;

		assertEquals(expected, actual);
	}

	@Test
	public void testCount04() { // test with empty object array and non-null target
		Object[] values = {};
		Object target = "apple";

		int actual = ArrayExercises.count(values, target);
		int expected = 0;

		assertEquals(expected, actual);
	}

	@Test
	public void testCount05() { // test with a double array and target double
		Double[] values = {1.2, 2.3, 1.2, 4.5, 1.2};
		Double target = 1.2;

		int actual = ArrayExercises.count(values, target);
		int expected = 3;

		assertEquals(expected, actual);
	}

	@Test
	public void testReplace01() { // tests with simple string array, replacing existing value with a new one
		String[] list = {"apple", "banana", "apple", "orange", "apple"};
		String original = "apple";
		String replacement = "pear";

		ArrayExercises.replace(list, original, replacement);

		String[] expected = {"pear", "banana", "pear", "orange", "pear"};
		assertArrayEquals(expected, list);
	}

	@Test
	public void testReplace02() { // tests with string array containing null values, replacing null values with new value
		String[] list = {"apple", null, "banana", null, "orange"};
		String original = null;
		String replacement = "grape";

		ArrayExercises.replace(list, original, replacement);

		String[] expected = {"apple", "grape", "banana", "grape", "orange"};
		assertArrayEquals(expected, list);
	}

	@Test
	public void testReplace03() { // test with string array where the original value is not present
		String[] list = {"apple", "banana", "orange"};
		String original = "kiwi";
		String replacement = "pear";

		ArrayExercises.replace(list, original, replacement);

		String[] expected = {"apple", "banana", "orange"};
		assertArrayEquals(expected, list);
	}

	@Test
	public void testReplace04() { // tests with empty string array
		String[] list = {};
		String original = "apple";
		String replacement = "pear";

		ArrayExercises.replace(list, original, replacement);

		String[] expected = {};
		assertArrayEquals(expected, list);
	}

	@Test
	public void testReplace05() { // tests with string array, replacing existing value with null
		String[] list = {"apple", "banana", "orange", null, "apple", null};
		String original = "apple";
		String replacement = null;

		ArrayExercises.replace(list, original, replacement);

		String[] expected = {null, "banana", "orange", null, null, null};
		assertArrayEquals(expected, list);
	}

	@Test
	public void testComputeAreas01() { // test with array of widths and heights containing positive values
		double[] widths = {1.0, 2.0, 3.0, 4.0};
		double[] heights = {5.0, 6.0, 7.0, 8.0};

		double[] actual = ArrayExercises.computeAreas(widths, heights);
		double[] expected = {5.0, 12.0, 21.0, 32.0};

		assertArrayEquals(expected, actual, 1e-9);
	}

	@Test
	public void testComputeAreas02() { // tests with arrays of widths and heights containing decimal values
		double[] widths = {1.5, 2.5, 3.5};
		double[] heights = {4.5, 5.5, 6.5};

		double[] actual = ArrayExercises.computeAreas(widths, heights);
		double[] expected = {6.75, 13.75, 22.75};

		assertArrayEquals(expected, actual, 1e-9);
	}

	@Test
	public void testComputeAreas03() { // tests with arrays of widths containing zero values and heights containing positive values
		double[] widths = {0.0, 0.0, 0.0};
		double[] heights = {1.0, 2.0, 3.0};

		double[] actual = ArrayExercises.computeAreas(widths, heights);
		double[] expected = {0.0, 0.0, 0.0};

		assertArrayEquals(expected, actual, 1e-9);
	}

	@Test
	public void testComputeAreas04() { // tests with empty arrays of widths and heights
		double[] widths = {};
		double[] heights = {};

		double[] actual = ArrayExercises.computeAreas(widths, heights);
		double[] expected = {};

		assertArrayEquals(expected, actual, 1e-9);
	}

	@Test
	public void testRemove01() { // test with array of color objects, removing target color
		Color[] pixels = {Color.RED, Color.GREEN, Color.BLUE, Color.RED, Color.YELLOW, Color.RED};
		Color target = Color.RED;

		Color[] actual = ArrayExercises.remove(pixels, target);
		Color[] expected = {Color.GREEN, Color.BLUE, Color.YELLOW};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRemove02() { // test with array of color objects containing null values, removing null values
		Color[] pixels = {Color.RED, null, Color.BLUE, null, Color.YELLOW, null};
		Color target = null;

		Color[] actual = ArrayExercises.remove(pixels, target);
		Color[] expected = {Color.RED, Color.BLUE, Color.YELLOW};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRemove03() { // test with array of color objects that doesnt have target color
		Color[] pixels = {Color.RED, Color.GREEN, Color.BLUE};
		Color target = Color.YELLOW;

		Color[] actual = ArrayExercises.remove(pixels, target);
		Color[] expected = {Color.RED, Color.GREEN, Color.BLUE};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRemove04() { // test with empty array of color objects
		Color[] pixels = {};
		Color target = Color.RED;

		Color[] actual = ArrayExercises.remove(pixels, target);
		Color[] expected = {};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testRemove05() { // test with array of color objects containing null values, remove target color
		Color[] pixels = {Color.RED, null, Color.BLUE, null, Color.YELLOW, Color.RED};
		Color target = Color.RED;

		Color[] actual = ArrayExercises.remove(pixels, target);
		Color[] expected = {null, Color.BLUE, null, Color.YELLOW};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testSort01() { // tests with unsorted array of ints
		int[] data = {5, 3, 8, 2, 9, 1};

		ArrayExercises.sort(data);
		int[] expected = {9, 8, 5, 3, 2, 1};

		assertArrayEquals(expected, data);
	}

	@Test
	public void testSort02() { // tests with array of ints in ascending order
		int[] data = {1, 2, 3, 4, 5, 6};

		ArrayExercises.sort(data);
		int[] expected = {6, 5, 4, 3, 2, 1};

		assertArrayEquals(expected, data);
	}

	@Test
	public void testSort03() { // tests with array of ints in descending order
		int[] data = {6, 5, 4, 3, 2, 1};

		ArrayExercises.sort(data);
		int[] expected = {6, 5, 4, 3, 2, 1};

		assertArrayEquals(expected, data);
	}

	@Test
	public void testSort04() { // test with empty array of ints
		int[] data = {};

		ArrayExercises.sort(data);
		int[] expected = {};

		assertArrayEquals(expected, data);
	}

	@Test
	public void testSort05() { // tests with null input, expecting NullPointerException to be thrown
		assertThrows(NullPointerException.class, () -> ArrayExercises.sort(null));
	}

	@Test
	public void testFindSmallest01() { // tests with array of rectangle objects with different areas
		Rectangle[] rectangles = {
				new Rectangle(1, 2, 3, 4),
				new Rectangle(3, 4, 1, 2),
				new Rectangle(5, 6, 2, 3),
				new Rectangle(2, 3, 5, 6)
		};

		Rectangle actual = ArrayExercises.findSmallest(rectangles);
		Rectangle expected = new Rectangle(3, 4, 1, 2);

		assertEquals(expected, actual);
	}

	@Test
	public void testFindSmallest02() { // tests with another array of rectangle objects with different areas
		Rectangle[] rectangles = {
				new Rectangle(10, 20, 30, 40),
				new Rectangle(30, 40, 10, 20),
				new Rectangle(50, 60, 20, 30)
		};

		Rectangle actual = ArrayExercises.findSmallest(rectangles);
		Rectangle expected = new Rectangle(30, 40, 10, 20);

		assertEquals(expected, actual);
	}

	@Test
	public void testFindSmallest03() { // tests with array of rectangle objects with a single rectangle
		Rectangle[] rectangles = {
				new Rectangle(1, 1, 1, 1)
		};

		Rectangle actual = ArrayExercises.findSmallest(rectangles);
		Rectangle expected = new Rectangle(1, 1, 1, 1);

		assertEquals(expected, actual);
	}

	@Test
	public void testFindSmallest04() { // tests with null input expecting NullPointerException to be thrown
		assertThrows(NullPointerException.class, () -> ArrayExercises.findSmallest(null));
	}

	@Test
	public void testFindSmallest05() { // tests with an empty array of rectangle objects
		Rectangle[] rectangles = {};

		assertThrows(IllegalArgumentException.class, () -> ArrayExercises.findSmallest(rectangles));
	}

	@Test
	public void testFindSmallest06() { // tests with multiple rectangles having the same smallest area
		Rectangle[] rectangles = {
				new Rectangle(1, 2, 3, 4),
				new Rectangle(3, 4, 1, 2),
				new Rectangle(5, 6, 2, 3),
				new Rectangle(2, 3, 5, 6),
				new Rectangle(4, 6, 1, 2) // Adding another rectangle with the same smallest area
		};

		Rectangle actual = ArrayExercises.findSmallest(rectangles);
		Rectangle expected = new Rectangle(4, 6, 1, 2);

		assertEquals(expected, actual);
	}

	@Test
	public void testHistogram01() { // tests with array of ints containing multiple elements
		int[] data = {2, 3, 5, 3, 2, 1, 5, 2};

		int[] actual = ArrayExercises.histogram(data);
		int[] expected = {0, 1, 3, 2, 0, 2};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testHistogram02() { // tests with array of ints containing the same element
		int[] data = {1, 1, 1, 1, 1};

		int[] actual = ArrayExercises.histogram(data);
		int[] expected = {0, 5};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testHistogram03() { // tests with array of ints with only zero
		int[] data = {0, 0, 0, 0, 0};

		int[] actual = ArrayExercises.histogram(data);
		int[] expected = {5};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testHistogram04() { // tests with empty array of ints
		int[] data = {};

		int[] actual = ArrayExercises.histogram(data);
		int[] expected = {};

		assertArrayEquals(expected, actual);
	}

	@Test
	public void testHistogram05() { // tests with array of ints containing consecutive ints
		int[] data = {4, 3, 2, 1, 0};

		int[] actual = ArrayExercises.histogram(data);
		int[] expected = {1, 1, 1, 1, 1};

		assertArrayEquals(expected, actual);
	}
}
