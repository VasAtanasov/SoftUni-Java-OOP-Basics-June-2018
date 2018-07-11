package L10PolymorphismExercises.ex01Vehicles;

public class Truck extends Vehicle {
    protected Truck(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, 1.6);
    }

    @Override
    public boolean drive(double distance) {
        double fuelNeeded = this.getFuelConsumption() * distance;
        if (fuelNeeded <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return true;
        }
        return false;
    }

    @Override
    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + (fuel * 0.95));
    }
}
