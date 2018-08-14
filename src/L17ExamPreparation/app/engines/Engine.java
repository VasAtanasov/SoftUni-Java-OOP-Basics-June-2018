package L17ExamPreparation.app.engines;

import L17ExamPreparation.app.core.HealthManager;
import L17ExamPreparation.app.io.ConsoleReader;
import L17ExamPreparation.app.io.ConsoleWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static L17ExamPreparation.app.utilities.Constants.*;

public class Engine {
    private HealthManager manager;
    private ConsoleReader reader;
    private ConsoleWriter writer;
    private List<String> errors;

    public Engine(HealthManager manager, ConsoleReader reader, ConsoleWriter writer) {
        this.manager = manager;
        this.reader = reader;
        this.writer = writer;
        this.errors = new ArrayList<>() {{
            add(ORGANISM_ALREADY_CREATED);
            add(CLUSTER_ALREADY_EXISTS);
            add(ORGANISM_NOT_FOUND);
            add(CLUSTER_NOT_FOUND);
            add(INVALID_POSITION);
            add(INVALID_SIZE);
        }};
    }

    public void run() throws IOException {
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            String[] commandTokens = input.split("\\s+");
            this.dispatchCommand(commandTokens);
        }
    }

    private void dispatchCommand(String[] commandTokens) {
        String command = commandTokens[0];

        String organismName;
        String clusterId;
        String output;

        switch (command) {
            case CHECK_CONDITION:
                organismName = commandTokens[1];
                output = manager.checkCondition(organismName);
                printMessage(output);
                break;
            case CREATE_ORGANISM:
                organismName = commandTokens[1];
                writer.writeLine(manager.createOrganism(organismName));
                break;
            case ADD_CLUSTER:
                organismName = commandTokens[1];
                clusterId = commandTokens[2];
                int rows = Integer.parseInt(commandTokens[3]);
                int cols = Integer.parseInt(commandTokens[4]);
                output = this.manager.addCluster(organismName, clusterId, rows, cols);
                printMessage(output);
                break;
            case ADD_CELL:
                organismName = commandTokens[1];
                clusterId = commandTokens[2];
                String cellType = commandTokens[3];
                String cellId = commandTokens[4];
                int health = Integer.parseInt(commandTokens[5]);
                int row = Integer.parseInt(commandTokens[6]);
                int col = Integer.parseInt(commandTokens[7]);
                int additionalProperty = Integer.parseInt(commandTokens[8]);
                output = manager.addCell(organismName, clusterId, cellType, cellId, health, row, col, additionalProperty);
                printMessage(output);
                break;
            case ACTIVATE_CLUSTER:
                organismName = commandTokens[1];
                output = manager.activateCluster(organismName);
                printMessage(output);
                break;
        }
    }

    private void printMessage(String output) {
        if (! this.errors.contains(output)) {
            writer.writeLine(output);
        }
    }

}
