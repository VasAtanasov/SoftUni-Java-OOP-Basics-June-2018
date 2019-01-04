package L16ExamPreparation.app.factories;

import L16ExamPreparation.app.entities.races.*;

public class RaceFactory {
    private RaceFactory() {

    }

    public static Race openRace(String raceType, int length, String route, int prizePool) {
        switch (raceType) {
            case "Casual":
                return new CasualRace(length, route, prizePool);
            case "Drag":
                return new DragRace(length, route, prizePool);
            case "Drift":
                return new DriftRace(length, route, prizePool);
        }
        return null;
    }

    public static Race openRace(String raceType, int length, String route, int prizePool, int extraParameter) {
        switch (raceType) {
            case "Circuit":
                return new CircuitRace(length, route, prizePool, extraParameter);
            case "TimeLimit":
                return new TimeLimitRace(length, route, prizePool, extraParameter);
        }
        return null;
    }
}

