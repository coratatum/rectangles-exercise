package example.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import example.app.controllers.RectangleResponse.PointData;
import example.app.services.AlgorithmService;
import example.app.services.ConversionService;
import example.app.services.Rectangle;
import example.app.services.Point;

@Controller
@RequestMapping("rectangles")
public class RectangleController {
    @Autowired
    private ConversionService conversionService;

    @Autowired
    private AlgorithmService algorithmService;

    @PutMapping("/contains")
    @ResponseBody
    public ResponseEntity<RectangleResponse> rectangleContains(@RequestBody RectangleRequest rectangleRequest) {
        Rectangle validRectangle1 = conversionService.createValidRectangle(rectangleRequest.getRectangle1());
        Rectangle validRectangle2 = conversionService.createValidRectangle(rectangleRequest.getRectangle2());

        RectangleResponse response = new RectangleResponse();
        response.rectangle1ContainsRectangle2 = validRectangle1.contains(validRectangle2);
        response.rectangle2ContainsRectangle1 = validRectangle2.contains(validRectangle1);

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/adjacency")
    @ResponseBody
    public ResponseEntity<RectangleResponse> rectangleAdjacency(@RequestBody RectangleRequest rectangleRequest) {
        Rectangle validRectangle1 = conversionService.createValidRectangle(rectangleRequest.getRectangle1());
        Rectangle validRectangle2 = conversionService.createValidRectangle(rectangleRequest.getRectangle2());

        RectangleResponse response = new RectangleResponse();
        response.adjecencyOfRectangles = algorithmService.getAdjacencyType(validRectangle1, validRectangle2).toString();

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/intersection-points")
    @ResponseBody
    public ResponseEntity<RectangleResponse> rectangleIntersection(@RequestBody RectangleRequest rectangleRequest) {
        Rectangle validRectangle1 = conversionService.createValidRectangle(rectangleRequest.getRectangle1());
        Rectangle validRectangle2 = conversionService.createValidRectangle(rectangleRequest.getRectangle2());

        RectangleResponse response = new RectangleResponse();
        List<RectangleResponse.PointData> responsePoints = new ArrayList<>();
        List<Point> intersections = algorithmService.getIntersectionPoints(validRectangle1, validRectangle2);
        for (Point p : intersections) {
            responsePoints.add(new RectangleResponse.PointData(p.getX(), p.getY()));
        }
        response.intersectionPoints = responsePoints;

        return ResponseEntity.ok().body(response);

    }

}