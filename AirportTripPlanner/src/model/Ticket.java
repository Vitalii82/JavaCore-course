package model;

public class Ticket {
    private Passenger passenger;
    private Flight flight;

    public Ticket(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public double getPrice() { return flight.getPrice(); }
    public String toString() { return passenger.getName() + " - " + flight.getFrom().getCode() + " -> " + flight.getTo().getCode(); }
}