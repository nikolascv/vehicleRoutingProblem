package com.nikolascramer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVParser {

    public static Map<Node, List<Node>> csvToAdjList(File file) {
        Map<Node, List<Node>> adjacencyList = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",", 2);
                int keyId = Integer.parseInt(parts[0]);
                Node keyNode = new Node(keyId);

                List<Node> valueNodes = Arrays.stream(parts[1].split("/"))
                        .map(id -> new Node(Integer.parseInt(id)))
                        .collect(Collectors.toList());

                adjacencyList.put(keyNode, valueNodes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return adjacencyList;
    }
}
