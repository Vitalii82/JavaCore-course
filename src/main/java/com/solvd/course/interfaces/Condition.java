
package com.solvd.course.interfaces;

@FunctionalInterface
public interface Condition<T> {
    boolean test(T t);
}
