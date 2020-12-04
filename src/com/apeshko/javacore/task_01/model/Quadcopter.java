package com.apeshko.javacore.task_01.model;

public class Quadcopter extends FlyingMachine {

    private QuadcopterType type;

    public QuadcopterType getType() {
        return type;
    }

    public void setType(QuadcopterType type) {
        this.type = type;
    }

    public static class Builder {
        private Quadcopter quadcopter;

        public Builder() {
            quadcopter = new Quadcopter();
        }

        public Builder withName(String name) {
            quadcopter.setName(name);

            return this;
        }

        public Builder withWeight(double weight) {
            quadcopter.setWeight(weight);

            return this;
        }

        ;

        public Builder withWidth(double width) {
            quadcopter.setWidth(width);

            return this;
        }

        public Builder withHeight(double height) {
            quadcopter.setHeight(height);

            return this;
        }

        public Builder withCapacity(long capacity) {
            quadcopter.setCapacity(capacity);

            return this;
        }

        public Builder withType(QuadcopterType type) {
            quadcopter.setType(type);

            return this;
        }

        public Quadcopter.Builder withLength(double length) {
            quadcopter.setLength(length);

            return this;
        }

        public Quadcopter.Builder withDistance(double distance) {
            quadcopter.setDistance(distance);

            return  this;
        }

        public Quadcopter build() {
            if (quadcopter.getName() == null) {
                throw new IllegalStateException("Name cannot be null");
            }

            if (quadcopter.getWeight() == 0) {
                throw new IllegalStateException("Weight cannot be 0");
            }

            if (quadcopter.getWidth() == 0) {
                throw new IllegalStateException("Width cannot be 0");
            }

            if (quadcopter.getWeight() == 0) {
                throw new IllegalStateException("Height cannot be 0");
            }

            if (quadcopter.getType() == null) {
                throw new IllegalStateException("Type cannot be null");
            }

            if (quadcopter.getLength() == 0) {
                throw new IllegalStateException("Length cannot be 0");
            }

            if (quadcopter.getDistance() == 0) {
                throw new IllegalStateException("Distance cannot be 0");
            }

            return quadcopter;
        }
    }
}
