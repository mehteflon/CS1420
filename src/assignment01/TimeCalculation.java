/**
 * This class calculates my uID as if it were seconds, and outputs that number in [hours, minutes, seconds] format.
 *
 * @author  Will Graham u0982574
 * @version January 12, 2023
 */

package assignment01;

public class TimeCalculation {
    public static void main(String[] args)
    {
        int uID = 982574; // My uID number
        int hours = uID/3600; // Calculates how many hours are in 982574
        int minutes = (uID%3600)/60; // Uses modulus operator to get remainder from previous calculation, divides it by 60  to get number of minutes
        int seconds = (uID%3600)%60; // Uses modulus operator to get remainder from previous calculation, which is the # of seconds

        System.out.print("My uID number is u");
        System.out.print(uID);
        System.out.println("."); // This and previous two lines print my uID.
        System.out.print(uID + " seconds is " + hours + " hour(s), " + minutes + " minute(s), and " + seconds + " second(s)."); // Prints hours/minutes/seconds of uID.

    }
}
