package example.app.controllers;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RectangleRequest {
    @JsonProperty("rectangle1")
    public RectangleData rectangle1;
    @JsonProperty("rectangle2")
    public RectangleData rectangle2;

    public static class RectangleData {
        @JsonProperty("bottomLeftPoint")
        public PointData bottomLeftPoint;
        @JsonProperty("topRightPoint")
        public PointData topRightPoint;

        public static class PointData {
            @JsonProperty("xVal")
            public int xVal;
            @JsonProperty("yVal")
            public int yVal;

            public PointData(int xVal, int yVal) {
                this.xVal = xVal;
                this.yVal = yVal;
            }

            public int getxVal() {
                return xVal;
            }

            public int getyVal() {
                return yVal;
            }

        }

        public RectangleData(PointData bottomLeftPoint, PointData topRightPoint) {
            this.bottomLeftPoint = bottomLeftPoint;
            this.topRightPoint = topRightPoint;
        }

        public PointData getBottomLeftPoint() {
            return bottomLeftPoint;
        }

        public PointData getTopRightPoint() {
            return topRightPoint;
        }
    }

    public RectangleRequest(RectangleData rectangle1, RectangleData rectangle2) {
        this.rectangle1 = rectangle1;
        this.rectangle2 = rectangle2;
    }

    public RectangleData getRectangle1() {
        return rectangle1;
    }

    public RectangleData getRectangle2() {
        return rectangle2;
    }
}