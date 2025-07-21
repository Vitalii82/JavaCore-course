package com.solvd.course.model;

public class BaggagePolicy {
    private final double freeWeight;
    private final double overchargePerKg;

    public BaggagePolicy(double freeWeight, double overchargePerKg) {
        this.freeWeight = freeWeight;
        this.overchargePerKg = overchargePerKg;
    }

    public double calculateOvercharge(Baggage baggage) {
        double excess = baggage.getWeight() - freeWeight;
        return excess > 0 ? excess * overchargePerKg : 0;
    }
}