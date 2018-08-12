package L16ExamPreparation.app.entities.races;

import L16ExamPreparation.app.entities.cars.Car;

public class DriftRace extends Race {
    public DriftRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public int getPerformancePoints(Car car) {
        return car.getSuspension() + car.getDurability();
    }
}
