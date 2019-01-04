package L16ExamPreparation.app.factories;

import L16ExamPreparation.app.entities.cars.Car;
import L16ExamPreparation.app.entities.cars.PerformanceCar;
import L16ExamPreparation.app.entities.cars.ShowCar;

public class CarFactory {
    private CarFactory() {

    }

    public static Car createCar(String carType, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        switch (carType) {
            case "Performance":
                return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            case "Show":
                return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        }
        return null;
    }
}
