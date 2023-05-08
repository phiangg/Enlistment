package com.orangeandbronze.enlistment;

class InvalidUnitException extends RuntimeException{
    public InvalidUnitException(String message) {
        super(message);
    }

    public InvalidUnitException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUnitException(Throwable cause) {
        super(cause);
    }

    public InvalidUnitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
