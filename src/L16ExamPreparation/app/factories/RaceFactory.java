package L16ExamPreparation.app.factories;

import L16ExamPreparation.app.entities.races.CasualRace;
import L16ExamPreparation.app.entities.races.DragRace;
import L16ExamPreparation.app.entities.races.DriftRace;
import L16ExamPreparation.app.entities.races.Race;

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
}
