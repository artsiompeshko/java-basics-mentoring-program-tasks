package com.apeshko.javacore.task_03.sevice;

import com.apeshko.javacore.task_03.model.AirCompany;
import com.apeshko.javacore.task_03.model.FlyingMachine;
import com.apeshko.javacore.task_03.model.FlyingMachineSearchCriteria;

import java.util.List;

public interface AirCompanySearchService {
    List<FlyingMachine> search(AirCompany airCompany, FlyingMachineSearchCriteria flyingMachineSearchCriteria);
}
