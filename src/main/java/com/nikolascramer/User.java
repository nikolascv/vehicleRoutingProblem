package com.nikolascramer;

public class User {
    private Node dropoff_location;
    private Node pickup_location;
    public Boolean picked_up;

    public User(Node pickup_location, Node dropoff_location) {
        this.dropoff_location = dropoff_location;
        this.pickup_location = pickup_location;
    }
}
