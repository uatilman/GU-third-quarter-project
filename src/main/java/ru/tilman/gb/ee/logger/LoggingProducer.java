package ru.tilman.gb.ee.logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.logging.Level.*;

public class LoggingProducer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
//        Logger logger = Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
//        logger.setLevel(ALL);
//        Handler consoleHandlerInfo = new ConsoleHandler();
//        consoleHandlerInfo.setLevel(FINE);
////        consoleHandlerInfo.setFilter(record -> record.getLevel().equals(INFO));
//        logger.addHandler(consoleHandlerInfo);
//        return logger;
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}
