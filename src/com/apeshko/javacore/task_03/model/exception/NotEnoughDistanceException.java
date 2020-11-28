package com.apeshko.javacore.task_03.model.exception;

public class NotEnoughDistanceException extends FlightException {
    public NotEnoughDistanceException(String errorMessage) {
        super(errorMessage);
    }
}
