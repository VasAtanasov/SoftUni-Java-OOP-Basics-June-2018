package L12InterfacesExercise.Ex06BirthdayCelebrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader reader;
    private static List<Birthable> birthables;

    static {
        birthables = new ArrayList<>();
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        String input;

        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if ("Citizen".equals(tokens[0])) {
                createCitizen(tokens);
            } else if ("Pet".equals(tokens[0])) {
                pet(tokens);
            }
        }

        String year = reader.readLine();

        for (Birthable birthable : birthables) {
            if (birthable.getBirthDay().endsWith(year)) {
                System.out.println(birthable.getBirthDay());
            }
        }


    }

    private static void pet(String[] tokens) {
        String name = tokens[1];
        String birthDay = tokens[2];
        Pet pet = new Pet(name, birthDay);
        birthables.add(pet);
    }

    private static void createCitizen(String[] tokens) {
        String name = tokens[1];
        int age = Integer.parseInt(tokens[2]);
        String id = tokens[3];
        String birthDay = tokens[4];
        Citizen citizen = new Citizen(name, age, id, birthDay);
        birthables.add(citizen);
    }
}

