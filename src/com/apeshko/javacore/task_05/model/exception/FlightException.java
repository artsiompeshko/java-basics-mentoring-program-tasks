package com.apeshko.javacore.task_05.model.exception;

public class FlightException extends RuntimeException {
    public FlightException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    public FlightException(String errorMessage) {
        super(errorMessage);
    }
}
