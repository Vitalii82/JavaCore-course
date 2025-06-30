package model;

import java.util.List;

public class Route {
    private List<Flight> flights;
    public Route(List<Flight> flights) { this.flights = flights; }
    public List<Flight> getFlights() { return flights; }
    public String toString() { return flights.toString(); }
}