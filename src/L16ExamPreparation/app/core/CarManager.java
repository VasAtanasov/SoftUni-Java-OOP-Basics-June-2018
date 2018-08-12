package L16ExamPreparation.app.core;

import L16ExamPreparation.app.entities.Garage;
import L16ExamPreparation.app.entities.cars.Car;
import L16ExamPreparation.app.entities.races.Race;
import L16ExamPreparation.app.factories.CarFactory;
import L16ExamPreparation.app.factories.RaceFactory;
import L16ExamPreparation.app.repositories.CarsRepository;
import L16ExamPreparation.app.repositories.RacesRepository;
import L16ExamPreparation.app.utilities.Constants;

public class CarManager {
    private CarsRepository carRepository;
    private RacesRepository raceRepository;
    private Garage garage;

    public CarManager(CarsRepository carRepository, RacesRepository raceRepository) {
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
        this.garage = new Garage();
    }

    public void register(int id, String type, String brand, String model, int yearOfProduction, int horsepower, int acceleration, int suspension, int durability) {
        Car car = CarFactory.createCar(type, brand, model, yearOfProduction, horsepower, acceleration, suspension, durability);
        this.carRepository.put(id, car);
    }

    public String check(int id) {
        return carRepository.getDetails(id);
    }

    public void open(int id, String type, int length, String route, int prizePool) {
        Race race = RaceFactory.openRace(type, length, route, prizePool);
        this.raceRepository.put(id, race);
    }

    public void participate(int carId, int raceId) {
        if (! this.garage.contains(carId)) {
            this.raceRepository.get(raceId).add(carId, carRepository.get(carId));
        }
    }

    public String start(int id) {
        String result = Constants.NO_PARTICIPATNS;
        if (this.raceRepository.contains(id)) {
            Race race = this.raceRepository.get(id);
            if (race.hasParticipants()) {
                result = race.start();
                this.raceRepository.remove(id);
            }
        }
        return result;
    }

    public void park(int id) {
        boolean isParticipant = this.raceRepository.getCollection()
                .values()
                .stream()
                .anyMatch(race -> race.hasParticipant(id));
        if (! isParticipant) {
            this.garage.park(id, this.carRepository.get(id));
        }
    }

    public void unpark(int id) {
        this.garage.unpark(id);
    }

    public void tune(int tuneIndex, String addOn) {
        this.garage.tune(tuneIndex, addOn);
    }
}
