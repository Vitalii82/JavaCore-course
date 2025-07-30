package com.solvd.course.logic;

import com.solvd.course.model.Flight;
import com.solvd.course.model.Route;
import com.solvd.course.model.Airport;
import exceptions.NoFlightsFoundException;
import exceptions.RoutePlanningException;

import java.util.Comparator;

public class TripPlanner {
    public Route findBestRoute(Airport from, Airport to) throws NoFlightsFoundException, RoutePlanningException {
        var flights = from.getFlights().stream()
            .filter(f -> f.to().equals(to.getName()))
            .toList();

        if (flights.isEmpty()) {
            throw new NoFlightsFoundException("No flights available");
        }

        Flight best = flights.stream()
            .min(Comparator.comparingDouble(f -> f.price() + f.duration()))
            .orElseThrow(() -> new RoutePlanningException("Unable to choose best flight"));

        return new Route(java.util.List.of(best));
    }
}
