package model;

import java.util.List;

public class Airport extends Location {
    private List<Flight> flights;

    public Airport(String code, String name, List<Flight> flights) {
        super(code, name);
        this.flights = flights;
    }

    public List<Flight> getFlights() { return flights; }
    public void setFlights(List<Flight> flights) { this.flights = flights; }

    @Override
    public String getLocationType() {
        return "Airport";
    }
}
