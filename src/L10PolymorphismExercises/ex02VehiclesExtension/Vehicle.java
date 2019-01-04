package L10PolymorphismExercises.ex02VehiclesExtension;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumption;
    private double tankCapacity;
    private double airConConsumption;

    Vehicle(double fuelQuantity, double fuelConsumption, double tankCapacity, double airConConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
        this.airConConsumption = airConConsumption;
        this.tankCapacity = tankCapacity;
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

    private double getTankCapacity() {
        return this.tankCapacity;
    }

    private double getAirConConsumption() {
        return this.airConConsumption;
    }

    boolean drive(double distance) {
        double fuelNeeded = (this.getFuelConsumption() + this.getAirConConsumption()) * distance;
        if (fuelNeeded <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return true;
        }
        return false;
    }

    boolean driveAirConOff(double distance) {
        double fuelNeeded = (this.getFuelConsumption()) * distance;
        if (fuelNeeded <= this.getFuelQuantity()) {
            this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
            return true;
        }
        return false;
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }
        if (this.getFuelQuantity() + fuel > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.getFuelQuantity());
    }
}
