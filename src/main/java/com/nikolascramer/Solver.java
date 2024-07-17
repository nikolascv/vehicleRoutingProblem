package com.nikolascramer;

import java.util.*;

public class Solver {
    private List<Car> cars;
    private List<User> customers;
    private TimeTracker clock;
    private HashMap<Car, List<User>> matchings;

    public  Solver(List<Car> cars, List<User> customers, TimeTracker clock) {
        this.cars = cars;
        this.customers = customers;
        this.clock = clock;
    }

    public void startSolve(List<Car> cars, List<User> customers, TimeTracker clock) {
        while (!clock.hasEnded()) {
            matchings.clear();

            matchCarsToCustomer();

            updateStates();

            clock.tick();
            System.out.println("Current time is " + clock.getTime());
        }
    }

    // This can probably be put into a different class
    // This depends on what algorithm is used to figure out what cars should pick up what users.
    private void matchCarsToCustomer() {
        for (Car car : cars) {
            if (!matchings.containsKey(car)) {
                matchings.put(car, new ArrayList<>());
            }
            for (User customer : customers) {
                if (matchings.get(car).size() < Car.CAPACITY) {
                    matchings.get(car).add(customer);
                }
            }
        }
    }

    private void updateStates() {
        // This is going to depend a bit on the Matching Cars to users, because how do we extract the route
        // the car is taking to visit those customers. Running the optimization twice seems to not be ideal.
        for (Car car : cars) {
            car.updateLocation();
        }
        for (User user : customers) {
            // Figure out a way of how to know if a customer has been picked up
            // This information should then be passed to the User object and to the car to be added as a passenger.
        }
    }

}
