
package com.solvd.course.interfaces;

@FunctionalInterface
public interface Action<T> {
    void execute(T t);
}
