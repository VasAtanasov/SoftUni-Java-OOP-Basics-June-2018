package L16ExamPreparation.app.repositories;

import L16ExamPreparation.app.entities.cars.Car;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarsRepository  {
    private Map<Integer, Car> cars;

    public CarsRepository() {
        this.cars = new LinkedHashMap<>();
    }

    public Car get(int id) {
        return this.cars.get(id);
    }

    public boolean contains(int id) {
        return this.cars.containsKey(id);
    }

    public Car remove(int id) {
        return this.cars.remove(id);
    }

    public void put(int id, Car element) {
        this.cars.putIfAbsent(id, element);
    }

    public String getDetails(int id) {
        return this.cars.get(id).toString();
    }

    public Map<Integer, Car> getCollection() {
        return Collections.unmodifiableMap(this.cars);
    }
}
