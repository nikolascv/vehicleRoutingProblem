package com.nikolascramer;

import java.util.*;

public class Car {
    private Location location;
    private List<User> passengers;
    public static final int CAPACITY = 2;

    public Car(Location location, User[] passengers) {
        this.location = location;
        this.passengers = new ArrayList<>();
    }

    public Location getLocation() {
        return this.location;
    }
}
