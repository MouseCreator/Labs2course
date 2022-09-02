package Lab1.Collections.IntCollections;

public class ErrorInformer {
    private static final String INVALID_DATA_TYPE_MSG = "Invalid data type for Collection";

    public static void printError(ErrorCodes code) {
        String message = "No error code.";
        switch (code) {
            case INVALID_DATA_TYPE: message = INVALID_DATA_TYPE_MSG;
        }
        System.err.println(message);
    }
}
