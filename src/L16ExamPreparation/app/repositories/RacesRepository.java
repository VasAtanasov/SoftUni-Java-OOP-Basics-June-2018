package L16ExamPreparation.app.repositories;

import L16ExamPreparation.app.entities.races.Race;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class RacesRepository {
    private Map<Integer, Race> races;

    public RacesRepository() {
        this.races = new LinkedHashMap<>();
    }

    public Race get(int id) {
        return races.get(id);
    }

    public boolean contains(int id) {
        return this.races.containsKey(id);
    }

    public Race remove(int id) {
        return this.races.remove(id);
    }

    public void put(int id, Race element) {
        this.races.putIfAbsent(id, element);
    }

    public String getDetails(int id) {
        return this.races.get(id).toString();
    }

    public Map<Integer, Race> getCollection() {
        return Collections.unmodifiableMap(this.races);
    }


}
