package Lab1.Collections.Collect;

public class EmptyException extends RuntimeException {
    public EmptyException(String message) {
        super(message);
    }
    public EmptyException() {
        super();
    }
}
