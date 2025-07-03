package com.solvd.course.model;

public class Passenger {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    public Passenger(String firstName, String lastName) {
        this.name = firstName + " " + lastName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
