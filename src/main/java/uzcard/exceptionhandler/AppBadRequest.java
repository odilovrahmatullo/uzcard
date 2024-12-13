package uzcard.exceptionhandler;

public class AppBadRequest extends RuntimeException {
    public AppBadRequest(String message) {
        super(message);
    }
}
