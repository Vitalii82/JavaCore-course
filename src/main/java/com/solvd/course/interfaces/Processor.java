package com.solvd.course.interfaces;
@FunctionalInterface
public interface Processor<T> {
    void process(T t);
}
