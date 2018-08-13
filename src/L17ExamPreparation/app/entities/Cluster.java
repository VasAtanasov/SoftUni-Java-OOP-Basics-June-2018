package L17ExamPreparation.app.entities;

import L17ExamPreparation.app.entities.cells.Cell;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;

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

    public String getId() {
        return this.id;
    }

    public int getCellCount() {
        return this.cells.size();
    }

    public void add(Cell cell) {
        this.cells.add(cell);
    }

    @Override
    public String toString() {
        String cellsString = this.cells
                .stream()
                .sorted(Comparator.comparingInt(Cell::getPositionRow).thenComparingInt(Cell::getPositionCol))
                .map(Cell::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format("----Cluster %s", this.getId()) +
                System.lineSeparator() +
                cellsString;
    }
}