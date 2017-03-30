package com.grouk.horserace.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

/**
 * Writer to Console
 * Created by Alena on 30.03.2017.
 */
@Component
public class ConsoleWriter {

    @Resource(name = "strings")
    private MessageSource messageSource;

    @Value("#{config['language']}")
    private String language;

    @Value("#{config['region']}")
    private String region;

    public void printMessage(String msgCode, Object[] args) {
        Locale locale = getLocale();
        String message = messageSource.getMessage(msgCode, args, locale);
        System.out.println(message);
    }

    private Locale getLocale() {
        return new Locale.Builder().setLanguage(language).setRegion(region).build();
    }
}
