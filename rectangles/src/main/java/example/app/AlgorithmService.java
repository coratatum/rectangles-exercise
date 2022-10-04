package example.app;

import java.util.ArrayList;
import java.util.List;

import example.app.enums.AdjacencyType;

public class AlgorithmService {
    private Rectangle rectangle1;
    private Rectangle rectangle2;

    public AlgorithmService(Rectangle rectangle1, Rectangle rectangle2) {
        this.rectangle1 = rectangle1;
        this.rectangle2 = rectangle2;
    }

    public void brainDump() {
        Point r1Left = rectangle1.getBottomLeftPoint();
        Point r1Right = rectangle1.getTopRightPoint();
        Point r2Left = rectangle2.getBottomLeftPoint();
        Point r2Right = rectangle2.getTopRightPoint();

        Point leftPoint;
        Point rightPoint;

        Rectangle leftRectangle = rectangle1;
        Rectangle rightRectangle = rectangle1;

        //contains

    }

    public AdjacencyType getAdjacencyType(Rectangle r1, Rectangle r2) {
        AdjacencyType adjacentOnX = adjacentOnX(r1, r2);
        if (!adjacentOnX.equals(AdjacencyType.NONE)) {
            return adjacentOnX;
        } else {
            return adjacentOnY(r1, r2);
        }
    }

    private AdjacencyType adjacentOnX(Rectangle r1, Rectangle r2) {
        Rectangle leftRectangle;
        Rectangle rightRectangle;
        AdjacencyType adjacencyType = AdjacencyType.NONE;

        if (r1.getBottomLeftPoint().getX() == r2.getTopRightPoint().getX()) {
            leftRectangle = r1;
            rightRectangle = r2;
        } else if (r2.getBottomLeftPoint().getX() == r1.getTopRightPoint().getX()) {
            leftRectangle = r2;
            rightRectangle = r1;
        } else {
            return adjacencyType;
        }

        /* 
         * if bottom left point and bottom right point are the same, and both have same height
         * then the rectangles are Properly Adjacent
        */
        if (leftRectangle.getBottomLeftPoint().equals(rightRectangle.getBottomRightPoint())) {
            if (leftRectangle.getHeight() == rightRectangle.getHeight()) {
                return AdjacencyType.PROPER;
            }
        }

        /*
         * if bottom left is below bottom right and top left is above bottom right
         * AND top left is also above top right, then left is a sub-line
         * ELSE if top left is below top right, then adjacency is Partial
         */
        if (leftRectangle.getBottomLeftPoint().getY() <= rightRectangle.getBottomRightPoint().getY() 
          && leftRectangle.getTopLeftPoint().getY() > rightRectangle.getBottomRightPoint().getY()) {
            if (leftRectangle.getTopLeftPoint().getY() > rightRectangle.getTopRightPoint().getY()) {
                adjacencyType = AdjacencyType.SUBLINE;
            } else {
                adjacencyType = AdjacencyType.PARTIAL;
            }
        } else if (leftRectangle.getTopLeftPoint().getY() >= rightRectangle.getTopRightPoint().getY()
          && leftRectangle.getBottomLeftPoint().getY() < rightRectangle.getTopLeftPoint().getY()) {
            if (leftRectangle.getBottomLeftPoint().getY() < rightRectangle.getBottomRightPoint().getY()) {
                adjacencyType = AdjacencyType.SUBLINE;
            } else {
                adjacencyType = AdjacencyType.PARTIAL;
            }
        }

        return adjacencyType;
    }

    private AdjacencyType adjacentOnY(Rectangle r1, Rectangle r2) {
        Rectangle topRectangle;
        Rectangle bottomRectangle;
        AdjacencyType adjacencyType = AdjacencyType.NONE;

        if (r1.getBottomLeftPoint().getY() == r2.getTopRightPoint().getY()) {
            topRectangle = r1;
            bottomRectangle = r2;
        } else if (r2.getBottomLeftPoint().getY() == r1.getTopRightPoint().getY()) {
            topRectangle = r2;
            bottomRectangle = r1;
        } else {
            return adjacencyType;
        }

        if (topRectangle.getBottomLeftPoint().equals(bottomRectangle.getTopLeftPoint())) {
            if (topRectangle.getWidth() == bottomRectangle.getWidth()) {
                return AdjacencyType.PROPER;
            }
        }

        if (topRectangle.getBottomLeftPoint().getX() <= bottomRectangle.getTopLeftPoint().getX()
        && topRectangle.getBottomRightPoint().getX() > bottomRectangle.getTopLeftPoint().getX()) {
            if (topRectangle.getBottomRightPoint().getX() > bottomRectangle.getTopLeftPoint().getX()) {
                adjacencyType = AdjacencyType.SUBLINE;
            } else {
                adjacencyType = AdjacencyType.PARTIAL;
            }
        } else if (topRectangle.getBottomRightPoint().getX() >= bottomRectangle.getTopRightPoint().getX()
        && topRectangle.getBottomLeftPoint().getX() < bottomRectangle.getTopRightPoint().getX()) {
            if (topRectangle.getBottomLeftPoint().getX() < bottomRectangle.getTopLeftPoint().getX()) {
                adjacencyType = AdjacencyType.SUBLINE;
            } else {
                adjacencyType = AdjacencyType.PARTIAL;
            }
        }

        return adjacencyType;
    }

    public List<Rectangle> rectanglesFromLeftToRightByLowerLeftCorner() {
        List<Rectangle> rectanglesByLeftCorner = new ArrayList<>();

        return rectanglesByLeftCorner;
    }

    public Rectangle getRectangle1() {
        return rectangle1;
    }

    public Rectangle getRectangle2() {
        return rectangle2;
    }

}
