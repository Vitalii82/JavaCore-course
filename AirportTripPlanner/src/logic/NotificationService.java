package logic;

import interfaces.Notifiable;

public class NotificationService implements Notifiable {

    @Override
    public void sendConfirmation(String message) {
        System.out.println("[CONFIRMED] " + message);
    }

    @Override
    public void sendFailure(String message) {
        System.out.println("[FAILED] " + message);
    }
}
