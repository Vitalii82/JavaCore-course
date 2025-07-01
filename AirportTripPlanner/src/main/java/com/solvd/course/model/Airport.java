package com.solvd.course.model;

import java.util.List;

public class Airport {
    private final String code;
    private final List<Flight> flights;

    public Airport(String code, List<Flight> flights) {
        this.code = code;
        this.flights = flights;
    }

    public String getCode() { return code; }
    public List<Flight> getFlights() { return flights; }
}