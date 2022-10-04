package example.app.services;

import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RectangleTest {
    Rectangle rectangle;

    @BeforeTest
    public void init() {
        rectangle = new Rectangle(new Point(0, 0), new Point(5, 7));
    }

    @Test
    public void testContains_contains() {
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(3, 4));

        boolean retVal = rectangle.contains(r2);
        assertTrue(retVal);
    }

    @Test
    public void testContains_doesNotContain() {
        Rectangle r2 = new Rectangle(new Point(6, 10), new Point(8, 15));

        boolean retVal = rectangle.contains(r2);
        assertFalse(retVal);
    }

    @Test
    public void testContains_intersectsDoesNotContain() {
        Rectangle r2 = new Rectangle(new Point(1, 1), new Point(6, 8));

        boolean retVal = rectangle.contains(r2);
        assertFalse(retVal);
    }

    @Test
    public void testGetCorners() {
        Point expectedPoint1 = new Point(0, 0);
        Point expectedPoint2 = new Point(0, 7);
        Point expectedPoint3 = new Point(5, 7);
        Point expectedPoint4 = new Point(5, 0);

        List<Point> retVal = rectangle.getCorners();
        assertNotNull(retVal);
        assertFalse(retVal.isEmpty());
        assertEquals(retVal.size(), 4);
        assertTrue(retVal.containsAll(Arrays.asList(expectedPoint1, expectedPoint2, expectedPoint3, expectedPoint4)));
    }

    @Test
    public void testPointOnEdge_notOnEdge() {
        Point point = new Point(3, 5);

        boolean retVal = rectangle.isPointOnEdge(point);
        assertFalse(retVal);
    }

    @Test
    public void testPointOnEdge_pointOnLeftEdge() {
        Point point = new Point(0, 3);

        boolean retVal = rectangle.isPointOnEdge(point);
        assertTrue(retVal);
    }

    @Test
    public void testPointOnEdge_pointOnTopEdge() {
        Point point = new Point(2, 7);

        boolean retVal = rectangle.isPointOnEdge(point);
        assertTrue(retVal);
    }

    @Test
    public void testPointOnEdge_pointOnRightEdge() {
        Point point = new Point(5, 5);

        boolean retVal = rectangle.isPointOnEdge(point);
        assertTrue(retVal);
    }

    @Test
    public void testPointOnEdge_pointOnBottomEdge() {
        Point point = new Point(3, 0);

        boolean retVal = rectangle.isPointOnEdge(point);
        assertTrue(retVal);
    }
}
