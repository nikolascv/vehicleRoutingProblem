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

    }

}
