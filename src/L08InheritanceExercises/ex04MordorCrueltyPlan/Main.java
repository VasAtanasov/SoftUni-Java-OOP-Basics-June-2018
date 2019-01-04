package L08InheritanceExercises.ex04MordorCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Main {
    private static BufferedReader reader;
    private static Map<String, Supplier<Food>> foods;
    private static Gandalf GandalfTheWhite;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        foods = new HashMap<String, Supplier<Food>>() {{
            put("cram", Cram::new);
            put("lembas", Lembas::new);
            put("apple", Apple::new);
            put("melon", Melon::new);
            put("honeycake", HoneyCake::new);
            put("mushrooms", Mushrooms::new);
        }};
        GandalfTheWhite = new Gandalf();
    }

    public static void main(String[] args) throws IOException {
        String input1 = "Cram melon honeyCake Cake";
        String input2 = "gosho pesho meze gosho pesho meze";
        Food[] foodsEaten = Arrays.stream(reader.readLine().toLowerCase().trim().split("\\s+"))
                .map(String::toLowerCase)
                .map(food -> {
                    if (foods.containsKey(food)) {
                        return foods.get(food).get();
                    }
                    return new Other();
                })
                .toArray(Food[]::new);


        for (Food food : foodsEaten) {
            GandalfTheWhite.eat(food);
        }

        System.out.println(GandalfTheWhite);
    }
}


