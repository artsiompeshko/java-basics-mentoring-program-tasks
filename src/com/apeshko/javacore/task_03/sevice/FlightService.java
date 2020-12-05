package com.apeshko.javacore.task_03.sevice;

import com.apeshko.javacore.task_03.model.Airport;
import com.apeshko.javacore.task_03.model.FlyingMachine;

public interface FlightService {
    void makeFlight(Airport from, Airport to, FlyingMachine flyingMachine);
}
