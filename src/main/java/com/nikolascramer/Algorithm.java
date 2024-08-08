package com.nikolascramer;

import java.util.*;

public class Algorithm {

    // This depends on what algorithm is used to figure out what cars should pick up what users.
    // this is a greedy implementation for now
    static public Map<Car, User> matchCarsToCustomer(List<User> users, List<Car> cars) {
        HashMap<Car, User> cars_to_users = new HashMap<>();

        for (int i = 0; i < Math.min(cars.size(), users.size()); i++) {
            cars_to_users.put(cars.get(i), users.get(i));
        }

        return cars_to_users;
    }
}
