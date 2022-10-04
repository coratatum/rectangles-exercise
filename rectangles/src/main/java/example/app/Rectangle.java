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

    public Boolean equals(Rectangle r2) {
        if (bottomLeft.equals(r2.getBottomLeftPoint()) && topRight.equals(r2.getTopRightPoint())) {
            return true;
        } else {
            return false;
        }
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