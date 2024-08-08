package com.nikolascramer;

public class User {

    public enum UserState {
        UNASSIGNED,
        ASSIGNED,
        PICKEDUP,
        DROPPEDOFF
    }

    private Node dropoff_location;
    private Node pickup_location;
    public Boolean picked_up;
    private UserState state;

    public User(Node pickup_location, Node dropoff_location) {
        this.dropoff_location = dropoff_location;
        this.pickup_location = pickup_location;
        this.state = UserState.UNASSIGNED;
    }

    public void changeState(UserState newState) {
        this.state = newState;
    }

    public UserState getState() {
        return this.state;
    }
}
