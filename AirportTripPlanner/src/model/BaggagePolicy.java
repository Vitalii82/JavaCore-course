package model;

public class BaggagePolicy {
    private double weightLimit;
    private double overchargePerKg;

    public BaggagePolicy(double weightLimit, double overchargePerKg) {
        this.weightLimit = weightLimit;
        this.overchargePerKg = overchargePerKg;
    }

    public double calculateOvercharge(Baggage baggage) {
        if (baggage.getWeight() <= weightLimit) return 0;
        return (baggage.getWeight() - weightLimit) * overchargePerKg;
    }
}
