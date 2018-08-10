package L16ExamPreparation.app.engines;

import L16ExamPreparation.app.enums.CommandType;
import L16ExamPreparation.app.interfaces.*;
import L16ExamPreparation.app.utilities.Constants;

import java.io.IOException;
import java.util.List;

public class AppEngine implements Engine {
    private InputReader inputReader;
    private OutputWriter outputWriter;
    private Parser parser;
    private CarManager carManager;

    public AppEngine(InputReader inputReader, OutputWriter outputWriter, Parser parser, CarManager carManager) {
        this.inputReader = inputReader;
        this.outputWriter = outputWriter;
        this.parser = parser;
        this.carManager = carManager;
    }

    @Override
    public void run() throws IOException {
        String inputLine;
        while (!Constants.PROGRAM_END_COMMAND.equals(inputLine = this.inputReader.readLine())) {
            List<String> commandParams = this.parser.parseInput(inputLine);
            this.dispatchCommand(commandParams);
        }
    }

    private void dispatchCommand(List<String> commandParams) {
        String command = commandParams.remove(0);
        CommandType commandType = CommandType.valueOf(command.toUpperCase());
        switch (commandType) {
            case REGISTER:
                int id = Integer.parseInt(commandParams.get(0));
                String type = commandParams.get(1);
                String brand = commandParams.get(2);
                String model = commandParams.get(3);
                int year = Integer.parseInt(commandParams.get(4));
                int horsepower = Integer.parseInt(commandParams.get(5));
                int acceleration = Integer.parseInt(commandParams.get(6));
                int suspension = Integer.parseInt(commandParams.get(7));
                int durability = Integer.parseInt(commandParams.get(8));
                this.carManager.register(id, type, brand, model, year, horsepower, acceleration, suspension, durability);
                break;
            case CHECK:
                break;
            case OPEN:
                break;
            case PARTICIPATE:
                break;
            case START:
                break;
            case PARK:
                break;
            case UNPARK:
                break;
            case TUNE:
                break;
        }
    }
}
