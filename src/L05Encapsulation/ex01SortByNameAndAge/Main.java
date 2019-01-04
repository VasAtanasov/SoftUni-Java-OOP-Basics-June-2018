package L05Encapsulation.ex01SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Person> people = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        while (lines-- > 0) {
            String[] tokens = reader.readLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            people.add(new Person(firstName, lastName, age));
        }

        people.stream()
                .sorted((p1, p2) -> {
                    int index = p1.getFirstName().compareTo(p2.getFirstName());
                    return (index != 0) ? index : Integer.compare(p1.getAge(), p2.getAge());
                })
                .forEach(System.out::println);
    }
}
