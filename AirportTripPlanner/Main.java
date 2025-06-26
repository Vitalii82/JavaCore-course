package AirportTripPlanner;
import model.*;
import logic.*;

import java.time.LocalTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Airline skyFly = new Airline("SkyFly");

        Airport kyiv = new Airport("IEV", "Kyiv", null);
        Airport berlin = new Airport("TXL", "Berlin", null);

        Flight f1 = new Flight(kyiv, berlin, skyFly, 120.5,
                LocalTime.of(9, 0), LocalTime.of(11, 0));
        Flight f2 = new Flight(kyiv, berlin, skyFly, 90.0,
                LocalTime.of(13, 0), LocalTime.of(15, 0));
        kyiv.setFlights(Arrays.asList(f1, f2));

        Passenger p = new Passenger("Vitalii");
        Baggage baggage = new Baggage(28.5, true);

        NotificationService notifier = new NotificationService();
        TravelService travelService = new TravelService(notifier);

        travelService.planTrip(p, kyiv, berlin, baggage);
    }
}
