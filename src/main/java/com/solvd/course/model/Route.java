package com.solvd.course.model;

import java.util.List;

public class Route {
    private final List<Flight> flights;
    public Route(List<Flight> flights) { this.flights = flights; }
    public List<Flight> getFlights()   { return flights; }
}
