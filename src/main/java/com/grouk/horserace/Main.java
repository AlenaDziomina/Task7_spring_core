package com.grouk.horserace;

import com.grouk.horserace.controller.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Main app class
 * Created by Alena on 29.03.2017.
 */
public class Main {
    private final static Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("Start application.");
        ApplicationContext context = new ClassPathXmlApplicationContext("application-config.xml");
        Controller controller = context.getBean(Controller.class);
        controller.run();
    }
}
