package example.app.services;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.aop.config.PointcutComponentDefinition;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import example.app.controllers.RectangleRequest;

public class ConversionServiceTest {

    @InjectMocks
    public ConversionService conversionService;

    @Mock
    RectangleValidationService validationService;

    @BeforeTest
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testConversionService() {
        RectangleRequest.RectangleData rectangleData = new RectangleRequest.RectangleData(
                new RectangleRequest.RectangleData.PointData(1, 2),
                new RectangleRequest.RectangleData.PointData(3, 6));

        Rectangle retVal = conversionService.createValidRectangle(rectangleData);
        assertNotNull(retVal);
        assertEquals(retVal.getBottomLeftPoint(), new Point(1, 2));
        assertEquals(retVal.getTopRightPoint(), new Point(3, 6));
    }
}
