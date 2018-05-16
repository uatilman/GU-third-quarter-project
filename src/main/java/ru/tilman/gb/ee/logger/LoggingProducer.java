package ru.tilman.gb.ee.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.ALL;

public class LoggingProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        Logger logger = Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
        logger.setLevel(ALL);
        return logger;
    }
}
