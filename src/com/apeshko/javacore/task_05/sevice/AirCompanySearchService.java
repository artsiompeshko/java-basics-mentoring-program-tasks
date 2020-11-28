package com.apeshko.javacore.task_05.sevice;

import com.apeshko.javacore.task_05.model.AirCompany;
import com.apeshko.javacore.task_05.model.FlyingMachine;
import com.apeshko.javacore.task_05.model.FlyingMachineSearchCriteria;

import java.util.List;

public interface AirCompanySearchService {
    List<FlyingMachine> search(AirCompany airCompany, FlyingMachineSearchCriteria flyingMachineSearchCriteria);
}
