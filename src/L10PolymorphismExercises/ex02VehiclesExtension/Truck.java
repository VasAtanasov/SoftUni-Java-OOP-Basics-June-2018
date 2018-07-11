package L10PolymorphismExercises.ex02VehiclesExtension;

public class Truck extends Vehicle {
    Truck(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption, tankCapacity, 1.6);
    }

    @Override
    public void refuel(double fuel) {
        double remainingFuel = this.getFuelQuantity();
        super.refuel(fuel);
        this.setFuelQuantity(remainingFuel + (fuel * 0.95));
    }
}
