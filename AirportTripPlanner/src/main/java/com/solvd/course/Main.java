package com.solvd.course;

import com.solvd.course.logic.TravelService;
import com.solvd.course.logic.NotificationService;
import com.solvd.course.model.*;
import com.solvd.course.interfaces.Notifiable;

public class Main {
    public static void main(String[] args) {
        Airport from = new Airport("JFK");
        Airport to = new Airport("LAX");

        Flight flight = new Flight("FL123", from, to, 150.0, 120);
        from.addFlight(flight);

        Passenger passenger = new Passenger("Vitalii");
        Baggage baggage = new Baggage(25.0);

        Notifiable notifier = new NotificationService();
        TravelService travelService = new TravelService(notifier);
        travelService.planTrip(passenger, from, to, baggage);
    }
}