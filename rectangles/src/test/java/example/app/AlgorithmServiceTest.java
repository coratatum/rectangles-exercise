package example.app;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;
import org.testng.annotations.*;

/**
 * Unit test for simple App.
 */
public class AlgorithmServiceTest {

    AlgorithmService service;

    @BeforeClass
    public void init() {
        service = new AlgorithmService();
    }

    @Test
    public void testGetIntersectionPoints_noIntersection() {
        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(4, 3));
        Rectangle r2 = new Rectangle(new Point(5, 2), new Point(7, 4));

        List<Point> retVal = service.getIntersectionPoints(r1, r2);
        assertTrue(retVal.isEmpty());
    }

    @Test
    public void testGetIntersection_intersectOnSide() {
        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(6, 5));
        Rectangle r2 = new Rectangle(new Point(5, 2), new Point(8, 4));

        List<Point> retVal = service.getIntersectionPoints(r1, r2);
        assertFalse(retVal.isEmpty());
        assertTrue(retVal.size() == 2);

        Point expectedVal1 = new Point(6, 2);
        Point expectedVal2 = new Point(6, 4);
        assertTrue(retVal.containsAll(Arrays.asList(expectedVal1, expectedVal2)));
    }

    @Test
    public void testGetIntersection_intersectionOnTop() {
        Rectangle r1 = new Rectangle(new Point(0, 0), new Point(4, 4));
        Rectangle r2 = new Rectangle(new Point(1, 3), new Point(3, 6));

        List<Point> retVal = service.getIntersectionPoints(r1, r2);
        assertFalse(retVal.isEmpty());
        assertTrue(retVal.size() == 2);

        Point expectedVal1 = new Point(1, 4);
        Point expectedVal2 = new Point(3, 4);
        assertTrue(retVal.containsAll(Arrays.asList(expectedVal1, expectedVal2)));
    }

    @Test
    public void testGetIntersection_intersectOnCorner() {
        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(5, 5));
        Rectangle r2 = new Rectangle(new Point(3, -2), new Point(7, 2));

        List<Point> retVal = service.getIntersectionPoints(r1, r2);
        assertFalse(retVal.isEmpty());
        assertTrue(retVal.size() == 2);

        Point expectedVal1 = new Point(3, 1);
        Point expectedVal2 = new Point(5, 2);
        assertTrue(retVal.containsAll(Arrays.asList(expectedVal1, expectedVal2)));
    }

    @Test
    public void testGetIntersection_intersectTetris() {
        Rectangle r1 = new Rectangle(new Point(0, 0), new Point(3, 5));
        Rectangle r2 = new Rectangle(new Point(0, 1), new Point(5, 4));

        List<Point> retVal = service.getIntersectionPoints(r1, r2);
        assertFalse(retVal.isEmpty());
        assertTrue(retVal.size() == 2);

        Point expectedVal1 = new Point(3, 1);
        Point expectedVal2 = new Point(3, 4);
        assertTrue(retVal.containsAll(Arrays.asList(expectedVal1, expectedVal2)));
    }

    @Test
    public void testGetIntersection_intersectCross() {
        Rectangle r1 = new Rectangle(new Point(1, 1), new Point(4, 2));
        Rectangle r2 = new Rectangle(new Point(2, 0), new Point(3, 5));

        List<Point> retVal = service.getIntersectionPoints(r1, r2);
        assertFalse(retVal.isEmpty());
        assertTrue(retVal.size() == 4);

        Point expectedVal1 = new Point(2, 1);
        Point expectedVal2 = new Point(2, 3);
        Point expectedVal3 = new Point(3, 1);
        Point expectedVal4 = new Point(3, 2);
        assertTrue(retVal.containsAll(Arrays.asList(expectedVal1, expectedVal2, expectedVal3, expectedVal4)));
    }
}
