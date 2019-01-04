package L10PolymorphismExercises.ex01Vehicles;

public class Car extends Vehicle {
    protected Car(double fuelQuantity, double fuelConsumption) {
        super(fuelQuantity, fuelConsumption, 0.9);
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
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }
}
