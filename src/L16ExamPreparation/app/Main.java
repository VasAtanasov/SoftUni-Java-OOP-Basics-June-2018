package L16ExamPreparation.app;

import L16ExamPreparation.app.core.CarManager;
import L16ExamPreparation.app.engines.Engine;
import L16ExamPreparation.app.io.ConsoleInputReader;
import L16ExamPreparation.app.io.ConsoleOutputWriter;
import L16ExamPreparation.app.repositories.CarsRepository;
import L16ExamPreparation.app.repositories.RacesRepository;
import L16ExamPreparation.app.utilities.InputParser;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConsoleInputReader inputReader = new ConsoleInputReader();
        ConsoleOutputWriter outputWriter = new ConsoleOutputWriter();
        InputParser parser = new InputParser();
        CarsRepository carRepository = new CarsRepository();
        RacesRepository raceRepository = new RacesRepository();
        CarManager manager = new CarManager(carRepository, raceRepository);
        Engine engine = new Engine(inputReader, outputWriter, parser, manager);

        engine.run();
    }
}
