package L16ExamPreparation.app.engines;

import L16ExamPreparation.app.core.CarManager;
import L16ExamPreparation.app.io.ConsoleInputReader;
import L16ExamPreparation.app.io.ConsoleOutputWriter;
import L16ExamPreparation.app.utilities.Constants;
import L16ExamPreparation.app.utilities.InputParser;

import java.io.IOException;
import java.util.List;

public class Engine {
    private ConsoleInputReader inputReader;
    private ConsoleOutputWriter outputWriter;
    private InputParser parser;
    private CarManager manager;

    public Engine(ConsoleInputReader inputReader, ConsoleOutputWriter outputWriter, InputParser parser, CarManager manager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.parser = parser;
        this.manager = manager;
    }

    public void run() throws IOException {
        String inputLine;
        while (! Constants.PROGRAM_END_COMMAND.equals(inputLine = this.inputReader.readLine())) {
            List<String> commandParams = this.parser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        int id;
        String type;
        switch (command) {
            case "register":
                id = Integer.parseInt(commandParams.get(0));
                type = commandParams.get(1);
                String brand = commandParams.get(2);
                String model = commandParams.get(3);
                int year = Integer.parseInt(commandParams.get(4));
                int horsepower = Integer.parseInt(commandParams.get(5));
                int acceleration = Integer.parseInt(commandParams.get(6));
                int suspension = Integer.parseInt(commandParams.get(7));
                int durability = Integer.parseInt(commandParams.get(8));
                this.manager.register(id, type, brand, model, year, horsepower, acceleration, suspension, durability);
                break;
            case "check":
                id = Integer.parseInt(commandParams.get(0));
                outputWriter.writeLine(this.manager.check(id));
                break;
            case "open":
                id = Integer.parseInt(commandParams.get(0));
                type = commandParams.get(1);
                int length = Integer.parseInt(commandParams.get(2));
                String route = commandParams.get(3);
                int prizePool = Integer.parseInt(commandParams.get(4));
                if (commandParams.size() == 5) {
                    this.manager.open(id, type, length, route, prizePool);
                } else {
                    int extraParameter = Integer.parseInt(commandParams.get(5));
                    this.manager.open(id, type, length, route, prizePool, extraParameter);
                }
                break;
            case "participate":
                int carId = Integer.parseInt(commandParams.get(0));
                int raceId = Integer.parseInt(commandParams.get(1));
                this.manager.participate(carId, raceId);
                break;
            case "start":
                id = Integer.parseInt(commandParams.get(0));
                String ranking = this.manager.start(id);
                outputWriter.writeLine(ranking);
                break;
            case "park":
                id = Integer.parseInt(commandParams.get(0));
                this.manager.park(id);
                break;
            case "unpark":
                id = Integer.parseInt(commandParams.get(0));
                this.manager.unpark(id);
                break;
            case "tune":
                int tuneIndex = Integer.parseInt(commandParams.get(0));
                String addOn = commandParams.get(1);
                this.manager.tune(tuneIndex, addOn);
                break;
        }
    }
}
