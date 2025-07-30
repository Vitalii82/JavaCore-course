package com.solvd.course.model;

import java.util.List;

public class Airport {
    private String name;
    private String location;
    private List<Flight> flights;

    public Airport(String name, String location, List<Flight> flights) {
        this.name = name;
        this.location = location;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}