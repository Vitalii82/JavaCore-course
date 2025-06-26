package model;

import interfaces.Payable;

public class Ticket implements Payable {
    private Passenger passenger;
    private Flight flight;

    public Ticket(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public Flight getFlight() { return flight; }
    public void setFlight(Flight flight) { this.flight = flight; }

    @Override
    public double getPrice() {
        return flight.getPrice();
    }

    @Override
    public String toString() {
        return "Ticket for " + passenger.getName() + ": " + flight;
    }
}
