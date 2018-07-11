package L06EncapsulationExercises.ex05PizzaCalories;

import java.util.HashMap;
import java.util.Map;

public class Dough implements Eatable {
    private static final int CALORIES_PER_GRAM = 2;
    private static final Map<String, Double> MODIFIERS = new HashMap<>() {{
        put("White", 1.5);
        put("Wholegrain", 1.0);
        put("Crispy", 0.9);
        put("Chewy", 1.1);
        put("Homemade", 1.0);
    }};

    private double weight;
    private double flourTypeModifier;
    private double bakingTechniqueModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourTypeModifier(flourType);
        this.setBakingTechniqueModifier(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourTypeModifier(String flourType) {
        if (! Dough.MODIFIERS.containsKey(flourType)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourTypeModifier = Dough.MODIFIERS.get(flourType);
    }

    private void setBakingTechniqueModifier(String bakingTechnique) {
        if (! Dough.MODIFIERS.containsKey(bakingTechnique)) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechniqueModifier = Dough.MODIFIERS.get(bakingTechnique);
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    @Override
    public double getTotalCalories() {
        return (CALORIES_PER_GRAM * this.weight) * this.flourTypeModifier * this.bakingTechniqueModifier;
    }
}
