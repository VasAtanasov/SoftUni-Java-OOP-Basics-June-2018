package L16ExamPreparation.app;

import L16ExamPreparation.app.core.CarManager;
import L16ExamPreparation.app.engines.Engine;
import L16ExamPreparation.app.io.ConsoleInputReader;
import L16ExamPreparation.app.io.ConsoleOutputWriter;
import L16ExamPreparation.app.utilities.InputParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser parser = new InputParser();
        CarManager manager = new CarManager();
        Engine engine = new Engine(inputReader, outputWriter, parser, manager);

        engine.run();
    }
}
