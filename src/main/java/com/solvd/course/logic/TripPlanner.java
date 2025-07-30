package com.solvd.course.logic;

import com.solvd.course.exceptions.NoFlightsFoundException;
import com.solvd.course.exceptions.RoutePlanningException;
import com.solvd.course.model.Airport;
import com.solvd.course.model.Flight;
import com.solvd.course.model.Route;

import java.util.Comparator;

public class TripPlanner {
    public Route findBestRoute(Airport from, Airport to)
         throws NoFlightsFoundException, RoutePlanningException {

        var candidates = from.getFlights().stream()
            .filter(f -> f.to().equals(to.getName()))
            .toList();

        if (candidates.isEmpty()) {
            throw new NoFlightsFoundException(
                "No flights from " + from.getName() + " to " + to.getName());
        }

        Flight best = candidates.stream()
            .min(Comparator.comparingDouble(f -> f.price() + f.duration()))
            .orElseThrow(() -> new RoutePlanningException("Choose best flight failed"));

        return new Route(java.util.List.of(best));
    }
}
