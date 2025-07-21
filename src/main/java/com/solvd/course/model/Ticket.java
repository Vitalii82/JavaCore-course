package com.solvd.course.model;

public class Ticket<T extends Passenger> {
    private final T passenger;
    private final Flight flight;

    public Ticket(T passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public T getPassenger() {
        return passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public double getPrice() {
        return flight.getPrice();
    }

    @Override
    public String toString() {
        return passenger.getName() + " - " + flight.toString();
    }
}