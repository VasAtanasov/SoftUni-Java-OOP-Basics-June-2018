package L16ExamPreparation.app.entities.cars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class PerformanceCar extends BaseCar {
    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        //TODO set acceleration + 50% with setter;
        //TODO set suspension - 25% with setter;
        this.addOns = new ArrayList<>();
    }

    @Override
    public String toString() {
        String addOns = this.addOns.isEmpty() ? "None" : String.join(", ", this.addOns);
        return super.toString() +
                System.lineSeparator() +
                String.format("Add-ons: %s", addOns);
    }
}
