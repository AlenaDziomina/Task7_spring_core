package com.grouk.horserace.model;

import com.grouk.horserace.util.State;

/**
 * Horse
 * Created by Alena on 29.03.2017.
 */
public class Horse {
    private Integer number;
    private String Name;
    private State state;
    private Integer winCount;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Integer getWinCount() {
        return winCount;
    }

    public void setWinCount(Integer winCount) {
        this.winCount = winCount;
    }
}
