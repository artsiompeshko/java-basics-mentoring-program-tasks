package com.apeshko.javacore.task_01.model;

public class Airplane extends FlyingMachine {

    private AirplaneType type;

    public AirplaneType getType() {
        return type;
    }

    public void setType(AirplaneType type) {
        this.type = type;
    }

    public static class Builder {
        private Airplane airplane;

        public Builder() {
            airplane = new Airplane();
        }

        public Builder withName(String name) {
            airplane.setName(name);

            return this;
        }

        public Builder withWeight(double weight) {
            airplane.setWeight(weight);

            return this;
        };

        public Builder withWidth(double width) {
            airplane.setWidth(width);

            return this;
        }

        public Builder withHeight(double height) {
            airplane.setHeight(height);

            return this;
        }

        public Builder withCapacity(long capacity) {
            airplane.setCapacity(capacity);

            return this;
        }

        public Builder withType(AirplaneType type) {
            airplane.setType(type);

            return this;
        }

        public Airplane.Builder withLength(double length) {
            airplane.setLength(length);

            return this;
        }

        public Airplane.Builder withDistance(double distance) {
            airplane.setDistance(distance);

            return this;
        }

        public Airplane build() {
            if (airplane.getName() == null) {
                throw new IllegalStateException("Name cannot be null");
            }

            if (airplane.getWeight() == 0) {
                throw new IllegalStateException("Weight cannot be 0");
            }

            if (airplane.getWidth() == 0) {
                throw new IllegalStateException("Width cannot be 0");
            }

            if (airplane.getWeight() == 0) {
                throw new IllegalStateException("Height cannot be 0");
            }

            if (airplane.getType() == null) {
                throw new IllegalStateException("Type cannot be null");
            }

            if (airplane.getLength() == 0) {
                throw new IllegalStateException("Length cannot be 0");
            }

            if (airplane.getDistance() == 0) {
                throw new IllegalStateException("Distance cannot be 0");
            }

            return airplane;
        }
    }
}
