package example.app;

import java.util.ArrayList;
import java.util.List;

import example.app.enums.AdjacencyType;
import example.app.enums.ContainedType;

public class AlgorithmService {

    /**
     * Get any intersection points for two provided rectangles.
     * @param r1 rectangle 1
     * @param r2 rectangle 2
     * @return list of intersection points, if none, returns empty list
     */
    public List<Point> getIntersectionPoints(Rectangle r1, Rectangle r2) {
        List<Point> intersectionPoints = new ArrayList<>();
        Integer maxLeftX = Math.max(r1.getBottomLeftPoint().getX(), r2.getBottomLeftPoint().getX());
        Integer minRightX = Math.min(r1.getTopRightPoint().getX(), r2.getTopRightPoint().getX());

        // if maximum left is smaller than minimum right, there is an intersection within x ranges
        if (maxLeftX < minRightX) {
            Integer maxBottomY = Math.max(r1.getBottomLeftPoint().getY(), r2.getBottomLeftPoint().getY());
            Integer minTopY = Math.min(r1.getTopRightPoint().getY(), r2.getTopRightPoint().getY());

            // if maximum lower val is smaller than the minium top val, there is an intersection in y ranges
            if (maxBottomY < minTopY) {
                // get intersection rectangle
                Point bottomLPoint = new Point(maxLeftX, maxBottomY);
                Point topRPoint = new Point(minRightX, minTopY);
                Rectangle intersectionRectangle = new Rectangle(bottomLPoint, topRPoint);
                // keep only points from intersection rectangle that are on the "rectangle edge" of both r1, r2
                List<Point> potentialIntersectionPoints = intersectionRectangle.getCorners();
                for (Point p : potentialIntersectionPoints) {
                    if (r1.isPointOnEdge(p) && r2.isPointOnEdge(p)) {
                        intersectionPoints.add(p);
                    }
                }
            }
        }

        return intersectionPoints;
    }



    /**
     * Get if Rectangle 1 contains Rectangle 2
     * @param r1 rectangle 1
     * @param r2 rectangle 2
     * @return ContainedType of Contained or None
     */
    public ContainedType getContainedType(Rectangle r1, Rectangle r2) {
        if(r1.getBottomLeftPoint().getX() <= r2.getBottomLeftPoint().getX()
          && r1.getBottomLeftPoint().getY() <= r2.getBottomLeftPoint().getY()
          && r1.getTopRightPoint().getX() >= r2.getTopRightPoint().getX()
          && r1.getTopRightPoint().getY() >= r2.getTopRightPoint().getY()) {
            return ContainedType.CONTAINED;
        }
        return ContainedType.NONE;
    }

    /**
     * Calculates what type of adjacency, if any, rectangle1 and rectangle 2 have
     * @param r1 rectangle 1
     * @param r2 rectangle 2
     * @return Adjacency Type
     */
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

}
