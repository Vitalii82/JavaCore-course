package com.solvd.course.threading;

public class ThreadLoggerSingleton {
    private static ThreadLoggerSingleton instance;

    private ThreadLoggerSingleton() {
    }

    public static synchronized ThreadLoggerSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadLoggerSingleton();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}
