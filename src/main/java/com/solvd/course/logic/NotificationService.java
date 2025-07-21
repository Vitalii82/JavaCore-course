package com.solvd.course.logic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.course.interfaces.Notifiable;

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