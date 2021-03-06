package com.apeshko.javacore.task_01.sevice;

import com.apeshko.javacore.task_01.model.AirCompany;
import com.apeshko.javacore.task_01.model.FlyingMachine;

import java.util.List;

public interface AirCompanyService {
    long getCapacity(AirCompany airCompany);
    double getWeight(AirCompany airCompany);
    List<FlyingMachine> getMachinesSortByDistance(AirCompany airCompany);
}
