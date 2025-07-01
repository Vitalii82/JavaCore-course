package exceptions;

public class InvalidAirportException extends RuntimeException {
    public InvalidAirportException(String message) {
        super(message);
    }
}