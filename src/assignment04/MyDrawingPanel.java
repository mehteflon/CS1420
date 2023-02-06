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
        System.out.println("Hey");

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 800, 800);

        for (int x = 0; x < 800; x += 5)
        {
            g.setColor(new Color(x/800f, 1.0f - (x/800f), 0f));
            g.drawLine(x, 0, 400, 400);

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
