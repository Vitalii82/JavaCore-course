package com.solvd.course;

import com.solvd.course.interfaces.Notifiable;
import com.solvd.course.logic.NotificationService;
import com.solvd.course.logic.TravelService;
import com.solvd.course.model.Airport;
import com.solvd.course.model.Baggage;
import com.solvd.course.model.Flight;
import com.solvd.course.model.Passenger;

public class Main {
    public static void main(String[] args) {
        // Create two airport instances
        Airport from = new Airport("JFK");
        Airport to = new Airport("LAX");

        // Create a flight from JFK to LAX with ID, price, and duration
        Flight flight = new Flight("FL123", from, to, 150.0, 120);
        from.addFlight(flight); // Add this flight to the departure airport

        // Create a passenger
        Passenger passenger = new Passenger("Vitalii");

        // Create baggage with specific weight
        Baggage baggage = new Baggage(25.0);

        // Set up notification service
        Notifiable notifier = new NotificationService();

        // Plan the trip using the travel service
        TravelService travelService = new TravelService(notifier);
        travelService.planTrip(passenger, from, to, baggage);
    }
}
