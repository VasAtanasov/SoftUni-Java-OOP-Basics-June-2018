package L17ExamPreparation.app.factories;

import L17ExamPreparation.app.entities.Cluster;

public final class ClusterFactory {
    private ClusterFactory() {

    }

    public static Cluster create(String id, int rows, int cols) {
        return new Cluster(id, rows, cols);
    }
}
