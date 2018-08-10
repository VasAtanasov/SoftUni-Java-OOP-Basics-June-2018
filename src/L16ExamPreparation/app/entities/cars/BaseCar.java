package L16ExamPreparation.app.entities.cars;

import L16ExamPreparation.app.interfaces.Car;

public abstract class BaseCar implements Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected BaseCar(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    protected void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    protected void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", this.brand, this.model, this.yearOfProduction) +
                System.lineSeparator() +
                String.format("%d HP, 100 m/h in %d s", this.horsepower, this.acceleration) +
                System.lineSeparator() +
                String.format("%d Suspension force, %d Durability", this.suspension, this.durability);
    }
}
