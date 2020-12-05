package com.apeshko.javacore.task_01.model;

public class FlyingMachineSearchCriteria {
    private double weightStart;
    private double weightEnd;
    private double capacityStart;
    private double capacityEnd;

    public double getWeightStart() {
        return weightStart;
    }

    public void setWeightStart(double weightStart) {
        this.weightStart = weightStart;
    }

    public double getWeightEnd() {
        return weightEnd;
    }

    public void setWeightEnd(double weightEnd) {
        this.weightEnd = weightEnd;
    }

    public double getCapacityStart() {
        return capacityStart;
    }

    public void setCapacityStart(double capacityStart) {
        this.capacityStart = capacityStart;
    }

    public double getCapacityEnd() {
        return capacityEnd;
    }

    public void setCapacityEnd(double capacityEnd) {
        this.capacityEnd = capacityEnd;
    }

    public static class Builder {
        private FlyingMachineSearchCriteria flyingMachineSearchCriteria;

        public Builder() {
            flyingMachineSearchCriteria = new FlyingMachineSearchCriteria();
        }

        public Builder withWeightStart(double weightStart) {
            flyingMachineSearchCriteria.setWeightStart(weightStart);

            return this;
        };

        public Builder withWeightEnd(double weightEnd) {
            flyingMachineSearchCriteria.setWeightEnd(weightEnd);

            return this;
        };

        public Builder withCapacityStart(double capacityStart) {
            flyingMachineSearchCriteria.setCapacityStart(capacityStart);

            return this;
        };

        public Builder withCapacityEnd(double capacityEnd) {
            flyingMachineSearchCriteria.setCapacityEnd(capacityEnd);

            return this;
        };

        public FlyingMachineSearchCriteria build() {
            return flyingMachineSearchCriteria;
        }
    }
}
