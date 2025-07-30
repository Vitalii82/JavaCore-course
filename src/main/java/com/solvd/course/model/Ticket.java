package com.solvd.course.model;

public class Ticket {
    private final Passenger passenger;
    private final Flight flight;

    public Ticket(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public double price() {
        return flight.price();
    }
}
