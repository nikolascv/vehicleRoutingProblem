package com.nikolascramer;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
class GraphTest {

    @Test
    void csvToAdjList() {
        List<String> copy_1 = Arrays.asList("1","2/3/4");
        List<String> copy_2 = Arrays.asList("2", "1/4");
        List<String> copy_3 = Arrays.asList("3", "1/4");
        List<String> copy_4 = Arrays.asList("4", "1/2/3");
        List<List<String>> listOLists = new ArrayList<>();
        Collections.addAll(listOLists, copy_1, copy_2, copy_3, copy_4);

        String path = "/Users/niko/Downloads/testGraph.csv";
        List<List<String>> adjList = Graph.csvToAdjList(path);
        System.out.println(adjList);
        assertEquals(listOLists, adjList);
    }
}