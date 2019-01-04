package L16ExamPreparation.app.entities.races;

import L16ExamPreparation.app.entities.cars.Car;

public class CasualRace extends Race {
    public CasualRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public int getPerformancePoints(Car car) {
        return (car.getHorsepower() / car.getAcceleration()) + (car.getSuspension() + car.getDurability());
    }
}
