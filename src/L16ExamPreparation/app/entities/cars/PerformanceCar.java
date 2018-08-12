package L16ExamPreparation.app.entities.cars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PerformanceCar extends Car {
    private Collection<String> addOns;

    public PerformanceCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.setHorsepower(horsepower);
        this.setSuspension(suspension);
        this.addOns = new ArrayList<>();
    }

    @Override
    public void setHorsepower(int horsepower) {
        horsepower = horsepower + ((horsepower * 50) / 100);
        super.setHorsepower(horsepower);
    }

    @Override
    public void setSuspension(int suspension) {
        suspension = suspension - ((suspension * 25) / 100);
        super.setSuspension(suspension);
    }

    public void setSpecialProperty(List<String> commandParams) {
        int tuneIndex = Integer.parseInt(commandParams.get(0));
        super.setHorsepower(this.getHorsepower() + tuneIndex);
        super.setSuspension(this.getSuspension() + tuneIndex / 2);
        this.addOns.add(commandParams.get(1));
    }

    @Override
    public String toString() {
        String addOns = this.addOns.isEmpty() ? "None" : String.join(", ", this.addOns);
        return super.toString() +
                System.lineSeparator() +
                String.format("Add-ons: %s", addOns);
    }
}
