package mx.poc.cors.exceptions;

public class BaseException extends RuntimeException{
    public BaseException() {
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message) {
        super(message);
    }
}
