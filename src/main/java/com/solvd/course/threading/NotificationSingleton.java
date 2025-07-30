package com.solvd.course.threading;

public class NotificationSingleton {
    private static NotificationSingleton instance;

    private NotificationSingleton() {}

    public static synchronized NotificationSingleton getInstance() {
        if (instance == null) {
            instance = new NotificationSingleton();
        }
        return instance;
    }

    public void notifyUser(String message) {
        System.out.println(Thread.currentThread().getName() + " -> " + message);
    }
}