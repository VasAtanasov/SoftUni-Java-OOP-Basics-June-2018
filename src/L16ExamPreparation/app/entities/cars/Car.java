package L16ExamPreparation.app.entities.cars;


import java.util.List;

public abstract class Car {
    private String brand;
    private String model;
    private int yearOfProduction;
    private int horsepower;
    private int acceleration;
    private int suspension;
    private int durability;

    protected Car(String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.horsepower = horsepower;
        this.acceleration = acceleration;
        this.suspension = suspension;
        this.durability = durability;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getModel() {
        return this.model;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    public int getAcceleration() {
        return this.acceleration;
    }

    public int getSuspension() {
        return this.suspension;
    }

    public int getDurability() {
        return this.durability;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    public void setSuspension(int suspension) {
        this.suspension = suspension;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public abstract void setSpecialProperty(List<String> commandParams);

    @Override
    public String toString() {
        return String.format("%s %s %d", this.brand, this.model, this.yearOfProduction) +
                System.lineSeparator() +
                String.format("%d HP, 100 m/h in %d s", this.horsepower, this.acceleration) +
                System.lineSeparator() +
                String.format("%d Suspension force, %d Durability", this.suspension, this.durability);
    }
}
