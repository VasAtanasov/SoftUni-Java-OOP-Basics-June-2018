package L17ExamPreparation.app.engines;

import L17ExamPreparation.app.core.HealthManager;
import L17ExamPreparation.app.io.ConsoleInputReader;
import L17ExamPreparation.app.io.ConsoleOutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static L17ExamPreparation.app.utilities.Constants.*;

public class Engine {
    private HealthManager manager;
    private ConsoleInputReader reader;
    private ConsoleOutputWriter writer;

    public Engine(HealthManager manager, ConsoleInputReader reader, ConsoleOutputWriter writer) {
        this.manager = manager;
        this.reader = reader;
        this.writer = writer;
    }

    public void run() throws IOException {
        String input;
        while (! END_COMMAND.equals(input = reader.readLine())) {
            List<String> commandTokens = Arrays.stream(input.split("\\s+")).collect(Collectors.toCollection(ArrayList::new));
            this.dispatchCommand(commandTokens);
        }
    }

    private void dispatchCommand(List<String> commandTokens) {
        String command = commandTokens.remove(0);

        String organismName;
        String clusterId;
        String output;

        switch (command) {
            case CHECK_CONDITION:
                organismName = commandTokens.get(0);
                writer.writeLine(manager.checkCondition(organismName));
                break;
            case CREATE_ORGANISM:
                organismName = commandTokens.get(0);
                writer.writeLine(manager.createOrganism(organismName));
                break;
            case ADD_CLUSTER:
                organismName = commandTokens.get(0);
                clusterId = commandTokens.get(1);
                int rows = Integer.parseInt(commandTokens.get(2));
                int cols = Integer.parseInt(commandTokens.get(3));
                output = this.manager.addCluster(organismName, clusterId, rows, cols);
                if (! CLUSTER_ALREADY_EXISTS.equals(output) && ! ORGANISM_NOT_FOUND.equals(output)) {
                    writer.writeLine(output);
                }
                break;
            case ADD_CELL:
                organismName = commandTokens.get(0);
                clusterId = commandTokens.get(1);
                String cellType = commandTokens.get(2);
                String cellId = commandTokens.get(3);
                int health = Integer.parseInt(commandTokens.get(4));
                int row = Integer.parseInt(commandTokens.get(5));
                int col = Integer.parseInt(commandTokens.get(6));
                int additionalProperty = Integer.parseInt(commandTokens.get(7));
                output = manager.addCell(organismName, clusterId, cellType, cellId, health, row, col, additionalProperty);
                if (! ORGANISM_NOT_FOUND.equals(output) && ! CLUSTER_NOT_FOUND.equals(output)) {
                    writer.writeLine(output);
                }
                break;
        }
    }

}
