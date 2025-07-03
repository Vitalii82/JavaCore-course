package com.solvd.course.logic;

import com.solvd.course.exceptions.NoFlightsFoundException;
import com.solvd.course.exceptions.OverweightBaggageException;
import com.solvd.course.exceptions.RoutePlanningException;
import com.solvd.course.interfaces.Notifiable;
import com.solvd.course.model.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TravelService {
    private final TripPlanner planner = new TripPlanner();
    private final Notifiable notifier;
    private final BaggagePolicy baggagePolicy = new BaggagePolicy(23.0, 10.0);
    private final Map<String, Ticket<?>> issuedTickets = new HashMap<>();
    private final Set<Passenger> passengerRegistry = new HashSet<>();

    public TravelService(Notifiable notifier) {
        this.notifier = notifier;
    }

    public void planTrip(Passenger passenger, Airport from, Airport to, Baggage baggage) {
        try {
            Route<?> route = planner.findBestRoute(from, to);
            Flight bestFlight = route.getFlights().get(0);
            double baggageFee = baggagePolicy.calculateOvercharge(baggage);

            if (baggageFee > 0) {
                throw new OverweightBaggageException("Excess baggage: $" + baggageFee);
            }

            Ticket<Passenger> ticket = new Ticket<>(passenger, bestFlight);
            double totalPrice = ticket.getPrice() + baggageFee;

            passengerRegistry.add(passenger);
            issuedTickets.put(ticket.getFlight().getId(), ticket);

            notifier.sendConfirmation("Ticket: " + ticket +
                    "\nBaggage: " + baggage +
                    "\nTotal: $" + totalPrice);

        } catch (NoFlightsFoundException | RoutePlanningException | OverweightBaggageException e) {
            notifier.sendFailure(e.getMessage());
        }
    }
}