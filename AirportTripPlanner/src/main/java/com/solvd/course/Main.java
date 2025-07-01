package com.solvd.course;
import java.util.Arrays;

import com.solvd.course.interfaces.Notifiable;
import com.solvd.course.logic.NotificationService;
import com.solvd.course.logic.TravelService;
import com.solvd.course.model.Flight;
import com.solvd.course.model.Passenger;
import com.solvd.course.model.Airport;

import io.opentelemetry.api.baggage.Baggage;


public class Main {
    public static void main(String[] args) {
        Airport from = new Airport("JFK", "John F. Kennedy International Airport");
        Airport to = new Airport("LAX", "Los Angeles International Airport");

        Flight flight1 = new Flight("AA100", from, to, 300.0, 360);
        from.addFlight(flight1);

        Passenger passenger = new Passenger("Vitalii", "Svinovei");
        Baggage baggage = new Baggage(20.0);

        Notifiable notifier = new NotificationService();
        TravelService travelService = new TravelService(notifier);

        travelService.planTrip(passenger, from, to, baggage);
    }
}