package com.grouk.horserace.service;

import com.grouk.horserace.model.Horse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Stable Service
 * Created by Alena on 29.03.2017.
 */
@Component
public class StableService {

    @Autowired
    private List<Horse> horseList;

    public List<Horse> getHorseList() {
        return horseList;
    }

    public void setHorseList(List<Horse> horseList) {
        this.horseList = horseList;
    }
}
