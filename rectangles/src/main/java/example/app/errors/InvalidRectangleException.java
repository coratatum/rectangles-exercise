package example.app.errors;

public class InvalidRectangleException extends RuntimeException {
    
    public InvalidRectangleException(String message) {
        super(message);
    }

    public InvalidRectangleException(String message, Throwable err) {
        super(message, err);
    }
}
