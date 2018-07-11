package L06EncapsulationExercises.ex03AnimalFarm;

import java.text.DecimalFormat;

public class Chicken {
    private static DecimalFormat df = new DecimalFormat("0.##");

    private String name;
    private int age;
    private double dailyEggProduction;

    public Chicken(String name, int age) {
        this.setName(name);
        this.setAge(age);
        this.setDailyEggProduction(age);
    }

    private void setName(String name) {
        if (name == null || name.isEmpty() || name.equals(" ")) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    private void setDailyEggProduction(int age) {
        if (age < 6) {
            this.dailyEggProduction = 2;
        } else if (age < 12) {
            this.dailyEggProduction = 1;
        } else {
            this.dailyEggProduction = 0.75;
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day."
                , this.name, this.age, df.format(this.dailyEggProduction));
    }
}
