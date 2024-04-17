package one.behzad.teammanager.Exception;

public class BaseException extends RuntimeException {

    private Throwable cause;

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        this.cause = cause;
    }
}
