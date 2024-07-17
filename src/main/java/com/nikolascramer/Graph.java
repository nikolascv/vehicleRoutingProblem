package com.nikolascramer;

import java.util.*;

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
