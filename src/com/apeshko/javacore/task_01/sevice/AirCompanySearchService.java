package com.apeshko.javacore.task_01.sevice;

import com.apeshko.javacore.task_01.model.AirCompany;
import com.apeshko.javacore.task_01.model.FlyingMachine;
import com.apeshko.javacore.task_01.model.FlyingMachineSearchCriteria;

import java.util.List;

public interface AirCompanySearchService {
    List<FlyingMachine> search(AirCompany airCompany, FlyingMachineSearchCriteria flyingMachineSearchCriteria);
}
