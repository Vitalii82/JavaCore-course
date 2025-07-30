package com.solvd.course.model;

public class BaggagePolicy {
    private final double freeWeight;
    private final double feePerKg;

    public BaggagePolicy(double freeWeight, double feePerKg) {
        this.freeWeight = freeWeight;
        this.feePerKg   = feePerKg;
    }

    /**
     * Calculates the overweight fee.
     * @param baggage the baggage record
     * @return the excess‐weight fee, or 0 if within free allowance
     */
    public double calculateOvercharge(Baggage baggage) {
        double overweight = baggage.weight() - freeWeight;
        return overweight > 0 ? overweight * feePerKg : 0.0;
    }
}
