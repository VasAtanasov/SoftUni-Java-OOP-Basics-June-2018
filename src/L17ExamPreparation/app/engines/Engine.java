package L17ExamPreparation.app.engines;

import L17ExamPreparation.app.core.HealthManager;
import L17ExamPreparation.app.io.ConsoleInputReader;
import L17ExamPreparation.app.io.ConsoleOutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static L17ExamPreparation.app.utilities.Constants.END_COMMAND;
import static L17ExamPreparation.app.utilities.Constants.CHECK_CONDITION;
import static L17ExamPreparation.app.utilities.Constants.CREATE_ORGANISM;

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

        switch (command) {
            case CHECK_CONDITION:
                organismName = commandTokens.get(0);
                writer.writeLine(manager.checkCondition(organismName));
                break;
            case CREATE_ORGANISM:
                organismName = commandTokens.get(0);
                writer.writeLine(manager.createOrganism(organismName));
                break;
        }
    }

}
