package model;

public class Passenger extends Person {
    public Passenger(String name) {
        super(name);
    }

    @Override
    public String getRole() {
        return "Passenger";
    }
}
