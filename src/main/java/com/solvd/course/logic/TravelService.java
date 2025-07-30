package com.solvd.course.logic;

import com.solvd.course.exceptions.NoFlightsFoundException;
import com.solvd.course.exceptions.OverweightBaggageException;
import com.solvd.course.exceptions.RoutePlanningException;
import com.solvd.course.interfaces.Notifiable;
import com.solvd.course.model.*;

public class TravelService {
    private final TripPlanner planner = new TripPlanner();
    private final Notifiable notifier;

    public TravelService(Notifiable notifier) {
        this.notifier = notifier;
    }

    public void planTrip(Passenger p, Airport from, Airport to, Baggage bg) {
        try {
            Route route = planner.findBestRoute(from, to);
            Flight f     = route.getFlights().get(0);
            double fee   = bg.weight() > 20 ? (bg.weight()-20)*5 : 0;
            notifier.sendConfirmation("Flight " + f.flightNumber() +
                                      " Price: $" + f.price() +
                                      " Baggage fee: $" + fee);
        } catch(Exception e) {
            notifier.sendFailure(e.getMessage());
        }
    }
}
