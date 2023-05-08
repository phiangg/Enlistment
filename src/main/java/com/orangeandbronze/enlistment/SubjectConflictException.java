package com.orangeandbronze.enlistment;

public class SubjectConflictException extends RuntimeException{
    public SubjectConflictException(String message) {
        super(message);
    }

    public SubjectConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public SubjectConflictException(Throwable cause) {
        super(cause);
    }

    public SubjectConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
