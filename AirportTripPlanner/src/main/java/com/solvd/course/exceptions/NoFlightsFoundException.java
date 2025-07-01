package exceptions;

public class NoFlightsFoundException extends Exception {
    public NoFlightsFoundException(String message) {
        super(message);
    }
}