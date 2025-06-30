import model.*;
import logic.*;
import interfaces.*;

import java.util.Arrays;

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