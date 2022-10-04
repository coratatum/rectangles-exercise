package example.app.controllers;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RectangleResponse {
    @JsonProperty("rectangle1ContainsRectangle2")
    public boolean rectangle1ContainsRectangle2;
    @JsonProperty("rectangle1ContainsRectangle2")
    public boolean rectangle2ContainsRectangle1;
    @JsonProperty("adjecencyOfRectangles")
    public String adjecencyOfRectangles;
    @JsonProperty("intersectionPoints")
    public List<PointData> points;

    public static class PointData {
        @JsonProperty("xVal")
        public int xVal;
        @JsonProperty("yVal")
        public int yVal;

    }
}