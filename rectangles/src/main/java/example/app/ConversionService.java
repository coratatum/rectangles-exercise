package example.app;

import org.springframework.stereotype.Service;

import example.app.controllers.RectangleRequest;

@Service
public class ConversionService {
    RectangleValidationService validationService;

    public Rectangle createValidRectangle(RectangleRequest.RectangleData rectangleData) {
        Point bottomLeftPoint = new Point(rectangleData.getBottomLeftPoint().getxVal(),
                rectangleData.getBottomLeftPoint().getyVal());
        Point topRightPoint = new Point(rectangleData.getTopRightPoint().getxVal(),
                rectangleData.getTopRightPoint().getyVal());

        Rectangle rectangle = new Rectangle(bottomLeftPoint, topRightPoint);
        validationService.validateRectangle(rectangle);
        return rectangle;
    }
}
