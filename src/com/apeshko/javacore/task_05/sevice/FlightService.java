package com.apeshko.javacore.task_05.sevice;

import com.apeshko.javacore.task_05.model.Airport;
import com.apeshko.javacore.task_05.model.FlyingMachine;

public interface FlightService {
    void makeFlight(Airport from, Airport to, FlyingMachine flyingMachine);
}
