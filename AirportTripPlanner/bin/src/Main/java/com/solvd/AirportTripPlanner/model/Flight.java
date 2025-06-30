package model;

import interfaces.HasDuration;
import interfaces.Payable;

public class Flight implements HasDuration, Payable {
    private Airport from;
    private Airport to;
    private double price;
    private int durationMinutes;

    public Flight(Airport from, Airport to, double price, int durationMinutes) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public Airport getFrom() { return from; }
    public Airport getTo() { return to; }
    public double getPrice() { return price; }
    public int getDurationInMinutes() { return durationMinutes; }
}