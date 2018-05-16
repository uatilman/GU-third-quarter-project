package ru.tilman.gb.ee.logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.logging.Level.*;
import static java.util.logging.Level.CONFIG;
import static java.util.logging.Level.INFO;


public class ProjectLogger {
    private static final Logger LOGGER = Logger.getLogger("ProjectLogger");

    static {
        initLogger();
    }

    @AroundInvoke
    public Object printLog(InvocationContext invocationContext) throws Exception {
        List<String> parameterList;

        try {
            parameterList = Arrays
                    .stream(invocationContext.getParameters())
                    .map(o -> String.format("Class: %s, value: %s", o.getClass().getSimpleName(), o.toString())).collect(Collectors.toList());
        } catch (NullPointerException e) {
            parameterList = null;
        }

        LOGGER.log(INFO, String.format(
                "Class: %s, Method: %s. Incoming Parameters %s ",
                invocationContext.getMethod().getDeclaringClass().getSimpleName(),
                invocationContext.getMethod().getName(), parameterList != null ? parameterList : "some parameters have null value"
        ));

        try {
            return invocationContext.proceed();
        } catch (Exception e) {
            LOGGER.log(WARNING, "Error calling invocationContext.proceed() in printLog()", e);
            return null;
        }
    }

    private static void initLogger() {
        LOGGER.setLevel(ALL);
        LOGGER.setUseParentHandlers(false);

        try {
            Handler fileHandlerException = new FileHandler(
                    "exception_log_" +
                            new SimpleDateFormat("YYYY.MM.dd").format(Calendar.getInstance().getTime()) +
                            ".log"
            );
            fileHandlerException.setFormatter(new SimpleFormatter());
            fileHandlerException.setLevel(WARNING);
            fileHandlerException.setEncoding("UTF-8");
            LOGGER.addHandler(fileHandlerException);


            Handler fileHandlerInfo = new FileHandler(
                    "info_log_" +
                            new SimpleDateFormat("YYYY.MM.dd").format(Calendar.getInstance().getTime()) +
                            ".log"

            );
            fileHandlerInfo.setFormatter(new SimpleFormatter());
            fileHandlerInfo.setLevel(CONFIG);
            fileHandlerInfo.setEncoding("UTF-8");
            fileHandlerInfo.setFilter(record -> record.getLevel().equals(INFO));
            LOGGER.addHandler(fileHandlerInfo);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
