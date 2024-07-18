package com.nikolascramer;

import java.util.*;

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

    public void startSolve(List<Car> cars, List<User> customers, TimeTracker clock) {
        Algorithm algorithm = new Algorithm(cars, customers);
        
        while (!clock.hasEnded()) {
            Map<Car, List<User>> matchings = algorithm.matchCarsToCustomer();

            updateStates(matchings);

            clock.tick();
            System.out.println("Current time is " + clock.getTime());
        }
    }



    private void updateStates(Map<Car, List<User>> matchings) {
        /* 
        With these matchings between cars and users, the updateStates() function should ideally update the routes of
        the cars. Whenever the routes of the cars get updated, the car class should then move the car as well.
        Because we already know that this is the optimal route, the car just needs to move to the next node, no need
        to figure out what the best route is to the next node in the route.
         */
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
