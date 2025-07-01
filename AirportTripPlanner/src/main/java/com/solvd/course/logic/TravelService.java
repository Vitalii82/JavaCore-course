package logic;

import exceptions.NoFlightsFoundException;
import exceptions.OverweightBaggageException;
import exceptions.RoutePlanningException;
import interfaces.Notifiable;
import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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