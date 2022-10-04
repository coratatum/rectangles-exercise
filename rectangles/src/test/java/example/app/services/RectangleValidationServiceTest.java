package example.app.services;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import example.app.errors.InvalidRectangleException;

public class RectangleValidationServiceTest {
    RectangleValidationService service;

    @BeforeClass
    public void init() {
        service = new RectangleValidationService();
    }

    @Test
    public void testRectangleValidation_isValid() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(3, 4));
        service.validateRectangle(rectangle);
    }

    @Test(expectedExceptions = InvalidRectangleException.class)
    public void testRectangleValidation_isNotValid_samePoint() {
        Rectangle rectangle = new Rectangle(new Point(0, 0), new Point(0, 0));
        service.validateRectangle(rectangle);
    }

    @Test(expectedExceptions = InvalidRectangleException.class)
    public void testRectangleValidation_isNotValid_incorrectOrder() {
        Rectangle rectangle = new Rectangle(new Point(5, 8), new Point(0, 0));
        service.validateRectangle(rectangle);
    }
}
