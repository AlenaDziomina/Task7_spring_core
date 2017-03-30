package com.grouk.horserace.model;

import java.util.Date;
import java.util.Set;

/**
 * Race
 * Created by Alena on 29.03.2017.
 */
public class Race {
    private Date date;
    private String name;
    private Set<Horse> horseSet;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Horse> getHorseSet() {
        return horseSet;
    }

    public void setHorseSet(Set<Horse> horseSet) {
        this.horseSet = horseSet;
    }
}
