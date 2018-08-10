package L16ExamPreparation.app.factories;

import L16ExamPreparation.app.entities.cars.PerformanceCar;
import L16ExamPreparation.app.entities.cars.ShowCar;
import L16ExamPreparation.app.enums.CarType;
import L16ExamPreparation.app.interfaces.Car;

public class CarFactory {
    private CarFactory() {

    }

    public static Car createCar(CarType carType, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        switch (carType) {
            case PERFORMANCE:
                return new PerformanceCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
            case SHOW:
                return new ShowCar(brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        }
        return null;
    }
}
