package com.nikolascramer;

import java.util.*;

public class TimeTracker {
    private int time;
    private final int end_time;

    public TimeTracker(int end_time) {
        this.time = 0;
        this.end_time = end_time;
    }

    public void tick() {
        this.time += 1;
    }

    public boolean hasEnded() {
        return this.time >= this.end_time;
    }

    public int getTime() {
        return this.time;
    }
}
