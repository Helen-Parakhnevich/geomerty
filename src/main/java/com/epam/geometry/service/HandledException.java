package com.epam.geometry.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HandledException extends Exception {

    private final Logger LOGGER = LogManager.getLogger(HandledException.class);

    public HandledException() {
    }

    public HandledException(String message) {
        LOGGER.warn(message);
    }

    public HandledException(Throwable cause) {
        super(cause);
    }

    public HandledException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message);
    }
}
