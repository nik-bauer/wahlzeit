package org.wahlzeit.utils.CustomExceptions;


public class CoordinateParameterException extends RuntimeException {

    public CoordinateParameterException() {
        super();
    }

    public CoordinateParameterException(String message) {
        super(message);
    }

    public CoordinateParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public CoordinateParameterException(Throwable cause) {
        super(cause);
    }

}
