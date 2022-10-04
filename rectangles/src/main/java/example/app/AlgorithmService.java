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
        AdjacencyType adjacencyType = AdjacencyType.NONE;

        Integer maxLeftX = Math.max(r1.getBottomLeftPoint().getX(), r2.getBottomLeftPoint().getX());
        Integer minRightX = Math.min(r1.getTopRightPoint().getX(), r2.getTopRightPoint().getX());

        if (!maxLeftX.equals(minRightX)) {
            return AdjacencyType.NONE;
        }

        Integer maxBottomY = Math.max(r1.getBottomLeftPoint().getY(), r1.getBottomLeftPoint().getY());
        Integer minTopY = Math.min(r1.getTopRightPoint().getY(), r2.getTopRightPoint().getY());

        if (maxBottomY < minTopY) {
            if (r1.getBottomLeftPoint().getY() < r2.getBottomLeftPoint().getY()) {
                if (r1.getTopRightPoint().getY() < r2.getTopRightPoint().getY()) {
                    adjacencyType = AdjacencyType.PARTIAL;
                } else if (r2.getTopRightPoint().getY() <= r1.getTopRightPoint().getY()) {
                    adjacencyType = AdjacencyType.SUBLINE;
                }
            } else if (r2.getBottomLeftPoint().getY() < r1.getBottomLeftPoint().getY()) {
                if (r2.getTopRightPoint().getY() < r1.getTopRightPoint().getY()) {
                    adjacencyType = AdjacencyType.PARTIAL;
                } else if (r1.getTopRightPoint().getY() <= r2.getTopRightPoint().getY()) {
                    adjacencyType = AdjacencyType.SUBLINE;
                }
            } else if (r1.getBottomLeftPoint().getY().equals(r2.getBottomLeftPoint().getY())) {
                if (r1.getHeight().equals(r2.getHeight())) {
                    adjacencyType = AdjacencyType.PROPER;
                }
            }
        } else {
            return AdjacencyType.NONE;
        }

        return adjacencyType;
    }

    private AdjacencyType adjacentOnY(Rectangle r1, Rectangle r2) {
        AdjacencyType adjacencyType = AdjacencyType.NONE;

        Integer maxBottomY = Math.max(r1.getBottomLeftPoint().getY(), r1.getBottomLeftPoint().getY());
        Integer minTopY = Math.min(r1.getTopRightPoint().getY(), r2.getTopRightPoint().getY());

        if (!maxBottomY.equals(minTopY)) {
            return AdjacencyType.NONE;
        }

        Integer maxLeftX = Math.max(r1.getBottomLeftPoint().getX(), r2.getBottomLeftPoint().getX());
        Integer minRightX = Math.min(r1.getTopRightPoint().getX(), r2.getTopRightPoint().getX());

        if (maxLeftX < minRightX) {
            if (r1.getBottomLeftPoint().getX() < r2.getBottomLeftPoint().getX()) {
                if (r1.getTopRightPoint().getX() < r2.getTopRightPoint().getX()) {
                    adjacencyType = AdjacencyType.PARTIAL;
                } else if (r2.getTopRightPoint().getX() <= r1.getTopRightPoint().getX()) {
                    adjacencyType = AdjacencyType.SUBLINE;
                }
            } else if (r2.getBottomLeftPoint().getX() < r1.getBottomLeftPoint().getX()) {
                if (r2.getTopRightPoint().getX() < r1.getTopRightPoint().getX()) {
                    adjacencyType = AdjacencyType.PARTIAL;
                } else if (r1.getTopRightPoint().getX() <= r2.getTopRightPoint().getX()) {
                    adjacencyType = AdjacencyType.SUBLINE;
                }
            } else if (r1.getBottomLeftPoint().getX().equals(r2.getBottomLeftPoint().getX())) {
                if (r1.getWidth().equals(r2.getWidth())) {
                    adjacencyType = AdjacencyType.PROPER;
                }
            }
        } else {
            return AdjacencyType.NONE;
        }

        return adjacencyType;
    }

}
