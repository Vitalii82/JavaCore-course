package com.solvd.course.threading;

public class NotificationSingleton {
    private static NotificationSingleton instance;
    private NotificationSingleton() {}
    public static synchronized NotificationSingleton getInstance() {
        if (instance == null) instance = new NotificationSingleton();
        return instance;
    }
    public void notifyUser(String msg) {
        System.out.printf("[%s] %s%n", Thread.currentThread().getName(), msg);
    }
}
