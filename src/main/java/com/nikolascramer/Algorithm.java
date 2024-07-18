package com.nikolascramer;

import java.util.*;

public class Algorithm {
    private List<Car> cars;
    private List<User> users;

    public Algorithm(List<Car> cars, List<User> users) {
        this.cars = cars;
        this.users = users;
    }

    // This depends on what algorithm is used to figure out what cars should pick up what users.
    // this is a greedy implementation for now
    public Map<Car, List<User>> matchCarsToCustomer() {
        HashMap<Car, List<User>> cars_to_users= new HashMap<>();

        for (Car car : cars) {
            if (!cars_to_users.containsKey(car)) {
                cars_to_users.put(car, new ArrayList<>());
            }
            for (User customer : users) {
                if (cars_to_users.get(car).size() < Car.CAPACITY) {
                    cars_to_users.get(car).add(customer);
                }
            }
        }

        return cars_to_users;
    }

}
