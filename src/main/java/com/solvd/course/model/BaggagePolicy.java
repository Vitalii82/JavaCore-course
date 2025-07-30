package com.solvd.course.model;

public class BaggagePolicy {
    private final double freeWeight;
    private final double feePerKg;

    public BaggagePolicy(double freeWeight, double feePerKg) {
        this.freeWeight = freeWeight;
        this.feePerKg   = feePerKg;
    }

    public double calculateOvercharge(Baggage baggage) {
        double overweight = baggage.weight() - freeWeight;
        return overweight > 0 ? overweight * feePerKg : 0.0;
    }
}
