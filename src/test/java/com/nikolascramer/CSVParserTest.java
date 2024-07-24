package com.nikolascramer;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CSVParserTest {

    @Test
    void csvToAdjListCheck() throws IOException {
        File file = new File("/Users/niko/Downloads/testGraph.csv");
        Map<Node, List<Node>> adjList = CSVParser.csvToAdjList(file);

        adjList.forEach((key, value) -> {
            String valueIds = value.stream()
                    .map(node -> String.valueOf(node.getId()))
                    .collect(Collectors.joining(", "));
            System.out.println(key.getId() + " -> " + valueIds );
        });
    }

    @Test
    void csvToAdjList() throws IOException {
        File tempFile = File.createTempFile("nodes", "csv");
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
            bw.write("1,2/3/4\n");
            bw.write("2,1/4\n");
            bw.write("3,1/4\n");
            bw.write("4,1/2/3\n");
        }
        Map<Node, List<Node>> adjacencyList = CSVParser.csvToAdjList(tempFile);
        Map<Node, List<Node>> expectedList = new HashMap<>();
        expectedList.put(new Node(1), Arrays.asList(new Node(2), new Node(3), new Node(4)));
        expectedList.put(new Node(2), Arrays.asList(new Node(1), new Node(4)));
        expectedList.put(new Node(3), Arrays.asList(new Node(1), new Node(4)));
        expectedList.put(new Node(4), Arrays.asList(new Node(1), new Node(2), new Node(4)));

        for (Map.Entry<Node, List<Node>> entry : expectedList.entrySet()) {
            assertTrue(adjacencyList.containsKey(entry.getKey()), "Adjacency list should contain the key: " + entry.getKey());
            assertEquals(entry.getValue().size(), adjacencyList.get(entry.getKey()).size(), "Node list size should match for key: " + entry.getKey());
            assertTrue(adjacencyList.get(entry.getKey()).containsAll(entry.getValue()), "Node list should contain all expected nodes for key: " + entry.getKey());
        }
        tempFile.delete();
        /*
        adjList.forEach((key, value) -> {
            String valueIds = value.stream()
                    .map(node -> String.valueOf(node.getId()))
                    .collect(Collectors.joining(", "));
                    System.out.println(key.getId() + " -> " + valueIds );
                });
         */
    }
}