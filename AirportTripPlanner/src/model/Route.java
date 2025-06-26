package model;

import interfaces.HasDuration;
import interfaces.Payable;

import java.util.List;

public class Route implements Payable, HasDuration {
    private List<Flight> flights;

    public Route(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight> getFlights() { return flights; }
    public void setFlights(List<Flight> flights) { this.flights = flights; }

    @Override
    public double getPrice() {
        return flights.stream().mapToDouble(Flight::getPrice).sum();
    }

    @Override
    public long getDurationInMinutes() {
        return flights.stream().mapToLong(Flight::getDurationInMinutes).sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Route:\n");
        for (Flight flight : flights) {
            sb.append(flight).append("\n");
        }
        sb.append("Total: $").append(getPrice()).append(", ").append(getDurationInMinutes()).append(" mins");
        return sb.toString();
    }
}
