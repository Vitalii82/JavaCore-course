package com.solvd.course.model;

import com.solvd.course.interfaces.HasDuration;
import com.solvd.course.interfaces.Payable;

public class Flight implements HasDuration, Payable {
    private final Airport from;
    private final Airport to;
    private final double price;
    private final int durationMinutes;

    public Flight(Airport from, Airport to, double price, int durationMinutes) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.durationMinutes = durationMinutes;
    }

    public Airport getFrom() { return from; }
    public Airport getTo() { return to; }
    @Override
    public double getPrice() { return price; }
    @Override
    public int getDurationInMinutes() { return durationMinutes; }
}