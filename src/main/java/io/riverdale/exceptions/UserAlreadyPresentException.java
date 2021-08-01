package io.riverdale.exceptions;

public class UserAlreadyPresentException extends RuntimeException{
    public UserAlreadyPresentException() {
        super();
    }

    public UserAlreadyPresentException(String message) {
        super(message);
    }

    public UserAlreadyPresentException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyPresentException(Throwable cause) {
        super(cause);
    }
}
