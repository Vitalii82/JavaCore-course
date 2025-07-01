package model;

import interfaces.Identifiable;

public class Airline implements Identifiable {
    private String name;

    public Airline(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String getCode() {
        return name.substring(0, 3).toUpperCase();
    }

    @Override
    public String toString() {
        return "Airline: " + name;
    }
}
