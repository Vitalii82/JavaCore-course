package com.solvd.course.logic;

import com.solvd.course.exceptions.NoFlightsFoundException;
import com.solvd.course.exceptions.RoutePlanningException;
import com.solvd.course.model.Airport;
import com.solvd.course.model.Flight;
import com.solvd.course.model.Route;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TripPlanner {
    public Route findBestRoute(Airport from, Airport to) throws NoFlightsFoundException, RoutePlanningException {
        List<Flight> directFlights = from.getFlights().stream()
                .filter(f -> f.getTo().equals(to))
                .collect(Collectors.toList());

        if (directFlights.isEmpty()) {
            throw new NoFlightsFoundException("No direct flights from " + from.getCode() + " to " + to.getCode());
        }

        PriorityQueue<Flight> queue = new PriorityQueue<>(Comparator.comparingDouble(
                f -> f.getPrice() + f.getDurationInMinutes()));
        queue.addAll(directFlights);

        return new Route(List.of(queue.poll()));
    }
}