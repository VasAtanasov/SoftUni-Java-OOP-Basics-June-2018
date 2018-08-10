package L16ExamPreparation.app.core;

import L16ExamPreparation.app.enums.CarType;
import L16ExamPreparation.app.factories.CarFactory;
import L16ExamPreparation.app.interfaces.Car;
import L16ExamPreparation.app.interfaces.CarManager;

public class CarManagerImpl implements CarManager {

    @Override
    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        CarType carType = CarType.valueOf(type.toUpperCase());
        Car car = CarFactory.createCar(carType, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        System.out.println("Car registered\n" + car.toString());
    }

    @Override
    public String check(int id) {
        return null;
    }

    @Override
    public void open(int id, String type, int length, String route, int prizePool) {

    }

    @Override
    public void participate(int carId, int raceId) {

    }

    @Override
    public String start(int id) {
        return null;
    }

    @Override
    public void park(int id) {

    }

    @Override
    public void unpark(int id) {

    }

    @Override
    public void tune(int tuneIndex, String addOn) {

    }
}
