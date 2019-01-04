package L04DefiningClassesExercises.ex10FamilyTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader reader;
    private static Person person;
    private static List<Person> people;
    private static List<String> relationships;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        person = new Person();
        people = new ArrayList<>();
        relationships = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        getPersonParameters();
        getPersonAndRelations();

        for (String relationship : relationships) {
            String[] tokens = relationship.split(" - ");
            Person parent = getPerson(tokens[0], tokens[0]);
            Person child = getPerson(tokens[1], tokens[1]);
            parent.addChild(child);
            child.addParent(parent);
        }

        System.out.println(person);
    }

    private static void getPersonAndRelations() throws IOException {
        String input;
        while (! "End".equals(input = reader.readLine())) {
            String[] tokens = input.split(" - ");
            switch (tokens.length) {
                case 1:
                    tiePersonInformation(tokens[0]);
                    break;
                case 2:
                    relationships.add(input);
                    break;
            }
        }
    }

    private static void tiePersonInformation(String token) {
        String[] tokens = token.split("\\s+");
        String name = tokens[0] + " " + tokens[1];
        String date = tokens[2];
        Person person = getPerson(name, date);
        person.setName(name);
        person.setDayOfBirth(date);
    }

    private static Person getPerson(String name, String date) {
        Optional<Person> OptPerson = people.stream()
                .filter(person1 -> person1.isMatch(name, date))
                .findFirst();
        Person person;
        if (OptPerson.isPresent()) {
            person = OptPerson.get();
        } else {
            person = new Person();
            people.add(person);
        }
        return person;
    }

    private static void getPersonParameters() throws IOException {
        String input = reader.readLine();
        if (input.matches("\\w+\\s+\\w+")) {
            person.setName(input);
        } else {
            person.setDayOfBirth(input);
        }
        people.add(person);
    }
}
