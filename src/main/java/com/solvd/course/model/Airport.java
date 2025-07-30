package com.solvd.course.model;

import java.util.List;

public class Airport {
    private String code;
    private String name;
    private List<Flight> flights;

    public Airport(String code, String name, List<Flight> flights) {
        this.code = code;
        this.name = name;
        this.flights = flights;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<Flight> getFlights() {
        return flights;
    }
}
