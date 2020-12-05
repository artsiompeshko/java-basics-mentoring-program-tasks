package com.apeshko.javacore.task_05.sevice.impl;

import com.apeshko.javacore.task_05.model.Airport;
import com.apeshko.javacore.task_05.model.FlyingMachine;
import com.apeshko.javacore.task_05.model.exception.NotEnoughDistanceException;
import com.apeshko.javacore.task_05.sevice.FlightService;

public class FlightServiceImpl implements FlightService {
    @Override
    public void makeFlight(Airport from, Airport to, FlyingMachine flyingMachine) throws NotEnoughDistanceException {
        double flightDistance = Math.hypot(Math.abs(to.getLongitude() - from.getLongitude()), Math.abs(to.getLatitude() - from.getLatitude()));
        double machineDistance = flyingMachine.getDistance();

        if ((machineDistance - flightDistance) < 0) {
            throw new NotEnoughDistanceException("Flying machine " + flyingMachine.getName()
                    + " with maximum distance " + machineDistance
                    + " can not flight from " + from.getName() + " to " + to.getName()
                    + " since distance between airports equals " + flightDistance);
        }

        System.out.println("Departure of the " + flyingMachine.getName() + " from " + from.getName());
        System.out.println("Flying...");
        System.out.println(flyingMachine.getName() + " arrived at " + to.getName());
    }
}
