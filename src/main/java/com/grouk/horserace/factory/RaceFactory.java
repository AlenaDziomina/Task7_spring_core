package com.grouk.horserace.factory;

import com.grouk.horserace.model.Horse;
import com.grouk.horserace.model.Race;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Race Factory
 * Created by Alena on 30.03.2017.
 */
@Component
public class RaceFactory {

    private final static Random RANDOM = new Random();

    @Value("#{config['race.horse.count']}")
    private Integer horseCount;

    @Value("#{config['race.name']}")
    private String raceName;

    public Race getRace(Integer raceNumber, List<Horse> horseList) {
        Race race = new Race();
        race.setName(raceName + raceNumber);
        race.setDate(new Date());
        race.setHorseSet(getRandomHorseSet(horseList));
        return race;
    }

    private Set<Horse> getRandomHorseSet(List<Horse> horseList) {
        Integer bound = horseList.size();

        Set<Horse> horseSet = new HashSet<>(horseCount);
        while (horseSet.size() < horseCount) {
            horseSet.add(getRandomHorse(horseList, bound));
        }
        return horseSet;
    }

    private Horse getRandomHorse(List<Horse> horseList, Integer bound) {
        Integer rand = RANDOM.nextInt(bound);
        return horseList.get(rand);
    }

}
