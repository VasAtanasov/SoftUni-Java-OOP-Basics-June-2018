package L12InterfacesExercise.Ex05BorderControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader;
    private static List<Identifiable> people;

    static {
        people = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;

        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 3) {
                createCitizen(tokens);
            } else if (tokens.length == 2) {
                createRobot(tokens);
            }
        }

        String lastDigits = reader.readLine();

        for (Identifiable person : people) {
            if (person.getId().endsWith(lastDigits)) {
                System.out.println(person.getId());
            }
        }


    }

    private static void createRobot(String[] tokens) {
        String model = tokens[0];
        String id = tokens[1];
        Robot robot = new Robot(model, id);
        people.add(robot);
    }

    private static void createCitizen(String[] tokens) {
        String name = tokens[0];
        int age = Integer.parseInt(tokens[1]);
        String id = tokens[2];
        Citizen citizen = new Citizen(name, age, id);
        people.add(citizen);
    }
}
