package com.nikolascramer;

import java.util.*;
import java.util.stream.Collectors;

public class Solver {
    private List<Car> cars;
    private List<User> customers;
    private TimeTracker clock;
    private Algorithm algorithm;

    public  Solver(List<Car> cars, List<User> customers, TimeTracker clock) {
        this.cars = cars;
        this.customers = customers;
        this.clock = clock;
    }

    public void startSolve() {
        while (!this.clock.hasEnded()) {
            List<Car> available_cars = new ArrayList<>();
            for (Car car : this.cars) {
                if (car.getState() == Car.CarState.valueOf("AVAILABLE")) {
                    available_cars.add(car);
                }
            }

            List<User> unassigned_users = new ArrayList<>();
            for (User user : this.customers) {
                if (user.getState() == User.UserState.valueOf("UNASSIGNED")) {
                    unassigned_users.add(user);
                }
            }

            Map<Car, User> carToUserMatching = Algorithm.matchCarsToCustomer(unassigned_users, available_cars);

            updateCarStates(carToUserMatching);

            this.clock.tick();
            System.out.println("Current time is " + this.clock.getTime());
        }
    }



    private void updateCarStates(Map<Car, User> matchings) {
        for (Map.Entry<Car, User> entry : matchings.entrySet()) {
           Car car = entry.getKey();
           User users = entry.getValue();

        // Graph traversal goes here
        }
    }


}
