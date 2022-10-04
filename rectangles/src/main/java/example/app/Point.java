package example.app;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Point {
    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Point)) {
            return false;
        }

        Point point2 = (Point) o;
        if (point2.getX().equals(x) && point2.getY().equals(y)) {
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
