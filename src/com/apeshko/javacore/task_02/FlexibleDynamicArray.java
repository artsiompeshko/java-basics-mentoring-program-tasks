package com.apeshko.javacore.task_02;

import java.lang.reflect.Array;

public class FlexibleDynamicArray<T> {
    private T[] items;
    private int size;
    private Class<T[]> type;

    public FlexibleDynamicArray(Class<T[]> type, int initialSize) {
        this.size = 0;
        this.type = type;
        this.items = type.cast(Array.newInstance(type.getComponentType(), initialSize));
    }

    private void extend() {
        T[] nextItems = type.cast(Array.newInstance(type.getComponentType(), size * 2));

        for (int i = 0; i < size; i += 1) {
            nextItems[i] = items[i];
        }

        this.items = nextItems;
    }

    private void reduce() {
        T[] nextItems = type.cast(Array.newInstance(type.getComponentType(), (int) Math.floor(items.length / 2)));

        for (int i = 0; i < size; i += 1) {
            nextItems[i] = items[i];
        }

        this.items = nextItems;
    }

    public int add(T item) {
        // extend array if needed
        if (items.length == size) {
            this.extend();
        }

        items[size++] = item;

        return size - 1;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        return items[index];
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }

        T itemToRemove = items[index];

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
        String itemsString = "";

        for (int i = 0; i < size; i++) {
            T item = items[i];
            itemsString += item.toString() + ", ";
        }

        return "items: {" + itemsString + "}, size: " + size;
    }
}
