package checkpoint0;

import java.util.ArrayList;
import java.awt.Point;

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
}
