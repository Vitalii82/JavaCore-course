package com.solvd.course;

import com.solvd.course.model.Airport;
import com.solvd.course.model.Flight;
import com.solvd.course.logic.TravelService;
import com.solvd.course.interfaces.Action;
import com.solvd.course.interfaces.Condition;
import com.solvd.course.interfaces.Processor;
import com.solvd.course.threading.NotificationSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport from = new Airport("LAX", "Los Angeles", new ArrayList<>());
        Airport to = new Airport("JFK", "New York", new ArrayList<>());

        List<Flight> flights = List.of(
            new Flight("1","AA123",300.0,360,"LAX","JFK"),
            new Flight("2","UA456",350.0,400,"LAX","JFK"),
            new Flight("3","DL789",250.0,420,"LAX","JFK")
        );
        from.getFlights().addAll(flights);

        Processor<Flight> proc = f -> System.out.println("Flight: " + f.flightNumber() + " Price: " + f.price());
        from.getFlights().forEach(proc::process);

        Condition<Flight> cond = f -> f.price() < 300;
        List<Flight> cheap = from.getFlights().stream().filter(cond::test).collect(Collectors.toList());

        Action<Flight> act = f -> System.out.println("Cheap flight: " + f.flightNumber());
        cheap.forEach(act::execute);

        Runnable r = () -> NotificationSingleton.getInstance().notifyUser("Processing done");
        new Thread(r,"T1").start();
        new Thread(r,"T2").start();
    }
}
