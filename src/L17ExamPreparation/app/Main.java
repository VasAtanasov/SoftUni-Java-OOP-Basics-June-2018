package L17ExamPreparation.app;

import L17ExamPreparation.app.io.ConsoleReader;
import L17ExamPreparation.app.io.ConsoleWriter;
import L17ExamPreparation.app.core.HealthManager;
import L17ExamPreparation.app.engines.Engine;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleReader inputReader = new ConsoleReader();
        ConsoleWriter outputWriter = new ConsoleWriter();
        HealthManager manager = new HealthManager();
        Engine engine = new Engine(manager, inputReader, outputWriter);

        engine.run();
    }
}
