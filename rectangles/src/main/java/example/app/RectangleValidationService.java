package example.app;

import org.springframework.stereotype.Service;

import example.app.errors.InvalidRectangleException;

@Service
public class RectangleValidationService {

    /**
     * Ensure that a rectangle is valid - that the bottom left corner is below and
     * to the left of the upper right corner
     * 
     * @param rectangle rectangle to validate
     * @throws InvalidRectangleException if rectangle is not valid
     */
    public void validateRectangle(Rectangle rectangle) throws InvalidRectangleException {
        if (rectangle.getBottomLeftPoint().equals(rectangle.getTopRightPoint())) {
            throw new InvalidRectangleException("Bottom left point cannot be same as Top Right point");
        }

        if (rectangle.getBottomLeftPoint().getX() >= rectangle.getTopRightPoint().getX()
                || rectangle.getBottomLeftPoint().getY() >= rectangle.getTopRightPoint().getY()) {
            throw new InvalidRectangleException(
                    "Bottom Left corner of rectangle must have x and y coordinate of a lower value of Top Right point x and y values.");
        }
    }
}
