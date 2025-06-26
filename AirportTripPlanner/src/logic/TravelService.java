package logic;

import interfaces.Notifiable;
import model.*;

public class TravelService {

    private TripPlanner planner = new TripPlanner();
    private Notifiable notifier;
    private BaggagePolicy baggagePolicy = new BaggagePolicy(23.0, 10.0); // 10$ per every kg over 23 kg

    public TravelService(Notifiable notifier) {
        this.notifier = notifier;
    }

    public void planTrip(Passenger passenger, Airport from, Airport to, Baggage baggage) {
        Route route = planner.findBestRoute(from, to);
        if (route != null) {
            Flight bestFlight = route.getFlights().get(0);
            double baggageFee = baggagePolicy.calculateOvercharge(baggage);

            Ticket ticket = new Ticket(passenger, bestFlight);
            double totalPrice = ticket.getPrice() + baggageFee;

            notifier.sendConfirmation("Ticket: " + ticket + 
                "\nBaggage: " + baggage +
                "\nBaggage overcharge: $" + baggageFee +
                "\nTotal: $" + totalPrice);
            System.out.println(route);
        } else {
            notifier.sendFailure("Sorry " + passenger.getName() + ", no flights available.");
        }
    }
}
