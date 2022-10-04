package it;

import static org.testng.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import example.app.controllers.RectangleRequest;
import example.app.controllers.RectangleResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RectangleIT extends AbstractTestNGSpringContextTests {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void getContains_rect1ContainsRect2() throws Exception {
        RectangleRequest.RectangleData rectangleData1 = new RectangleRequest.RectangleData(
                new RectangleRequest.RectangleData.PointData(0, 0),
                new RectangleRequest.RectangleData.PointData(5, 5));

        RectangleRequest.RectangleData rectangleData2 = new RectangleRequest.RectangleData(
                new RectangleRequest.RectangleData.PointData(1, 1),
                new RectangleRequest.RectangleData.PointData(4, 4));

        RectangleRequest rectangleRequest = new RectangleRequest(rectangleData1, rectangleData2);

        RequestEntity<RectangleRequest> request = RequestEntity.put(template.getRootUri() + "/rectangles/contains")
                .body(rectangleRequest);
        ResponseEntity<RectangleResponse> response = template.exchange(
                request,
                RectangleResponse.class);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        RectangleResponse rectangleResponse = response.getBody();
        assertNotNull(rectangleResponse);
        if (rectangleResponse != null) {
            assertTrue(rectangleResponse.isRectangle1ContainsRectangle2());
            assertFalse(rectangleResponse.isRectangle2ContainsRectangle1());
        }
    }

    @Test
    public void getContains_rect2Contains1() throws Exception {
        RectangleRequest.RectangleData rectangleData1 = new RectangleRequest.RectangleData(
                new RectangleRequest.RectangleData.PointData(4, 4),
                new RectangleRequest.RectangleData.PointData(5, 5));

        RectangleRequest.RectangleData rectangleData2 = new RectangleRequest.RectangleData(
                new RectangleRequest.RectangleData.PointData(1, 1),
                new RectangleRequest.RectangleData.PointData(7, 7));

        RectangleRequest rectangleRequest = new RectangleRequest(rectangleData1, rectangleData2);

        RequestEntity<RectangleRequest> request = RequestEntity.put(template.getRootUri() + "/rectangles/contains")
                .body(rectangleRequest);
        ResponseEntity<RectangleResponse> response = template.exchange(
                request,
                RectangleResponse.class);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        RectangleResponse rectangleResponse = response.getBody();
        assertNotNull(rectangleResponse);
        if (rectangleResponse != null) {
            assertFalse(rectangleResponse.isRectangle1ContainsRectangle2());
            assertTrue(rectangleResponse.isRectangle2ContainsRectangle1());
        }
    }

    @Test
    public void getContains_noContains() throws Exception {
        RectangleRequest.RectangleData rectangleData1 = new RectangleRequest.RectangleData(
                new RectangleRequest.RectangleData.PointData(0, 0),
                new RectangleRequest.RectangleData.PointData(5, 5));

        RectangleRequest.RectangleData rectangleData2 = new RectangleRequest.RectangleData(
                new RectangleRequest.RectangleData.PointData(1, 1),
                new RectangleRequest.RectangleData.PointData(7, 7));

        RectangleRequest rectangleRequest = new RectangleRequest(rectangleData1, rectangleData2);

        RequestEntity<RectangleRequest> request = RequestEntity.put(template.getRootUri() + "/rectangles/contains")
                .body(rectangleRequest);
        ResponseEntity<RectangleResponse> response = template.exchange(
                request,
                RectangleResponse.class);

        assertNotNull(response);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        RectangleResponse rectangleResponse = response.getBody();
        assertNotNull(rectangleResponse);
        if (rectangleResponse != null) {
            assertFalse(rectangleResponse.isRectangle1ContainsRectangle2());
            assertFalse(rectangleResponse.isRectangle2ContainsRectangle1());
        }
    }

}
