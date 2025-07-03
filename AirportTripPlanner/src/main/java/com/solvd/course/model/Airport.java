package com.solvd.course.model;

import java.util.ArrayList;
import java.util.List;

public class Airport {
    private final String code;
    private final List<Flight> flights;

    public Airport(String code) {
        this.code = code;
        this.flights = new ArrayList<>();
    }

    public String getCode() {
        return code;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
    }
}
