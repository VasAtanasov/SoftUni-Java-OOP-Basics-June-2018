package L16ExamPreparation.app.entities.cars;


public class ShowCar extends BaseCar {
    private int stars;

    public ShowCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        super(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.stars = 0;
    }

    @Override
    public String toString() {
        return super.toString() +
                System.lineSeparator() +
                String.format("%d * ", this.stars);
    }
}
