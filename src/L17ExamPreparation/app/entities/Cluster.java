package L17ExamPreparation.app.entities;

import L17ExamPreparation.app.entities.cells.Cell;

import java.util.ArrayList;
import java.util.Collection;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private Collection<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}