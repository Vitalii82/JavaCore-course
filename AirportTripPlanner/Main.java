import interfaces.Notifiable;
import logic.NotificationService;
import logic.TravelService;
import model.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Setup
        Airport kyiv = new Airport("KBP", Arrays.asList());
        Airport london = new Airport("LHR", Arrays.asList());
        Flight flight1 = new Flight(kyiv, london, 150.0, 180);
        kyiv.setFlights(Arrays.asList(flight1));

        Passenger passenger = new Passenger("Vitalii");
        Baggage baggage = new Baggage(20.0);

        Notifiable notifier = new NotificationService();
        TravelService travelService = new TravelService(notifier);

        // Run
        travelService.planTrip(passenger, kyiv, london, baggage);
    }
}
