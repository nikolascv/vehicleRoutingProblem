package com.nikolascramer;

import java.util.*;
import java.io.File;

public class App {
    private static final Integer END_TIME = 100;

    public static void main(String[] args) {
        File file = new File(args[0]);
        Graph g = new Graph(CSVParser.csvToAdjList(file));

        Car car = new Car(g.getNodes().get(0));
        User user = new User(g.getNodes().get(2), g.getNodes().get(1));

        List<Car> cars = new ArrayList<>();
        cars.add(car);

        List<User> users = new ArrayList<>();
        users.add(user);

        Solver solver = new Solver(cars, users, new TimeTracker(END_TIME));
        solver.startSolve();
    }
}
