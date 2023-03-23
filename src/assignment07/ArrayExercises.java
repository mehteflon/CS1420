/**
 * <p>
 * See below for requirements.  Note that the JavaDoc comments below
 * (and this one) are formatted with HTML tags to create a nicer
 * view in the generated documentation.
 * </p>
 */
package assignment07;

/* Only import java.awt.Color and java.awt.Rectangle. */
import java.awt.Color;
import java.awt.Rectangle;
/* No other imports are allowed. */

/**
 * <p>
 * This class is a collection of static methods for processing arrays.
 * There are no fields or static variables, and none are allowed.
 * (In other words, only use variables declared inside each method.)
 * You will not build ArrayExercises objects.  Instead, you'll just
 * call (execute) the static methods in this class, like this:  
 * ArrayExercises.sort(someArray)
 * </p>
 * 
 * <p>
 * This class is the starting point for programming assignment #7.  Each
 * method has a contract, and you will write the statements inside
 * each method to exactly satisfy the contract.  Note:  Some methods
 * indicate they might throw an exception.  You don't need to throw
 * these exceptions -- I've anticipated what exceptions will be thrown
 * normally when incorrect parameters are passed to the methods.
 * <b>(Don't add code to throw exceptions and don't prevent them
 * from being thrown.)</b>
 * </p>
 * 
 * <p>
 * Note:  None of the method contracts below says anything about files,
 * user input, or console printing.  Don't prompt the user or ask
 * for input.  You may print what you need to while testing,
 * but all printing should be removed from the code you submit.
 * </p>
 * 
 * <p>
 * When completing the assignment, students may not use any
 * Java library methods for working with arrays (sorting, searching, etc.),
 * except during testing.  Your tests may use the Arrays class, but your
 * functions here cannot.  (Advanced students must not use collections
 * or equivalent structures.) You will write equivalent code here instead.
 * </p>
 * 
 * @author ***Will Graham***
 * @version ***3/16/2023***
 */

public class ArrayExercises
{
    /**
     * <p>
     * This method returns an array of size 'size' full of unique randomly
     * ordered integers in the range [0..size).  All integers in the range
     * [0..size) will be in the array, but they will be in a shuffled order.
     * </p>
     * 
     * <p>
     * From Peter:  This is an example array function that is more complex than 
     * almost all of the assignment problems.  I am providing it to show you an 
     * interesting use of arrays as well as to show you how unit tests can be 
     * used to check correctness of methods and classes.
     * </p>
     * 
     * @param size the number of array locations requested
     * @return an array of the specified size filled with randomly ordered integers
     */
    public static int[] randomArray (int size)
    {
        // Create an array of the requested size.
        
        int[] numbers = new int[size];  // If size is negative, this throws an exception.
        
        // Fill the array with the integers [0..size)
        
        for (int i = 0; i < numbers.length; i++)
            numbers[i] = i;  // Just store the index of each location in the location, not normally done.
        
        // Shuffle the array (starting from the right).  For each
        //   position i, find a random position j, and swap elements
        //   at those positions.
        
        for (int i = numbers.length - 1; i > 0; i--)
        {
            // Pick a random location for j (but only to the left of i).
        	//   (Getting this wrong creates a bias - must do it as shown.)
            
            int j = (int) (Math.random()*(i+1));
            
            // j = (int) (Math.random() * size);  // This way is wrong - feel free to uncomment it to cause a JUnit test error.
            
            // Swap elements i and j in the array.
            
            int tempI = numbers[i];
            int tempJ = numbers[j];            
            numbers[i] = tempJ;
            numbers[j] = tempI;           
        }
        
        // Done.  Feel free to uncomment the lines below to simulate errors.
        
        // numbers = new int[size+1];  // This causes an error - the array size is wrong.
        // numbers[0] = -1;  // This causes an error - a number is overwritten.  I use it for testing my error code.
        
        return numbers;
    }
    
    /**
     * <p>
     * This method reverses 'in place' the elements in
     * the array.  Reversing is defined as moving the
     * elements in the array such that the first element
     * becomes the last element, the second element
     * becomes the second to last element, the third
     * element becomes the third to last element, etc.
     * </p>
     * 
     * <p>
     * This method does not have a return
     * type - the list array is modified directly.  In other words,
     * the contents of the data array will be changed and the
     * caller will see the changes. 
     * </p>
     * 
     * <p><b>This is problem #1 for programming assignment #7.</b></p>
     *
     * <p>(Hint:  Many students loop too far, and accidentally
     * do and undo the reversal.)</p>
     * 
     * @param symbols   An array that will be reversed.
     */
    public static void reverseOrder (char[] symbols) {
        int startIndex = 0;
        int endIndex = symbols.length - 1;

        while (startIndex < endIndex) {
            char temp = symbols[startIndex];
            symbols[startIndex] = symbols[endIndex];
            symbols[endIndex] = temp;

            startIndex++;
            endIndex--;
        }
        return;  // Stub
    }
    
    /**
     * <p>
     * This method counts and returns how many times the target
     * object occurs in the array.  For this method,
     * two objects are considered the same if they represent
     * the same thing.  In other words, use .equals().
     * </p>
     *
     * <p>Note:  It is legal for the values array to contain a
     * null object, and it is legal for the target to be null.
     * No exception should be thrown in this case, and the
     * correct count should be returned.</p>
     * 
     * <p><b>This is problem #2 for programming assignment #7.</b></p>
     *
     * <p>(Hint:  For testing, you can use Object arrays that you
     * fill with Strings, Colors, BigIntegers, or any other Object references.)</p>
     * 
     * @param values   An array of Object references
     * @param target   A target object
     * @return   The number of objects in the array that equal the target
     * @throws NullPointerException   If values is null
     */
    public static int count (Object[] values, Object target)
    {
    	// Hint -- you may want code like this...
    	// if (target == null)    or maybe   if (value == null), or some combination of code like this

        int length = values.length;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (values[i] != null && values[i].equals(target)) {
                counter++;
            } else if (values[i] == null && target == null) {
                counter++;
            }
        }
    	
        return counter; // Stub
    }
    
    /**
     * <p>
     * This method examines the elements in the array and
     * replaces all occurrences in the array of the original String 
     * with the replacement String.  The array contents are
     * modified.
     * </p>
     * 
     * <p>
     * For this method, two Strings are considered equal
     * if they refer to the same object.  (Use ==)  Note that either
     * the original String, the replacement String, or
     * any of the Strings in the list may be null, and this is
     * both allowed and expected on occasion.
     * </p>
     * 
     * <p>
     * This method does not have a return
     * type - the list array is modified directly.  In other words,
     * the contents of the data array will be changed and the
     * caller will see the changes. 
     * </p>
     * 
     * <p><b>This is problem #3 for programming assignment #7.</b></p>
     * 
     * <p>Hint:  If you have "Hello" and "Hello" in separate places
     * in your code, note that Java/IntelliJ may choose to create a single
     * String object for both of these "Hello" strings, and use it 
     * in both places that "Hello" exists.  To get around this,
     * use new String("Hello") if you want to guarantee the
     * creation of a different String object.  </p>
     * 
     * @param list   An array of String references
     * @param original   The String reference to be replaced
     * @param replacement   The replacement String reference
     * @throws NullPointerException   If list is null
     */
    public static void replace (String[] list, String original, String replacement)
    {
        int length = list.length;
        int counter = 0;

        for (int i = 0; i < length; i++) {
            if (list[i] == null && original == null) {
                list[i] = replacement;
            } else if (list[i] != null && list[i] == original) {
                list[i] = replacement;
            }
        }
        return; // Stub
    }
    
    /**
     * <p>
     * This method computes and returns the area of several rectangular
     * regions.  The data is not stored in Rectangle objects.  Instead,
     * the data is stored in parallel arrays.  (In parallel arrays,
     * data at position i in each array is related to the data in the
     * other arrays at position i:
     * </p>
     * 
     * <p>
     * For a rectangle i, width[i] specifies
     * the width of the rectangle, and height[i] specifies
     * the height of the rectangle.</p>
     * 
     * <p> A new array is created
     * (that is the same size as the width and height arrays)
     * and the area of each rectangle is computed and placed
     * in this array.  (Area of rectangle i would be stored
     * in the ith position in the array.)  The array is then returned.
     * </p>
     *
     * <p>
     * This method assumes (but does not check) that the widths and heights are positive.
     * </p>
     * 
     * <p>
     * Note that width and height arrays must be the same size.
     * </p>
     * 
     * <p><b>This is problem #4 for programming assignment #7.</b></p>
     * 
     * @param widths   An array of rectangle widths
     * @param heights  An array of rectangle heights
     * @return   An array of rectangle areas
     * @throws NullPointerException   If widths or heights is null
     * @throws ArrayIndexOutOfBoundsException   If widths or heights are not the same size
     */
    public static double[] computeAreas (double[] widths, double[] heights)
    {
        double[] areas = new double[widths.length];

        for (int i = 0; i < widths.length; i++) {
            areas[i] = widths[i] * heights[i];
        }

        return areas; // Stub
    }
    
    /**
     * <p>
     * This method creates and returns a new array that
     * contains all the colors stored in the original array,
     * except those colors that are equal to the target.  For this
     * method, two colors are equal if they represent the
     * same color.
     * </p>
     * 
     * <p>
     * Note that target may be null, and 'pixels' may contain
     * null elements.  Two null elements will be considered equal.
     * </p>
     * 
     * <p><b>This is problem #5 for programming assignment #7.</b></p>
     * 
     * <p>(Hint:  Use Color.BLUE, Color.RED, etc. for testing.)</p>
     * 
     * @param pixels   An array of Color references
     * @param target   The Color object to be removed
     * @throws NullPointerException   If pixels is null
     */
    public static Color[] remove (Color[] pixels, Color target)
    {
        if (pixels == null) { // check if pixels is null
            throw new NullPointerException("Array cannot be null.");
        }

        int counter = 0;

        for (int i = 0; i < pixels.length; i++) { // Counts how many instances of target color
            if ((pixels[i] == null && target == null) || (pixels[i] != null && target != null && pixels[i].equals(target))) {
                counter++;
            }
        }

        Color[] newColor = new Color[pixels.length - counter]; // Create new array to store updated values

        int newIndex = 0;

        for (int i = 0; i < pixels.length; i++) { // iterate through pixels array adding non-target colors to new array
            if (!((pixels[i] == null && target == null) || (pixels[i] != null && target != null && pixels[i].equals(target)))) {
                newColor[newIndex] = pixels[i];
                newIndex++;
            }
        }
        return newColor;  // return new array
    }
    
    
    /**
     * <p>
     * This method sorts the elements in the data array
     * in descending order using selection sort (The largest element will 
     * be placed in position 0.)
     * </p>
     * 
     * <p>
     * Note that this method does not have a return
     * type - the data array is sorted 'in place'.  In other words,
     * the contents of the data array will be changed and the
     * caller will see the changes.
     * </p>
     * 
     * <p>You must write a selection sort algorithm for this solution.</p>
     * 
     * <p><b>This is problem #6 for programming assignment #7.</b></p>
     * 
     * @param data   The array to be sorted
     * @throws NullPointerException   If data is null
     */    
    public static void sort (int[] data)
    {
        if (data == null) { // check if data array is null
            throw new NullPointerException("Array cannot be null.");
        }

        int length = data.length;

        for (int i = 0; i < length-1; i++) { // iterate through array, sorting from largest to smallest

            int maxIndex = i;

            for (int k = i + 1; k < length; k++) { // Find index of largest element
                if (data[k] > data[maxIndex]) {
                    maxIndex = k;
                }
            }

            if (maxIndex != i) { // Swap largest element with element at current position
                int temp = data[i];
                data[i] = data[maxIndex];
                data[maxIndex] = temp;
            }
        }
    	return;
    }
    
    
    /**
     * <p>
     * This method finds and returns the smallest rectangle in the
     * array.  The smallest rectangle is defined as the one
     * with the smallest area.  If two rectangles have the same
     * smallest area, the one that occurs last in the array
     * is returned.
     * </p>
     * 
     * <p>
     * This method requires that the rectangles array 
     * must not contain null.
     * </p>
     * 
     * <p><b>This is problem #7 for programming assignment #7.</b></p>
     * 
     * <p>(Hint:  Look up the documentation for the Rectangle class.
     * You'll see how to extract the needed information from each Rectangle.)</p>
     * 
     * @param rectangles   An array of rectangle objects
     * @return   The smallest rectangle in the array
     * @throws NullPointerException   If rectangles is null or rectangles contains null
     */
    public static Rectangle findSmallest (Rectangle[] rectangles)
    {
        if (rectangles == null) { // check if rectangles array is null
            throw new NullPointerException("Array cannot be null.");
        }
        if (rectangles.length == 0) { // check if rectangles array is empty
            throw new IllegalArgumentException("Array cannot be empty.");
        }

        double[] areas = new double[rectangles.length];

        int smallestIndex = 0; // Tracks index of smallest rectangle

        for (int i = 0; i < rectangles.length; i++) { // Calculates areas of each rectangle and stores in areas array
            areas[i] = rectangles[i].width * rectangles[i].height;
        }

        double minArea = areas[0];

        for (int i = 0; i < areas.length; i++) { // Finds smallest area
            if (areas[i] < minArea) {
                minArea = areas[i];
            }
        }

        for (int i = 0; i < areas.length; i++) { // find index of smallest rectangle(s)
            if (areas[i] == minArea) {
                smallestIndex = i;
            }
        }
        return rectangles[smallestIndex]; // return smallest rectangle(s)
    }
    
    /**
     * <p>
     * This method counts how many times each value appears 
     * in the data array, and returns an array of these counts.
     * (If 16 occurs 13 times in the data array, then 
     * the returned array will contain a thirteen in position 16
     * of the array.)  This method assumes that data values 
     * will be non-negative and small.
     * </p>
     * 
     * <p>
     * The size of the returned list is determined by the maximum value
     * stored in the data array.  The size of the returned list will be
     * one greater than the maximum value stored in the data array.
     * </p>
     * 
     * <p><b>This is problem #8 for programming assignment #7.</b></p>
     * 
     * <p>(Hint:  This problem has two major steps.  Solve them one at a time,
     * and don't try to mix the code between the two steps.  (Keep the ideas
     * and code steps separately as much as you can.)</p>
     * 
     * @param data   A data array
     * @return   An array of counts
     */
    public static int[] histogram (int[] data)
    {
        if (data == null || data.length == 0) { // check if array null or empty
            return new int[0];
        }

        int maxValue = data[0];
        for (int i = 1; i < data.length; i++) { // find maximum value in data array
            if (data[i] > maxValue) {
                maxValue = data[i];
            }
        }

        int[] counts = new int[maxValue + 1]; // Create new array with length maxValue + 1 because we want to count the occurences of each value from 0 to maxValue


        for (int i = 0; i < data.length; i++) { // loop through array and increment count of each value in counts array
            counts[data[i]]++;
        }

        return counts;  // Return the counts array
    }

}
