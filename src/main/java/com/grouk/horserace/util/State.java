package com.grouk.horserace.util;

/**
 * State
 * Created by Alena on 29.03.2017.
 */
public enum State {
    UNKNOWN("unknown"), WINNER("winner"), LOOSER("looser");

    private String state;

    State(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
