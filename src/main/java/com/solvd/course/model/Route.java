package com.solvd.course.model;

import java.util.List;

public class Route<T extends Flight> {
    private final List<T> flights;

    public Route(List<T> flights) {
        this.flights = flights;
    }

    public List<T> getFlights() {
        return flights;
    }

    public double getTotalPrice() {
        return flights.stream().mapToDouble(Flight::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Route: " + flights;
    }
}