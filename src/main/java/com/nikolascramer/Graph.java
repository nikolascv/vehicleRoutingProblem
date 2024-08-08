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

    public List<Node> getNodes() {
        List<Node> nodes = new ArrayList<>();
        this.adjVertices.forEach((key, value) -> nodes.add(key));
        return nodes;
    }

    public Map<Node, List<Node>> getAdjacencyList() {
        return this.adjVertices;
    }

    public Set<Integer> depthFirstTravel(Integer root) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                for (Node v : this.adjVertices) {
                    stack.push(v.label);
                }
            }
        }
    }

    private Map<Node[], Float> createCosts(Map<Node, List<Node>> adjacency_List) {
        Map<Node[], Float> costs = new HashMap<Node[], Float>();
        for (Node node_from_graph : adjacency_List.keySet()) {
            for(Node node_to_graph : adjacency_List.keySet()) {
                    Node[] node_tuple = new Node[2];
                    node_tuple[1] = node_from_graph;
                    node_tuple[2] = node_to_graph;
                    float costBetweenCurrentNodes = calculateDistanceCostBetweenTwoNodes(node_from_graph, node_to_graph);
                    costs.put(node_tuple, costBetweenCurrentNodes);
            }
        }
        return costs;
    }

    private float calculateDistanceCostBetweenTwoNodes(node_1, node_2) {

    }
}
