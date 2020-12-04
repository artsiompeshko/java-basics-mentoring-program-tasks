package com.apeshko.javacore.task_05.model;

import com.apeshko.javacore.task_05.annotations.UseArrayList;
import com.apeshko.javacore.task_05.annotations.UseStackOnly;

import java.util.List;

public class AirCompany {
    @UseStackOnly
    private String name;
    @UseArrayList
    private List<FlyingMachine> flyingMachines;

    public AirCompany(String name, List<FlyingMachine> flyingMachines) {
        this.name = name;
        this.flyingMachines = flyingMachines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FlyingMachine> getFlyingMachines() {
        return flyingMachines;
    }

    public void setFlyingMachines(List<FlyingMachine> flyingMachines) {
        this.flyingMachines = flyingMachines;
    }
}
