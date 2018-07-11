package L07Inheritance.ex04FragileBaseClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Animal {
    protected List<Food> foodEaten;

    public Animal() {
        this.foodEaten = new ArrayList<>();
    }

    public final void eat(Food food) {
        foodEaten.add(food);
    }

    public void eatAll(Food[] foods) {
        Arrays
                .stream(foods)
                .forEach(this::eat);
    }
}
