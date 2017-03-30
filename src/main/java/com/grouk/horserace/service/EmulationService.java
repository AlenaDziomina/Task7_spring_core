package com.grouk.horserace.service;

import com.grouk.horserace.util.ConsoleWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Race Emulation Service
 * Created by Alena on 29.03.2017.
 */
@Component
public class EmulationService {
    private final static Logger LOGGER = LoggerFactory.getLogger(EmulationService.class);
    private final static Random RANDOM = new Random();
    @Autowired
    private ConsoleWriter writer;
    @Value("#{config['race.horse.count']}")
    private Integer horseCount;
    @Value("#{config['race.distant']}")
    private Integer distant;

    public Integer emulate(List<Integer> numbers) {
        Map<Integer, Integer> raceState = prepareForRace(numbers);

        for (int i = 0; i < distant; i++) {
            numbers = getRaceState(raceState);
            printRaceState(numbers);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                LOGGER.error(e.getLocalizedMessage());
                throw new RuntimeException(e);
            }
        }

        return numbers.get(0);
    }

    private Map<Integer, Integer> prepareForRace(List<Integer> numbers) {
        return numbers.stream().collect(Collectors.toMap(Function.identity(), n -> 0));
    }

    private List<Integer> getRaceState(Map<Integer, Integer> raceState) {
        raceState.entrySet().forEach(this::go);
        return raceState.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    private void go(Map.Entry<Integer, Integer> horse) {
        Integer horseDist = horse.getValue();
        horseDist += RANDOM.nextInt(distant);
        horse.setValue(horseDist);
    }

    private void printRaceState(List<Integer> numbers) {
        Object[] args = new Object[]{numbers};
        writer.printMessage("race.state", args);
    }
}
