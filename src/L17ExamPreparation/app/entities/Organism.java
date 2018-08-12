package L17ExamPreparation.app.entities;

import java.util.ArrayList;
import java.util.Collection;

public class Organism {
    private String name;
    private Collection<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


