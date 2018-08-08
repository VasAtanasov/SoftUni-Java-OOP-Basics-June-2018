package L12InterfacesExercise.Ex07FoodShortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Buyer> buyers = new HashMap<>();

        int count = Integer.parseInt(reader.readLine());
        for (int i = 0; i < count; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            Buyer buyer;
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (tokens.length == 4) {
                String id = tokens[2];
                String birthDate = tokens[2];
                buyer = new Citizen(name, age, id, birthDate);
            } else {
                String group = tokens[2];
                buyer = new Rebel(name, age, group);
            }
            buyers.put(name, buyer);
        }

        String name;
        while (! "End".equals(name = reader.readLine())) {
            if (buyers.containsKey(name)) {
                buyers.get(name).buyFood();
            }
        }

        System.out.println(buyers.values()
                .stream()
                .mapToInt(Buyer::getFood)
                .sum());
    }
}
