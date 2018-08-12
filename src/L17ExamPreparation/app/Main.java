package L17ExamPreparation.app;

import L17ExamPreparation.app.io.ConsoleInputReader;
import L17ExamPreparation.app.io.ConsoleOutputWriter;
import L17ExamPreparation.app.core.HealthManager;
import L17ExamPreparation.app.engines.Engine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        HealthManager manager = new HealthManager();
        Engine engine = new Engine(manager, inputReader, outputWriter);

        engine.run();
    }
}
