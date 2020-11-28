package com.apeshko.javacore.task_01.model;

public class Helicopter extends FlyingMachine {
    public static enum Type {
        MILITARY,
        ENTERTAINMENT,
        HEALTH,
    }

    private Helicopter.Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static class Builder {
        private Helicopter helicopter;

        public Builder() {
            helicopter = new Helicopter();
        }

        public Builder withName(String name) {
            helicopter.setName(name);

            return this;
        }

        public Builder withWeight(double weight) {
            helicopter.setWeight(weight);

            return this;
        }

        ;

        public Builder withWidth(double width) {
            helicopter.setWidth(width);

            return this;
        }

        public Builder withHeight(double height) {
            helicopter.setHeight(height);

            return this;
        }

        public Builder withCapacity(long capacity) {
            helicopter.setCapacity(capacity);

            return this;
        }

        public Builder withType(Helicopter.Type type) {
            helicopter.setType(type);

            return this;
        }

        public Builder withLength(double length) {
            helicopter.setLength(length);

            return this;
        }

        public Builder withDistance(double distance) {
            helicopter.setDistance(distance);

            return this;
        }

        public Helicopter build() {
            if (helicopter.getName() == null) {
                throw new IllegalStateException("Name cannot be null");
            }

            if (helicopter.getWeight() == 0) {
                throw new IllegalStateException("Weight cannot be 0");
            }

            if (helicopter.getWidth() == 0) {
                throw new IllegalStateException("Width cannot be 0");
            }

            if (helicopter.getWeight() == 0) {
                throw new IllegalStateException("Height cannot be 0");
            }

            if (helicopter.getType() == null) {
                throw new IllegalStateException("Type cannot be null");
            }

            if (helicopter.getLength() == 0) {
                throw new IllegalStateException("Length cannot be 0");
            }

            if (helicopter.getDistance() == 0) {
                throw new IllegalStateException("Distance cannot be 0");
            }

            return helicopter;
        }
    }
}
