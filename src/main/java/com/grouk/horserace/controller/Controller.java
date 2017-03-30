package com.grouk.horserace.controller;

import com.grouk.horserace.model.Horse;
import com.grouk.horserace.model.Race;
import com.grouk.horserace.service.EmulationService;
import com.grouk.horserace.service.RaceService;
import com.grouk.horserace.util.ConsoleReader;
import com.grouk.horserace.util.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Race Controller
 * Created by Alena on 29.03.2017.
 */
@Component
public class Controller {
    private final static Logger LOGGER = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private RaceService raceService;

    @Autowired
    private EmulationService emulationService;

    @Autowired
    private ConsoleWriter writer;

    @Autowired
    private ConsoleReader reader;

    @Value("#{config['race.horse.count']}")
    private Integer horseCount;

    public void run() {
        LOGGER.info("Start the game.");

        while (true) {
            play();
        }
    }

    private void play() {
        Race race = raceService.getUpcomingRace();
        printRace(race);

        List<Integer> numbers = race.getHorseSet().stream().map(Horse::getNumber).collect(Collectors.toList());

        Integer bet = reader.makeBet(numbers);
        Integer winner = emulationService.emulate(numbers);

        if (bet.equals(winner)) {
            printRaceResult(winner, "race.congrats");
        } else {
            printRaceResult(winner, "race.commiseration");
        }
    }

    private void printRace(Race race) {
        Object[] args = new Object[]{race.getName(), race.getDate()};
        writer.printMessage("race.description", args);

        for (Horse horse : race.getHorseSet()) {
            args = new Object[]{horse.getNumber(), horse.getName(), horse.getWinCount()};
            writer.printMessage("horse.description", args);
        }
    }

    private void printRaceResult(Integer winner, String msg) {
        Object[] args = new Object[]{winner};
        writer.printMessage(msg, args);
    }
}
