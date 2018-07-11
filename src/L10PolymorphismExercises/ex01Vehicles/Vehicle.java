package L10PolymorphismExercises.ex01Vehicles;

public abstract class Vehicle implements Drivable {
    private double fuelQuantity;
    private double fuelConsumption;

    Vehicle(double fuelQuantity, double fuelConsumption, double airConConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption + airConConsumption;
    }

    double getFuelQuantity() {
        return this.fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    double getFuelConsumption() {
        return this.fuelConsumption;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
