package interfaces;

public interface Notifiable {
    void sendConfirmation(String message);
    void sendFailure(String message);
}