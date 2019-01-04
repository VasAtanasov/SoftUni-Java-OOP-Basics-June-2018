package L16ExamPreparation.app.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public InputParser() {

    }

    public List<String> parseInput(String inputLine) {
        return Arrays.stream(inputLine.split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
    }


}
