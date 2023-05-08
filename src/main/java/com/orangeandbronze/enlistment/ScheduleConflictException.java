package com.orangeandbronze.enlistment;

class ScheduleConflictException extends RuntimeException{
    public ScheduleConflictException(String message) {
        super(message);
    }

    public ScheduleConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public ScheduleConflictException(Throwable cause) {
        super(cause);
    }

    public ScheduleConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
