package com.solvd.course.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface EntityInfo {
    String author();
    String description() default "";
    int version() default 1;
}
