package com.apeshko.javacore.task_05.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ThisCodeSmellsContainer {
    ThisCodeSmells[] value();
}