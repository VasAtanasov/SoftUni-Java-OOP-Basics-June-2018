package L16ExamPreparation.app.entities;

import L16ExamPreparation.app.interfaces.Car;

import java.util.ArrayList;
import java.util.Collection;

public class Garage {
    private Collection<Car> parkedCars;

    public Garage() {
        this.parkedCars = new ArrayList<>();
    }
}
