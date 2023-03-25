package checkpoint0;

import lab09.Shape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PathEditor extends JPanel implements Runnable, MouseListener {

    private BufferedImage background;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PathEditor());
    }

    @Override
    public void run () {

        try
        {
            background = javax.imageio.ImageIO.read(new File("C:\\Users\\willk\\IdeaProjects\\CS1420\\src\\checkpoint0\\background.png"));
        }
        catch (IOException e)
        {
            System.out.println("Error loading image: " + e.getMessage());
        }

        System.out.println("This message is printed from the run method in the GUI thread.");

        JFrame frame = new JFrame("Path Editor");

        frame.setContentPane(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setMinimumSize(new Dimension(600, 600));
        this.setPreferredSize(new Dimension(600, 600));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuItem1 = new JMenuItem("Menu Item 1");
        menuItem2 = new JMenuItem("Menu Item 2");
        menu.add(menuItem1);
        menu.add(menuItem2);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        this.addMouseListener(this);

        frame.pack();

        frame.setVisible(true);
    }

    public void paint (Graphics g)
    {
        if (background != null) {
            g.drawImage(background, 0, 0, null);
        }

        g.setColor(new Color (0.8f, 0.8f, 1.0f));
        g.drawRect(200, 200, 85, 85);
        g.fillRect(200, 200, 85, 85);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse released at (" + e.getX() + ", " + e.getY() + ")");
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
