package L17ExamPreparation.app.entities;

import java.util.*;
import java.util.stream.Collectors;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new LinkedHashMap<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Cluster> getClusters() {
        return Collections.unmodifiableMap(this.clusters);
    }

    public void add(String id, Cluster cluster) {
        this.clusters.put(id, cluster);
    }

    @Override
    public String toString() {
        int clusterCount = this.clusters.size();
        int cellCount = this.clusters
                .values()
                .stream()
                .map(Cluster::getCellCount)
                .reduce(0, (a, b) -> a + b);

        String clustersBuilder = clusterCount == 0 ? "" : System.lineSeparator() +
                this.clusters
                        .values()
                        .stream()
                        .map(Cluster::toString)
                        .collect(Collectors.joining(System.lineSeparator()));

        return String.format("Organism - %s", this.getName()) +
                System.lineSeparator() +
                String.format("--Clusters: %d", clusterCount) +
                System.lineSeparator() +
                String.format("--Cells: %d", cellCount) +
                clustersBuilder;

    }
}