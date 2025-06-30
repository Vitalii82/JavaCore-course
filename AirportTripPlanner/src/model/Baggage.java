package model;

public class Baggage {
    private double weight;
    public Baggage(double weight) { this.weight = weight; }
    public double getWeight() { return weight; }
    public String toString() { return "Baggage: " + weight + "kg"; }
}