package L17ExamPreparation.app.utilities;

public final class Constants {
    public static final String END_COMMAND = "BEER IS COMING";
    public static final String CREATE_ORGANISM = "createOrganism";
    public static final String CHECK_CONDITION = "checkCondition";
    public static final String ADD_CLUSTER = "addCluster";
    public static final String ADD_CELL = "addCell";
    public static final String ACTIVATE_CLUSTER = "activateCluster";

    public static final String ORGANISM_CREATED = "Created organism %s";
    public static final String CLUSTER_CREATED = "Organism %s: Created cluster %s";
    public static final String CELL_CREATED = "Organism %s: Created cell %s in cluster %s";

    // Errors
    public static final String ORGANISM_ALREADY_CREATED = "Organism %s already exists";
    public static final String CLUSTER_ALREADY_EXISTS = "Cluster already exists";
    public static final String ORGANISM_NOT_FOUND = "Organism not found";
    public static final String CLUSTER_NOT_FOUND = "Cluster not found";
    public static final String INVALID_POSITION = "Invalid position";
    public static final String INVALID_SIZE = "Invalid size";
}
