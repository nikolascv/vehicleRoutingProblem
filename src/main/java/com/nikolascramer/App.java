package com.nikolascramer;

import java.util.*;

public class App {
    public static void main(String[] args) {
        // Create some test data
        // Create a set of 10 nodes and then create a graph out of those.
        List<Node> nodes = new ArrayList<>();
        List<List<Node>> edges_collection = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 10; i++) {
            nodes.add(new Node(i,i));
            int edges_amount = r.nextInt(10) + 1;
            for (int j = 0; j < edges_amount; j++) {
                
            }
        }

        Solver solver = new Solver();
        solver.startSolve();
    }
}
