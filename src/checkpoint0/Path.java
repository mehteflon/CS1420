/*
Author: Will Graham
 */

package checkpoint0;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Path {
     private ArrayList<Point> points;

     public Path() {
         points = new ArrayList<Point>();
     }

     public void add(Point point) {
        points.add(point);
     }

     public Point get(int index) {
         return points.get(index);
     }

     public int size() {
         return points.size();
     }
    /*
    Takes graphics object g
     */
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        for (int i = 0; i < points.size() - 1; i++) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    // TODO: Implement load and save methods for the path
    public void load(File file) {
        points.clear();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextInt()) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                points.add(new Point(x, y));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /*
        @param a file with path data


        takes file with path data, saves
     */
    public void save(File file) {
        try (PrintWriter writer = new PrintWriter(file)) {
            for (Point point : points) {
                writer.println(point.x + " " + point.y);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void clear() {
        points.clear();
    }
}

