package L17ExamPreparation.app.factories;

import L17ExamPreparation.app.entities.Organism;

public final class OrganismFactory {

    private OrganismFactory() {

    }

    public static Organism create(String name) {
        return new Organism(name);
    }
}
