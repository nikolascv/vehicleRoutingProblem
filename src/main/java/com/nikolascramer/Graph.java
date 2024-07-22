package com.nikolascramer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Graph {
    private Map<Node, List<Node>> adjVertices;

    public Graph(Map<Node, List<Node>> adjVertices) {
        this.adjVertices = adjVertices;
    }

    public void addNode(Node node) {
        this.adjVertices.putIfAbsent(node, new ArrayList<>());
    }

    public void addNode(int x, int y) {
        this.adjVertices.putIfAbsent(new Node(x, y), new ArrayList<>());
    }

    public void removeNode(Node node) {
        adjVertices.values().forEach(e -> e.remove(node));
        adjVertices.remove(node);
    }

    public static List<List<String>> csvToAdjList(String path) {
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<Node, List<Node>> map = new HashMap<>();
        List<Node> new_nodes = new ArrayList<>();

        for (List<String> entry: records) {
            new_nodes.add(new Node(Integer.valueOf(entry.get(0))));
        }
        for (List<String> list : records) {

        }
    }

    public void addEdge(Node node1, Node node2) {
        adjVertices.get(node1).add(node2);
        adjVertices.get(node2).add(node1);
    }

    public void removeEdge(Node node1, Node node2) {
        List<Node> eN1 = adjVertices.get(node1);
        List<Node> eN2 = adjVertices.get(node2);

        if (eN1 != null) {
            eN1.remove(node2);
        }
        if (eN2 != null) {
            eN2.remove(node1);
        }
    }
}
