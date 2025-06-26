package logic;

import model.*;
import interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class TripPlanner {

    public Route findBestRoute(Airport from, Airport to) {
        List<Flight> directFlights = new ArrayList<>();
        for (Flight flight : from.getFlights()) {
            if (flight.getTo().equals(to)) {
                directFlights.add(flight);
            }
        }

        if (directFlights.isEmpty()) return null;

        Flight bestFlight = directFlights.stream()
            .min((f1, f2) -> Double.compare(
                f1.getPrice() + f1.getDurationInMinutes(),
                f2.getPrice() + f2.getDurationInMinutes()
            )).orElse(null);

        return new Route(List.of(bestFlight));
    }
}
