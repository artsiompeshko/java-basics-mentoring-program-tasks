package com.apeshko.javacore.task_02;

public class Application {
    public static void dynamicArrayTest() {
        DynamicArray dynamicArray = new DynamicArray(2);

        System.out.println(dynamicArray);

        dynamicArray.add(1);
        dynamicArray.add(2);

        System.out.println(dynamicArray);

        dynamicArray.add(3);
        dynamicArray.add(4);

        System.out.println(dynamicArray);

        dynamicArray.add(5);
        System.out.println(dynamicArray);

        System.out.println(dynamicArray.get(0));
        System.out.println(dynamicArray.get(4));

        dynamicArray.removeAt(0);
        dynamicArray.removeAt(3);
        System.out.println(dynamicArray);
    }

    public static void flexibleDynamicArrayTest() {
        FlexibleDynamicArray<String> flexibleDynamicArray = new FlexibleDynamicArray<String>(String[].class, 2);

        System.out.println(flexibleDynamicArray);

        flexibleDynamicArray.add("1");
        flexibleDynamicArray.add("2");

        System.out.println(flexibleDynamicArray);

        flexibleDynamicArray.add("3");
        flexibleDynamicArray.add("4");

        System.out.println(flexibleDynamicArray);

        flexibleDynamicArray.add("5");
        System.out.println(flexibleDynamicArray);

        System.out.println(flexibleDynamicArray.get(0));
        System.out.println(flexibleDynamicArray.get(4));

        flexibleDynamicArray.removeAt(0);
        flexibleDynamicArray.removeAt(3);
        System.out.println(flexibleDynamicArray);
    }

    public static void main(String... args) {
        System.out.println("DynamicArray test:");
        dynamicArrayTest();

        System.out.println("FlexibleDynamicArray test:");
        flexibleDynamicArrayTest();
    }
}
