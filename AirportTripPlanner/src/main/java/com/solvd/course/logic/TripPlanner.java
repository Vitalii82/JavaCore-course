package com.solvd.course.logic;

import java.util.Comparator;
import java.util.List;

import com.solvd.course.exceptions.NoFlightsFoundException;
import com.solvd.course.exceptions.RoutePlanningException;
import com.solvd.course.model.Airport;
import com.solvd.course.model.Flight;
import com.solvd.course.model.Route;

public class TripPlanner {
    public Route findBestRoute(Airport from, Airport to) throws NoFlightsFoundException, RoutePlanningException {
        List<Flight> directFlights = from.getFlights().stream()
                .filter(f -> f.getTo().equals(to)).toList();

        if (directFlights.isEmpty()) {
            throw new NoFlightsFoundException("No direct flights from " + from.getCode() + " to " + to.getCode());
        }

        Flight best = directFlights.stream()
                .min(Comparator.comparingDouble(f -> f.getPrice() + f.getDurationInMinutes()))
                .orElseThrow(() -> new RoutePlanningException("Unable to choose best flight"));

        return new Route(List.of(best));
    }
}