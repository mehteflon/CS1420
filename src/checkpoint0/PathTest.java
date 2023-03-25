package checkpoint0;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PathTest {

    private Path path;

    @BeforeEach
    public void setUp() {
        path = new Path();
    }

    @Test
    public void testPathConstructor() {
        assertNotNull(path, "Path object should not be null");
        assertEquals(0, path.size(), "Path size should be 0");
    }

    @Test
    public void testAdd() {
        Point point1 = new Point(1, 2);
        path.add(point1);
        assertEquals(1, path.size(), "Path size should be 1");
        assertEquals(point1, path.get(0), "Point should be equal to the added point");
    }

    @Test
    public void testGet() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        path.add(point1);
        path.add(point2);
        assertEquals(point1, path.get(0), "The point at index 0 should be equal to point1");
        assertEquals(point2, path.get(1), "The point at index 1 should be equal to point2");
    }

    @Test
    public void testSize() {
        assertEquals(0, path.size(), "Path size should be 0");
        Point point1 = new Point(1, 2);
        Point point2 = new Point(3, 4);
        path.add(point1);
        assertEquals(1, path.size(), "Path size should be 1");
        path.add(point2);
        assertEquals(2, path.size(), "Path size should be 2");
    }
}