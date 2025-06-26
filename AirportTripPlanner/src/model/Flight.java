package model;

import interfaces.Flyable;
import interfaces.HasDuration;
import interfaces.Payable;

import java.time.LocalTime;

public class Flight extends TransportEntity implements Flyable, Payable, HasDuration {
    private Airline airline;
    private double price;
    private LocalTime departure;
    private LocalTime arrival;
    private boolean flying;

    public Flight(Airport from, Airport to, Airline airline, double price, LocalTime departure, LocalTime arrival) {
        super(from, to);
        this.airline = airline;
        this.price = price;
        this.departure = departure;
        this.arrival = arrival;
    }

    public Airline getAirline() { return airline; }
    public void setAirline(Airline airline) { this.airline = airline; }

    @Override
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public LocalTime getDeparture() { return departure; }
    public void setDeparture(LocalTime departure) { this.departure = departure; }

    public LocalTime getArrival() { return arrival; }
    public void setArrival(LocalTime arrival) { this.arrival = arrival; }

    @Override
    public long getDurationInMinutes() {
        return java.time.Duration.between(departure, arrival).toMinutes();
    }

    @Override
    public boolean startTurboEngine() {
        flying = true;
        return true;
    }

    @Override
    public boolean isFlying() {
        return flying;
    }

    @Override
    public String getTransportType() {
        return "Flight";
    }

    @Override
    public String toString() {
        return getTransportType() + ": " + getFrom().getCode() + " -> " + getTo().getCode() +
               ", Airline: " + airline.getName() +
               ", Price: $" + price +
               ", Time: " + getDurationInMinutes() + " mins";
    }
}
