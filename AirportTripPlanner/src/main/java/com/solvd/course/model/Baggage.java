package com.solvd.course.model;

public class Baggage {
    private final double weight;
    public Baggage(double weight) { this.weight = weight; }
    public double getWeight() { return weight; }
    @Override
    public String toString() { return "Baggage: " + weight + "kg"; }
}