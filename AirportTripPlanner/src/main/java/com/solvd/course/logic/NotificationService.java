package logic;

import interfaces.Notifiable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NotificationService implements Notifiable {
    private static final Logger logger = LogManager.getLogger(NotificationService.class);

    @Override
    public void sendConfirmation(String message) {
        logger.info("[CONFIRMED] " + message);
    }

    @Override
    public void sendFailure(String message) {
        logger.error("[FAILED] " + message);
    }
}