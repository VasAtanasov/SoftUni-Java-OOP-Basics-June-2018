package L17ExamPreparation.app.core;

import L17ExamPreparation.app.entities.Organism;

import java.util.LinkedHashMap;
import java.util.Map;

import static L17ExamPreparation.app.utilities.Constants.ORGANISM_ALREADY_CREATED;
import static L17ExamPreparation.app.utilities.Constants.ORGANISM_CREATED;


public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        return null;
    }

    public String createOrganism(String name) {
        if (organisms.containsKey(name)) {
            return String.format(ORGANISM_ALREADY_CREATED, name);
        }
        this.organisms.put(name, new Organism(name));
        return String.format(ORGANISM_CREATED, name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        return null;

    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return null;

    }

    public String activateCluster(String organismName) {
        return null;

    }
}
