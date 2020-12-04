package com.apeshko.javacore.task_05.model.exception;

public class NotEnoughDistanceException extends FlightException {
    public NotEnoughDistanceException(String errorMessage) {
        super(errorMessage);
    }

    public NotEnoughDistanceException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}
