package Lab1.Collections.Collect;

public class OversizeException extends RuntimeException {
    public OversizeException(String message) {
        super(message);
    }
    OversizeException() {
        super();
    }
}
