package com.solvd.course.logic;

import com.solvd.course.model.Flight;
import com.solvd.course.model.Passenger;
import com.solvd.course.model.Baggage;
import com.solvd.course.model.Route;
import exceptions.NoFlightsFoundException;
import exceptions.OverweightBaggageException;
import exceptions.RoutePlanningException;
import interfaces.Notifiable;

public class TravelService {
    private final TripPlanner planner = new TripPlanner();
    private final Notifiable notifier;

    public TravelService(Notifiable notifier) {
        this.notifier = notifier;
    }

    public void planTrip(Passenger p, Airport from, Airport to, Baggage bg) {
        try {
            Route route = planner.findBestRoute(from, to);
            Flight f = route.getFlights().get(0);
            double baggageFee = bg.weight() > 20 ? (bg.weight() - 20) * 10 : 0;
            notifier.sendConfirmation("Flight:" + f.flightNumber() + " Price: " + f.price() + " BaggageFee: " + baggageFee);
        } catch (Exception e) {
            notifier.sendFailure(e.getMessage());
        }
    }
}
