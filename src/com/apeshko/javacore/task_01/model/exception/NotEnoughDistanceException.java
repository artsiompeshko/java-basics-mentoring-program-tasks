package com.apeshko.javacore.task_01.model.exception;

public class NotEnoughDistanceException extends FlightException {
    public NotEnoughDistanceException(String errorMessage) {
        super(errorMessage);
    }
}
