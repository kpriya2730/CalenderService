package exception;

public class InvalidEventParametersException extends RuntimeException{
    public InvalidEventParametersException() {
        super();
    }

    public InvalidEventParametersException(String message) {
        super(message);
    }

    public InvalidEventParametersException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEventParametersException(Throwable cause) {
        super(cause);
    }

    protected InvalidEventParametersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
