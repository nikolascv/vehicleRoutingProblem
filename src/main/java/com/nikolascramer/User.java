package com.nikolascramer;

import java.util.*;

public class User {
    private Location dropoff_location;
    private Location pickup_location;

    public User(Location dropoff_location, Location pickup_location) {
        this.dropoff_location = dropoff_location;
        this.pickup_location = pickup_location;
    }

}
