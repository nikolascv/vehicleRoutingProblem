package com.nikolascramer;

import java.util.*;

public class Car {
    private Node location;
    private List<User> passengers;
    public static final int CAPACITY = 2;
    public static final int SPEED = 1;
    public List<Node> route;

    public Car(Node location) {
        this.location = location;
        this.passengers = new ArrayList<>();
        this.route = new ArrayList<>();
    }

    public Node getLocation() {
        return this.location;
    }

    public void updateLocation() {
        // This can probably be implemented better using sublists and clear()
        try {
            for (int i = 0; i < SPEED; i++) {
                this.route.remove(0);
            }
        } catch (Exception e) {
            System.out.println("Can not iterate through route, probably because route is too small");
        }
    }
}
