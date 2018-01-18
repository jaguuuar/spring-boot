package com.codecool.footballapp.logger_service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.springframework.stereotype.Component;



@Component
public class LoggerServiceImp implements LoggerService {

    private static final Logger LOGGER = LogManager.getLogger(String.class);
    private Marker marker = MarkerManager.getMarker("START");

    @Override
    public void logError(String message){
        LOGGER.error(marker, message);
    }

    @Override
    public void logInfo(String message) {
        LOGGER.info(marker, message);

    }

}
