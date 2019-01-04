package L05Encapsulation.ex02SalaryIncrease;

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
            double salary = Double.parseDouble(tokens[3]);

            people.add(new Person(firstName, lastName, age, salary));
        }

        double bonus = Double.parseDouble(reader.readLine());

        people.forEach(person -> {
            person.increaseSalary(bonus);
            System.out.println(person.toString());
        });
    }
}
