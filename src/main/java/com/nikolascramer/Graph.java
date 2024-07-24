package com.nikolascramer;

import java.io.*;
import java.nio.Buffer;
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

    public void addNode(int id) {
        this.adjVertices.putIfAbsent(new Node(id), new ArrayList<>());
    }

    public void removeNode(Node node) {
        adjVertices.values().forEach(e -> e.remove(node));
        adjVertices.remove(node);
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

    public static Graph fromAdjecencyList(Map<Node, List<Node>> adjacencyList) {
        return new Graph(adjacencyList);
    }
    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<>();
        this.adjVertices.forEach((key, value) -> nodes.add(key));
        return nodes;
    }

    public Map<Node, List<Node>> getAdjacencyList() {
        return this.adjVertices;
    }
}
