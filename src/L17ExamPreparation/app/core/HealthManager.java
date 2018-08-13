package L17ExamPreparation.app.core;

import L17ExamPreparation.app.entities.Cluster;
import L17ExamPreparation.app.entities.Organism;
import L17ExamPreparation.app.entities.cells.Cell;
import L17ExamPreparation.app.factories.CellFactory;
import L17ExamPreparation.app.factories.ClusterFactory;
import L17ExamPreparation.app.factories.OrganismFactory;

import java.util.LinkedHashMap;
import java.util.Map;

import static L17ExamPreparation.app.utilities.Constants.*;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        return this.organisms.get(organismName).toString();
    }

    public String createOrganism(String name) {
        if (organisms.containsKey(name)) {
            return String.format(ORGANISM_ALREADY_CREATED, name);
        }
        Organism organism = OrganismFactory.create(name);
        this.organisms.put(name, organism);
        return String.format(ORGANISM_CREATED, name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (! this.organisms.containsKey(organismName)) {
            return ORGANISM_NOT_FOUND;
        }
        Organism organism = this.organisms.get(organismName);
        if (organism.getClusters().containsKey(id)) {
            return CLUSTER_ALREADY_EXISTS;
        }
        boolean isValidSize = rows >= 0 && cols >= 0;
        if (!isValidSize) {
            return INVALID_SIZE;
        }
        Cluster cluster = ClusterFactory.create(id, rows, cols);
        organism.add(id, cluster);
        return String.format(CLUSTER_CREATED, organismName, id);

    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (! this.organisms.containsKey(organismName)) {
            return ORGANISM_NOT_FOUND;
        }
        Organism organism = this.organisms.get(organismName);
        if (! organism.getClusters().containsKey(clusterId)) {
            return CLUSTER_NOT_FOUND;
        }
        Cluster cluster = this.organisms.get(organismName).getClusters().get(clusterId);
        boolean isValidPosition = positionRow >= 0 && positionRow < cluster.getRows() &&
                positionCol >= 0 && positionCol < cluster.getCols();
        if (! isValidPosition) {
            return INVALID_POSITION;
        }
        Cell cell = CellFactory.create(cellType, cellId, health, positionRow, positionCol, additionalProperty);
        cluster.add(cell);
        return String.format(CELL_CREATED, organismName, cellId, clusterId);

    }

    public String activateCluster(String organismName) {
        if (! this.organisms.containsKey(organismName)) {
            return ORGANISM_NOT_FOUND;
        }
        Organism organism = this.organisms.get(organismName);

        return null;

    }
}
