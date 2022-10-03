package example.app;

public class Rectangle {
    private Point bottomLeft;
    private Point topLeft;
    private Point topRight;
    private Point bottomRight;

    public Rectangle(Point bottomLeft, Point topLeft, Point topRight, Point bottomRight) {
        this.bottomLeft = bottomLeft;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomRight = bottomRight;
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

    public Point getBottomRighPoint() {
        return this.bottomRight;
    }
}