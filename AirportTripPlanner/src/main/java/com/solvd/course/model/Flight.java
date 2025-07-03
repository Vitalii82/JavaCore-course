package com.solvd.course.model;

import com.solvd.course.interfaces.Flyable;
import com.solvd.course.interfaces.HasDuration;
import com.solvd.course.interfaces.Payable;

public class Flight implements Flyable, Payable, HasDuration {
    private final String id;
    private final Airport from;
    private final Airport to;
    private final double price;
    private final int durationInMinutes;

    public Flight(String id, Airport from, Airport to, double price, int durationInMinutes) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.durationInMinutes = durationInMinutes;
    }

    public String getId() {
        return id;
    }

    public Airport getFrom() {
        return from;
    }

    public Airport getTo() {
        return to;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    @Override
    public void fly() {
        System.out.println("Flying from " + from.getCode() + " to " + to.getCode());
    }

    @Override
    public boolean startTurboEngine( {
        System.out.println("Turbo engine started for flight " + id);
        return true;
    }

    @Override
    public double calculatePrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Flight %s: %s → %s ($%.2f, %d mins)", id, from.getCode(), to.getCode(), price, durationInMinutes);
    }
}
