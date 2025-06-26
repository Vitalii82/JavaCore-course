package model;

public class Baggage {
    private double weight;
    private boolean isChecked;

    public Baggage(double weight, boolean isChecked) {
        this.weight = weight;
        this.isChecked = isChecked;
    }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public boolean isChecked() { return isChecked; }
    public void setChecked(boolean checked) { isChecked = checked; }

    @Override
    public String toString() {
        return "Baggage{" + "weight=" + weight + ", checked=" + isChecked + '}';
    }
}
