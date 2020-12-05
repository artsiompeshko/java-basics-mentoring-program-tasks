package com.apeshko.javacore.task_06;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Application {
    private static Annotation getAnnotation(Annotation[] annotations, String annotationName) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().getName().contains(annotationName)) {
                return annotation;
            }
        }

        return null;
    }

    private static String getReviewer(Annotation annotation) {
        try {
            if (annotation.annotationType().getName().contains("ThisCodeSmellsContainer")) {
                String reviewers = "";
                for (Annotation innerAnnotation : (Annotation[]) annotation.getClass().getMethod("value").invoke(annotation)) {
                    reviewers += getReviewer(innerAnnotation) + " ";
                }

                return reviewers;
            }

            if (annotation.annotationType().getName().contains("ThisCodeSmells")) {
                return (String) annotation.getClass().getMethod("reviewer").invoke(annotation);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String... args) {
        ClassLoader classLoader = Application.class.getClassLoader();

        Iterable<Class> classes = new ClassesLoader().getClasses(classLoader, "com.apeshko.javacore.task_05");

        for (Class clazz : classes) {
            if (getAnnotation(clazz.getAnnotations(), "ThisCodeSmells") != null) {
                System.out.println("Class " + clazz.getName() + " " + getReviewer(getAnnotation(clazz.getAnnotations(), "ThisCodeSmells")));
            }

            for (Field field : clazz.getDeclaredFields()) {
                if (getAnnotation(field.getAnnotations(), "ThisCodeSmells") != null) {
                    System.out.println("Field " + field.getName() + " " + getReviewer(getAnnotation(field.getAnnotations(), "ThisCodeSmells")));
                }
            }

            for (Method method : clazz.getDeclaredMethods()) {
                if (getAnnotation(method.getAnnotations(), "ThisCodeSmells") != null) {
                    System.out.println("Method " + method.getName() + " " + getReviewer(getAnnotation(method.getAnnotations(), "ThisCodeSmells")));
                }
            }
        }
    }
}
