package com.solvd.course;

import com.solvd.course.logic.NotificationService;
import com.solvd.course.logic.TravelService;
import com.solvd.course.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create flights list for airports
        List<Flight> flightsFromA = new ArrayList<>();
        List<Flight> flightsFromB = new ArrayList<>();

        // Create airports
        Airport from = new Airport("KBP", flightsFromA);
        Airport to = new Airport("LWO", flightsFromB);

        // Create flight and assign to departure airport
        Flight flight = new Flight("FL123", from, to, 150.0, 85);
        from.getFlights().add(flight);

        // Create passenger and baggage
        Passenger passenger = new Passenger("Vitalii Svinovei");
        Baggage baggage = new Baggage(22.0, 8.0); // within limits

        // Create TravelService with notification
        NotificationService notifier = new NotificationService();
        TravelService travelService = new TravelService(notifier);

        // Plan the trip
        travelService.planTrip(passenger, from, to, baggage);
    }
}
