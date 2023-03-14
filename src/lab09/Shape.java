package lab09;
import java.awt.Graphics;
import java.awt.Color;

abstract public class Shape
{
    // Instance variables (none, but you'll add some later)

    /**
     * Constructor - None, but you'll add one later
     */


    abstract public void move (int deltaX, int deltaY);

    abstract public boolean isInside (int targetX, int targetY);

    abstract public void draw (Graphics g);

}

