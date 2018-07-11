package L06EncapsulationExercises.ex04ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> bagOfProducts;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.bagOfProducts = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    boolean buy(Product product) {
        if (product.getPrice() > this.money) {
            return false;
        } else {
            this.bagOfProducts.add(product);
            this.money -= product.getPrice();
            return true;
        }
    }

    @Override
    public String toString() {
        if (bagOfProducts.isEmpty()) {
            return this.name + " - Nothing bought";
        }
        return String.format("%s - %s", this.name,
                this.bagOfProducts.toString().replaceAll("[\\[\\]]", ""));
    }
}
