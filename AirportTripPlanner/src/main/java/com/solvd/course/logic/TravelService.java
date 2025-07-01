package com.solvd.course.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.course.exceptions.NoFlightsFoundException;
import com.solvd.course.exceptions.OverweightBaggageException;
import com.solvd.course.exceptions.RoutePlanningException;
import com.solvd.course.interfaces.Notifiable;
import com.solvd.course.model.Airport;
import com.solvd.course.model.Baggage;
import com.solvd.course.model.BaggagePolicy;
import com.solvd.course.model.Flight;
import com.solvd.course.model.Passenger;
import com.solvd.course.model.Route;
import com.solvd.course.model.Ticket;

public class TravelService {

    private static final Logger logger = LogManager.getLogger(TravelService.class);

    private TripPlanner planner = new TripPlanner();
    private Notifiable notifier;
    private BaggagePolicy baggagePolicy = new BaggagePolicy(23.0, 10.0);

    public TravelService(Notifiable notifier) {
        this.notifier = notifier;
    }

    public void planTrip(Passenger passenger, Airport from, Airport to, Baggage baggage) {
        try {
            Route route = planner.findBestRoute(from, to);
            if (route == null) {
                throw new NoFlightsFoundException("No route found");
            }

            Flight bestFlight = route.getFlights().get(0);
            double baggageFee = baggagePolicy.calculateOvercharge(baggage);

            if (baggageFee > 0) {
                throw new OverweightBaggageException("Excess baggage: $" + baggageFee);
            }

            Ticket ticket = new Ticket(passenger, bestFlight);
            double totalPrice = ticket.getPrice() + baggageFee;

            notifier.sendConfirmation("Ticket: " + ticket +
                    "\nBaggage: " + baggage +
                    "\nTotal: $" + totalPrice);
            logger.info("Route selected: " + route);

        } catch (NoFlightsFoundException | RoutePlanningException | OverweightBaggageException e) {
            notifier.sendFailure(e.getMessage());
            logger.error("Trip planning failed: ", e);
        }
    }
}