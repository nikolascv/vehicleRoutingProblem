package com.nikolascramer;

import java.util.*;

public class Car {

    public enum CarState {
        AVAILABLE,
        EN_ROUTE_TO_PICKUP,
        EN_ROUTE_TO_DROPOFF,
        IDLE
    }

    private Node location;
    private List<User> passengers;
    public static final int CAPACITY = 1;
    public static final int SPEED = 1;
    public List<Node> route;
    private CarState state;

    public Car(Node location) {
        this.location = location;
        this.passengers = new ArrayList<>();
        this.route = new ArrayList<>();
        this.state = CarState.AVAILABLE;
    }

    public Node getLocation() {
        return this.location;
    }


    public void updateState(CarState newState) {
        this.state = newState;
    }

    public CarState getState() {
        return this.state;
    }
}
