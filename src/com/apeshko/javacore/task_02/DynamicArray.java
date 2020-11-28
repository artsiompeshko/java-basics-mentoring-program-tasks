package com.apeshko.javacore.task_02;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DynamicArray {
    private double[] items;
    private int size;

    public DynamicArray(int initialSize) {
        size = 0;
        items = new double[initialSize];
    }

    private void extend() {
        double[] nextItems = new double[size * 2];

        for (int i = 0; i < size; i += 1) {
            nextItems[i] = items[i];
        }

        this.items = nextItems;
    }

    private void reduce() {
        double[] nextItems = new double[(int) Math.floor(items.length / 2)];

        for (int i = 0; i < size; i += 1) {
            nextItems[i] = items[i];
        }

        this.items = nextItems;
    }

    public int add(double item) {
        // extend array if needed
        if (items.length == size) {
            this.extend();
        }

        items[size++] = item;

        return size - 1;
    }

    public double get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        return items[index];
    }

    public double removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        double itemToRemove = items[index];

        for (int i = index; i < size - 1; i++) {
            items[i] = items[i + 1];
        }

        size -= 1;

        // reduce array if needed
        if ((items.length / size) >= 2) {
            this.reduce();
        }

        return itemToRemove;
    }

    @Override
    public String toString() {
        String itemsString = Arrays.stream(Arrays.copyOfRange(items, 0, size))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));

        return "items: {" + itemsString + "}, size: " + size;
    }
}
