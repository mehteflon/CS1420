/*
Will Graham u0982574
February 5 2023
This assignment was me playing around with graphics methods and I ended up randomly generating triangles and the colors that fill them.
 */

package assignment04;
import javax.swing.*;
import java.awt.*;

public class MyDrawingPanel extends JPanel implements Runnable // "extends jpanel is basically giving our object everything in a jpanel and allowing us to add to it

{
    public static void main (String[] args)
    {
        MyDrawingPanel mp = new MyDrawingPanel(); // Creates object

        SwingUtilities.invokeLater(mp); // instructs gui thread to execute run method
    }

    public void run() // The object we created above will have a run method
    {
        // this executes in the gui thread

        JFrame frame;
        frame = new JFrame("My Frame"); // jframe default state is empty and tiny
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(this);
        //frame.setContentPane(new JButton("Don't press me!"));

        frame.pack(); // recalculates the size
        frame.setVisible(true);
    }


    public void paint (Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800); // Gives panel black background

        int x1, y1, x2, y2, x3, y3;
        for (int i = 0; i < 15; i++) // i < whatever # of triangles we want to make, in this case 15
        {
            // Block of code below generates random x and y coordinates that we will use in the x/y coordinate arrays that get passed to the .drawPolygon method
            x1 = (int) (Math.random() * 800);
            System.out.print(x1);
            y1 = (int) (Math.random() * 800);
            x2 = (int) (Math.random() * 800);
            y2 = (int) (Math.random() * 800);
            x3 = (int) (Math.random() * 800);
            y3 = (int) (Math.random() * 800);

            g.setColor(new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256))); // generates random color within the rgb set (0-255)
            g.drawPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3); // Draws the triangles, {x1, x2, x3} is the array of x coordinates for the verticies and vice versa for {y1, y2, y3}
            g.fillPolygon(new int[] {x1, x2, x3}, new int[] {y1, y2, y3}, 3); // Fills triangles in with color
        }


    }
    public Dimension getMinimumSize()
    {
        return new Dimension (800, 800);
    }

    public Dimension getMaximumSize()
    {
        return new Dimension (800, 800);
    }

    public Dimension getPreferredSize()
    {
        return new Dimension (800, 800);
    }
}
