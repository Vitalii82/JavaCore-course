
package com.solvd.course;

import com.solvd.course.interfaces.Action;
import com.solvd.course.interfaces.Condition;
import com.solvd.course.interfaces.Processor;
import com.solvd.course.logic.TravelService;
import com.solvd.course.model.*;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport from = new Airport("LAX", "Los Angeles International Airport");
        Airport to = new Airport("JFK", "John F. Kennedy International Airport");

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight("AA123", from, to, 300.0, 360));
        flights.add(new Flight("UA456", from, to, 350.0, 400));
        flights.add(new Flight("DL789", from, to, 250.0, 420));
        from.setFlights(flights);

        Processor<Flight> flightProcessor = f -> System.out.println("Flight " + f.getFlightNumber() + " costs $" + f.getPrice());
        from.getFlights().forEach(flightProcessor::process);

        Condition<Flight> cheapFlight = f -> f.getPrice() < 300;
        List<Flight> cheapFlights = from.getFlights().stream()
            .filter(cheapFlight::test)
            .collect(Collectors.toList());

        System.out.println("\nCheap Flights:");
        cheapFlights.forEach(f -> System.out.println(f.getFlightNumber() + " - $" + f.getPrice()));

        Action<Flight> notify = f -> System.out.println("Notification: Flight " + f.getFlightNumber() + " is available.");
        cheapFlights.forEach(notify::execute);

        Passenger passenger = new Passenger("John Doe");
        Baggage baggage = new Baggage(18.5);
        TravelService travelService = new TravelService();
        travelService.planTrip(passenger, from, to, baggage);

        TransportEntity entity = new TransportEntity("TX999", "Cargo Jet");
        Annotation[] annotations = entity.getClass().getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof com.solvd.course.annotations.EntityInfo info) {
                System.out.println("\nAnnotation Info: Author = " + info.author() + ", Description = " + info.description());
            }
        }
    }
}
