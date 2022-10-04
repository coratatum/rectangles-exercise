package example.app.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RectangleResponse {
    @JsonProperty("rectangle1ContainsRectangle2")
    public boolean rectangle1ContainsRectangle2;

    @JsonProperty("rectangle2ContainsRectangle1")
    public boolean rectangle2ContainsRectangle1;

    @JsonProperty("adjecencyOfRectangles")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String adjecencyOfRectangles;

    @JsonProperty("intersectionPoints")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<PointData> intersectionPoints;

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

    public boolean isRectangle1ContainsRectangle2() {
        return rectangle1ContainsRectangle2;
    }

    public void setRectangle1ContainsRectangle2(boolean rectangle1ContainsRectangle2) {
        this.rectangle1ContainsRectangle2 = rectangle1ContainsRectangle2;
    }

    public boolean isRectangle2ContainsRectangle1() {
        return rectangle2ContainsRectangle1;
    }

    public void setRectangle2ContainsRectangle1(boolean rectangle2ContainsRectangle1) {
        this.rectangle2ContainsRectangle1 = rectangle2ContainsRectangle1;
    }

    public String getAdjecencyOfRectangles() {
        return adjecencyOfRectangles;
    }

    public void setAdjecencyOfRectangles(String adjecencyOfRectangles) {
        this.adjecencyOfRectangles = adjecencyOfRectangles;
    }

    public List<PointData> getPoints() {
        return intersectionPoints;
    }

    public void setPoints(List<PointData> points) {
        this.intersectionPoints = points;
    }
}