package L16ExamPreparation.app.entities.cars;


import java.util.List;

public class ShowCar extends Car {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    public void setSpecialProperty(List<String> commandParams) {
        int tuneIndex = Integer.parseInt(commandParams.get(0));
        super.setHorsepower(this.getHorsepower() + tuneIndex);
        super.setSuspension(this.getSuspension() + tuneIndex / 2);
        this.stars += tuneIndex;
    }

    @Override
    public String toString() {
        return super.toString() +
                System.lineSeparator() +
                String.format("%d *", this.stars);
    }
}
