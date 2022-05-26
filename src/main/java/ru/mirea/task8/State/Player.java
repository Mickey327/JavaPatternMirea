package ru.mirea.task8.State;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private State state;

    public Player() {
        this.state = new ReadyState(this);


    }

    public void changeState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

}
