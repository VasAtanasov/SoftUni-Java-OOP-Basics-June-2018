package L16ExamPreparation.app.entities.races;

import L16ExamPreparation.app.interfaces.Car;
import L16ExamPreparation.app.interfaces.Race;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseRace implements Race {
    private int lenght;
    private String route;
    private int prizePool;
    private Collection<Car> participants;

    protected BaseRace(int length, String route, int prizePool) {
        this.lenght = length;
        this.route = route;
        this.prizePool = prizePool;
        this.participants = new ArrayList<>();
    }



    @Override
    public String toString() {
        return super.toString();
    }
}
