package com.grouk.horserace.service;

import com.grouk.horserace.factory.RaceFactory;
import com.grouk.horserace.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Race Service
 * Created by Alena on 29.03.2017.
 */
@Component
public class RaceService {

    @Autowired
    private RaceFactory raceFactory;
    @Autowired
    private StableService stableService;

    private Integer raceNumber = 0;

    public Race getUpcomingRace() {
        return raceFactory.getRace(raceNumber++, stableService.getHorseList());
    }
}
