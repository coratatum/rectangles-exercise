package example.app;

public class Point {
    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Boolean isEqual(Point point2) {
        if (point2.getX() == x && point2.getY() == y) {
            return true;
        } else {
            return false;
        }
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }
}
