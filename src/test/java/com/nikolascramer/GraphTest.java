package com.nikolascramer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {
    private Graph g;

    @BeforeEach
    void setup() {
        File file = new File("/Users/niko/Downloads/testGraph.csv");
        this.g = Graph.fromAdjecencyList(CSVParser.csvToAdjList(file));
    }

    @Test
    void addNodeWithNode() {
        Node node_to_search = new Node(10);
        g.addNode(node_to_search);
        List<Node> res = g.getNodes().stream()
                .filter(node -> node.getId() == node_to_search.getId())
                .collect(Collectors.toList());
        assertFalse(res.isEmpty());
    }

    @Test
    void testAddNodeWithId() {
        Integer id = 10;
        Node node_to_search = new Node(id);
        g.addNode(node_to_search);
        List<Node> res = g.getNodes().stream()
                .filter(node -> node.getId() == id)
                .collect(Collectors.toList());
        assertFalse(res.isEmpty());
    }

    @Test
    void removeNode_checkNodes() {
        Node node = g.getNodes().get(0);
        g.removeNode(node);
        assertFalse(g.getAdjacencyList().containsKey(node), "Node should be removed from the adjacency list");
    }

    @Test
    void removeNode_checkEdges() {
        Node node = g.getNodes().get(0);
        g.removeNode(node);
        for (Map.Entry<Node, List<Node>> entry : g.getAdjacencyList().entrySet()) {
            assertFalse(entry.getValue().contains(node));
        }
    }

    @Test
    void addEdge() {
    }

    @Test
    void removeEdge() {
    }

    @Test
    void fromAdjecencyList() {
    }

    @Test
    void getNodes() {
    }
}