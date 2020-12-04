package com.apeshko.javacore.task_05.sevice.impl;

import com.apeshko.javacore.task_05.annotations.ProdCode;
import com.apeshko.javacore.task_05.annotations.ThisCodeSmells;
import com.apeshko.javacore.task_05.model.AirCompany;
import com.apeshko.javacore.task_05.model.FlyingMachine;
import com.apeshko.javacore.task_05.model.FlyingMachineSearchCriteria;
import com.apeshko.javacore.task_05.sevice.AirCompanySearchService;

import java.util.List;
import java.util.stream.Collectors;

public class AirCompanySearchServiceImpl implements AirCompanySearchService {
    @ThisCodeSmells(reviewer = "Max")
    private boolean isRangeMatched(double value, double rangeStart, double rangeEnd) {
        boolean isMatched = true;

        if (isMatched && rangeStart != 0) {
            isMatched = value >= rangeStart;
        }

        if (isMatched && rangeEnd != 0) {
            isMatched = value <= rangeEnd;
        }

        return isMatched;
    }

    @Override
    @ThisCodeSmells(reviewer = "Artsiom")
    @ThisCodeSmells(reviewer = "Alex")
    public List<FlyingMachine> search(AirCompany airCompany, FlyingMachineSearchCriteria flyingMachineSearchCriteria) {
        if (flyingMachineSearchCriteria == null) {
            return null;
        }

        if (airCompany == null || airCompany.getFlyingMachines() == null) {
            return null;
        }

        return airCompany
                .getFlyingMachines().stream()
                .filter(flyingMachine -> {
                    boolean isWeightMatched = isRangeMatched(
                            flyingMachine.getWeight(),
                            flyingMachineSearchCriteria.getWeightStart(),
                            flyingMachineSearchCriteria.getWeightEnd()
                    );
                    boolean isCapacityMatched = isRangeMatched(
                            flyingMachine.getCapacity(),
                            flyingMachineSearchCriteria.getCapacityStart(),
                            flyingMachineSearchCriteria.getCapacityEnd()
                    );

                    return isWeightMatched && isCapacityMatched;
                })
                .collect(Collectors.toList());
    }
}
