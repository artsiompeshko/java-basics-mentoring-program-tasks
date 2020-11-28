package com.apeshko.javacore.task_03.sevice.impl;

import com.apeshko.javacore.task_03.model.AirCompany;
import com.apeshko.javacore.task_03.model.FlyingMachine;
import com.apeshko.javacore.task_03.sevice.AirCompanyService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AirCompanyServiceImpl implements AirCompanyService {
    /**
     * Returns total capacity of the air company
     * @deprecated
     * This method is no longer acceptable to compute a total capacity
     * @param airCompany
     * @return total capacity
     */
    @Override
    @Deprecated
    @SuppressWarnings({"deprecated"})
    public long getCapacity(AirCompany airCompany) {
        if (airCompany == null) {
            return 0;
        }

        return airCompany
                .getFlyingMachines()
                .stream()
                .reduce(0L, (partialCapacityResult, flyingMachine) -> partialCapacityResult + flyingMachine.getCapacity(), Long::sum);
    }

    @Override
    public double getWeight(AirCompany airCompany) {
        if (airCompany == null) {
            return 0;
        }

        return airCompany
                .getFlyingMachines()
                .stream()
                .reduce(0.0, (partialCapacityResult, flyingMachine) -> partialCapacityResult + flyingMachine.getWeight(), Double::sum);
    }

    @Override
    public List<FlyingMachine> getMachinesSortByDistance(AirCompany airCompany) {
        if (airCompany == null || airCompany.getFlyingMachines() == null) {
            return null;
        }

        return airCompany
                .getFlyingMachines()
                .stream()
                .sorted(Comparator.comparing(a -> a.getDistance()))
                .collect(Collectors.toList());
    }
}
