package example.app;

import java.util.ArrayList;
import java.util.List;

public class Rectangle {
    private Point bottomLeft;
    private Point topLeft;
    private Point topRight;
    private Point bottomRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topLeft = new Point(bottomLeft.getX(), topRight.getY());
        this.topRight = topRight;
        this.bottomRight = new Point(topRight.getX(), bottomLeft.getY());
    }

    public Integer getHeight() {
        return topRight.getY() - bottomLeft.getY();
    }

    public Integer getWidth() {
        return bottomLeft.getX() - topRight.getX();
    }

    /**
     * See if provided point is on the edge of the rectangle
     * @param point point to determine if on edge of rectangle
     * @return true if the point is on the edge of the rectangle, false otherwise
     */
    public Boolean isPointOnEdge(Point point) {

        Boolean pointOnEdge = false;
        // fixed x, y in range
        if (point.getX() == bottomLeft.getX() || point.getX() == topRight.getX()) {
            if (bottomLeft.getY() <= point.getY() && point.getY() <= topRight.getY()) {
                pointOnEdge = true;
            }
        }
        // fixed y, x in range
        if (point.getY() == bottomLeft.getY() || point.getY() == topRight.getY()) {
            if (bottomLeft.getX() <= point.getX() && point.getX() <= topRight.getX()) {
                pointOnEdge = true;
            }
        }

        return pointOnEdge;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Rectangle)) {
            return false;
        }

        Rectangle r2 = (Rectangle) o;

        if (bottomLeft.equals(r2.getBottomLeftPoint()) && topRight.equals(r2.getTopRightPoint())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets points for all four corners of the rectangle
     * @return list of all four corner points of the rectangle, no assumed order
     */
    public List<Point> getCorners() {
        List<Point> allPoints =  new ArrayList<>();
        allPoints.add(bottomLeft);
        allPoints.add(bottomRight);
        allPoints.add(topRight);
        allPoints.add(topLeft);
        return allPoints;
    }

     /**
     * True if this rectangle fully contains provided rectangle
     * @param r2 rectangle to determine containment of
     * @return true if r2 is contained, false if not
     */
    public boolean contains(Rectangle r2) {
        if(bottomLeft.getX() <= r2.getBottomLeftPoint().getX()
          && bottomLeft.getY() <= r2.getBottomLeftPoint().getY()
          && topRight.getX() >= r2.getTopRightPoint().getX()
          && topRight.getY() >= r2.getTopRightPoint().getY()) {
            return true;
        }
        return false;
    }

    public Point getBottomLeftPoint() {
        return this.bottomLeft;
    }

    public Point getTopLeftPoint() {
        return this.topLeft;
    }

    public Point getTopRightPoint() {
        return this.topRight;
    }

    public Point getBottomRightPoint() {
        return this.bottomRight;
    }
}