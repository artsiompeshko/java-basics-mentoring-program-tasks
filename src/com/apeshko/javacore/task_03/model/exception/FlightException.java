package com.apeshko.javacore.task_03.model.exception;

public class FlightException extends RuntimeException {
    public FlightException(String errorMessage) {
        super(errorMessage);
    }
}
