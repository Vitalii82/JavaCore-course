package com.solvd.course;

import com.solvd.course.model.Airport;
import com.solvd.course.model.Flight;
import com.solvd.course.threading.NotificationSingleton;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Airport from = new Airport("Kyiv Boryspil", "Kyiv", null);
        Airport to = new Airport("Lviv Danylo Halytskyi", "Lviv", null);

        List<Flight> flights = Arrays.asList(
                new Flight("F1", "PS123", 100.0, 60, from.getName(), to.getName()),
                new Flight("F2", "PS456", 120.0, 70, from.getName(), to.getName()),
                new Flight("F3", "PS789", 90.0, 80, from.getName(), to.getName())
        );

        flights.forEach(f -> System.out.printf("Flight %s from %s to %s: $%.2f, %d min%n",
                f.flightNumber(), f.from(), f.to(), f.price(), f.duration()));

        // Threaded notification demo
        Runnable task = () -> {
            NotificationSingleton notifier = NotificationSingleton.getInstance();
            notifier.notifyUser("Processing flight data...");
        };

        Thread t1 = new Thread(task, "Worker-1");
        Thread t2 = new Thread(task, "Worker-2");
        Thread t3 = new Thread(task, "Worker-3");

        t1.start();
        t2.start();
        t3.start();
    }
}