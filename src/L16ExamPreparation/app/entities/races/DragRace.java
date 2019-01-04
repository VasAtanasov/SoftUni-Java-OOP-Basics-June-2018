package L16ExamPreparation.app.entities.races;

import L16ExamPreparation.app.entities.cars.Car;

public class DragRace extends Race {
    public DragRace(int length, String route, int prizePool) {
        super(length, route, prizePool);
    }

    @Override
    public int getPerformancePoints(Car car) {
        return car.getHorsepower() / car.getAcceleration();
    }
}
