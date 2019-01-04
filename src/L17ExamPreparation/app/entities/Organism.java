package L17ExamPreparation.app.entities;

import L17ExamPreparation.app.utilities.Constants;

import java.util.*;
import java.util.stream.Collectors;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;
    private Deque<String> clustersIds;

    public Organism(String name) {
        this.name = name;
        this.clusters = new HashMap<>();
        this.clustersIds = new ArrayDeque<>();
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Cluster> getClusters() {
        return Collections.unmodifiableMap(this.clusters);
    }

    public void add(String id, Cluster cluster) {
        this.clusters.put(id, cluster);
        this.clustersIds.addLast(id);
    }

    public String activateCluster() {
        if (this.clustersIds.isEmpty()) {
            return Constants.CLUSTER_NOT_FOUND;
        }
        String clusterId = clustersIds.removeFirst();
        Cluster cluster = clusters.get(clusterId);
        cluster.activate();
        this.clustersIds.addLast(clusterId);
        return String.format(Constants.CLUSTER_ACTIVATED, this.getName(), clusterId, cluster.getCellCount());
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
                this.clustersIds
                        .stream()
                        .map(clusterId -> this.clusters.get(clusterId).toString())
                        .collect(Collectors.joining(System.lineSeparator()));

        return String.format("Organism - %s", this.getName()) +
                System.lineSeparator() +
                String.format("--Clusters: %d", clusterCount) +
                System.lineSeparator() +
                String.format("--Cells: %d", cellCount) +
                clustersBuilder;

    }
}