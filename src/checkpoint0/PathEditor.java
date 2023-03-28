/*
Author: Will Graham.
 */


package checkpoint0;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PathEditor extends JPanel implements Runnable, MouseListener, ActionListener {

    private BufferedImage background;
    private JMenuItem menuItemLoad;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemClear;
    private Path path;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PathEditor());
    }

    @Override
    public void run () {

        path = new Path();

        try
        {
            background = javax.imageio.ImageIO.read(new File("/Users/willgraham/IdeaProjects/CS 1420 - Spring 2023/src/checkpoint0/background.png"));
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

        // Create menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuItemLoad = new JMenuItem("Load");
        menuItemSave = new JMenuItem("Save");
        menuItemClear = new JMenuItem("Clear");
        menu.add(menuItemLoad);
        menu.add(menuItemSave);
        menu.add(menuItemClear);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Listen to the JMenuItems
        menuItemLoad.addActionListener(this);
        menuItemSave.addActionListener(this);
        menuItemClear.addActionListener(this);

        this.addMouseListener(this);

        frame.pack();

        frame.setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (background != null) {
            g.drawImage(background, 0, 0, null);
        }

        // Draw the path
        path.draw(g);
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

        Point point = new Point(e.getX(), e.getY());
        path.add(point);
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuItemLoad) {
            // Load path using a FileChooser
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                path.load(file);
                repaint(); // Repaint after loading path
            }
        } else if (e.getSource() == menuItemSave) {
            // Save the path using a FileChooser
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showSaveDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                path.save(file);
            }
        } else if (e.getSource() == menuItemClear) {
            // Clear the path and repaint
            path.clear();
            repaint();
        } else {
            System.out.println("Unknown menu item clicked: " + e.getActionCommand());
        }
    }
}
