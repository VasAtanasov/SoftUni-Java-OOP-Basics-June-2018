package L16ExamPreparation.app;

import L16ExamPreparation.app.core.CarManagerImpl;
import L16ExamPreparation.app.engines.AppEngine;
import L16ExamPreparation.app.interfaces.*;
import L16ExamPreparation.app.io.ConsoleInputReader;
import L16ExamPreparation.app.io.ConsoleOutputWriter;
import L16ExamPreparation.app.utilities.InputParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputReader inputReader = new ConsoleInputReader();
        OutputWriter outputWriter = new ConsoleOutputWriter();
        Parser parser = new InputParser();
        CarManager carManager = new CarManagerImpl();
        Engine engine = new AppEngine(inputReader,outputWriter,parser,carManager);

        engine.run();
    }
}
