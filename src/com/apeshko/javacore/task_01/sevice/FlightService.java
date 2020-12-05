package com.apeshko.javacore.task_01.sevice;

import com.apeshko.javacore.task_01.model.Airport;
import com.apeshko.javacore.task_01.model.FlyingMachine;

public interface FlightService {
    void makeFlight(Airport from, Airport to, FlyingMachine flyingMachine);
}
