package com.solvd.course;

import com.solvd.course.interfaces.*;
import com.solvd.course.logic.TravelService;
import com.solvd.course.model.*;
import com.solvd.course.threading.NotificationSingleton;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport from = new Airport("LAX", "Los Angeles", new ArrayList<>());
        Airport to   = new Airport("JFK", "New York", new ArrayList<>());

        List<Flight> flights = List.of(
            new Flight("1","AA123",300.0,360,"LAX","JFK"),
            new Flight("2","UA456",350.0,400,"LAX","JFK"),
            new Flight("3","DL789",250.0,420,"LAX","JFK")
        );
        from.getFlights().addAll(flights);

        Processor<Flight> proc = f -> System.out.printf("Flight %s: $%.2f%n", f.flightNumber(), f.price());
        from.getFlights().forEach(proc::process);

        Condition<Flight> cheap = f -> f.price() < 300;
        List<Flight> cheapFlights = from.getFlights().stream()
            .filter(cheap::test).collect(Collectors.toList());

        Action<Flight> act = f -> System.out.println("Cheap flight: " + f.flightNumber());
        cheapFlights.forEach(act::execute);

        Runnable task = () -> NotificationSingleton.getInstance().notifyUser("Trip logic done");
        new Thread(task, "T-1").start();
        new Thread(task, "T-2").start();

        Passenger passenger = new Passenger("John Doe");
        Baggage baggage      = new Baggage(25.0);
        TravelService svc    = new TravelService(
            new Notifiable() {
                public void sendConfirmation(String m) { System.out.println("[OK] "+m); }
                public void sendFailure(String m)      { System.err.println("[ERR] "+m); }
            });
        svc.planTrip(passenger, from, to, baggage);
    }
}
