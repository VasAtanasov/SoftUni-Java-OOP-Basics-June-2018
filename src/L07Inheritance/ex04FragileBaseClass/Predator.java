package L07Inheritance.ex04FragileBaseClass;

public class Predator extends Animal {
    private int health;

    public void feed(Food food) {
        super.eat(food);
    }
}
