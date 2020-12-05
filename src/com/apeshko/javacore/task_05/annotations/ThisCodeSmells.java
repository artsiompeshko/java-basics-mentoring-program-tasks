package com.apeshko.javacore.task_05.annotations;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ThisCodeSmellsContainer.class)
public @interface ThisCodeSmells {
    String reviewer() default "unknown";
}
