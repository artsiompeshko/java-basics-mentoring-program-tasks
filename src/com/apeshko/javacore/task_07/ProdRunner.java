package com.apeshko.javacore.task_07;

import com.apeshko.javacore.task_06.ClassesLoader;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProdRunner {
    public static Annotation getAnnotation(Annotation[] annotations, String annotationName) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().getName().contains(annotationName)) {
                return annotation;
            }
        }

        return null;
    }

    public static void main(String... args) {
        ClassLoader classLoader = com.apeshko.javacore.task_06.Application.class.getClassLoader();

        Iterable<Class> classes = new ClassesLoader().getClasses(classLoader, "com.apeshko.javacore.task_05");

        for (Class clazz : classes) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (getAnnotation(method.getAnnotations(), "ProdCode") != null) {
                    try {
                        method.invoke(null);
                    } catch (IllegalAccessException e) {
                        System.err.println(e);
                    } catch (InvocationTargetException e) {
                        System.err.println(e);
                    }
                }
            }
        }
    }
}
