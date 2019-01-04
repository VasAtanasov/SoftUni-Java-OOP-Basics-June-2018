package L16ExamPreparation.app.entities;

import L16ExamPreparation.app.entities.cars.Car;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Garage {
    private Map<Integer, Car> parkedCars;

    public Garage() {
        this.parkedCars = new HashMap<>();
    }

    public boolean contains(int id) {
        return parkedCars.containsKey(id);
    }

    public void park(int id, Car car) {
        this.parkedCars.putIfAbsent(id, car);
    }

    public void unpark(int id) {
        this.parkedCars.remove(id);
    }

    public void tune(int tuneIndex, String addOn) {
        if (this.parkedCars.isEmpty()) {
            return;
        }

        this.parkedCars
                .values()
                .forEach(car -> {
//                    car.setHorsepower(car.getHorsepower() + tuneIndex);
//                    car.setSuspension(car.getSuspension() + (tuneIndex / 2));
                    car.setSpecialProperty(Arrays.asList(String.valueOf(tuneIndex), addOn));
                });

    }
}
