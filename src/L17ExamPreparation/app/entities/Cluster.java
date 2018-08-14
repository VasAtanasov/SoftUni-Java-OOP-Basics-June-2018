package L17ExamPreparation.app.entities;

import L17ExamPreparation.app.entities.cells.Cell;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static L17ExamPreparation.app.utilities.Constants.*;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

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

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public void add(Cell cell) {
        this.cells.add(cell);
    }

    public void activate() {
        while (this.cells.size() > 1) {
            this.cells = this.cells
                    .stream()
                    .sorted(Comparator.comparingInt(Cell::getPositionRow).thenComparingInt(Cell::getPositionCol))
                    .collect(Collectors.toCollection(ArrayList::new));

            Cell attackingCell = this.cells.remove(0);

            switch (attackingCell.getClass().getSimpleName()) {
                case RED_BLOOD_CELL:
                case WHITE_BLOOD_CELL:
                    bloodCellActivation(attackingCell);
                    break;
                case BACTERIA:
                case FUNGI:
                case VIRUS:
                    attackingCell = microbeActivation(attackingCell);
                    break;
            }

            this.cells.add(attackingCell);
        }
    }

    private Cell microbeActivation(Cell attackingCell) {
        while (this.cells.size() > 0) {
            Cell targetCell = this.cells.remove(0);

            while (attackingCell.getHealth() > 0 && targetCell.getHealth() > 0) {
                targetCell.setHealth(targetCell.getHealth() - attackingCell.getEnergy());
                if (targetCell.getHealth() <= 0) {
                    break;
                }
                attackingCell.setHealth(attackingCell.getHealth() - targetCell.getEnergy());
            }

            if (attackingCell.getHealth() < 0) {
                attackingCell = targetCell;

            } else {
                attackingCell.setPositionRow(targetCell.getPositionRow());
                attackingCell.setPositionCol(targetCell.getPositionCol());
            }

            if (attackingCell.getClass().getSimpleName().equals(RED_BLOOD_CELL) && attackingCell.getClass().getSimpleName().equals(WHITE_BLOOD_CELL)) {
                break;
            }
        }
        return attackingCell;
    }

    private void bloodCellActivation(Cell attackingCell) {
        int healthCollected = this.getCellsHealth();
        attackingCell.setHealth(attackingCell.getHealth() + healthCollected);
        Cell cell = this.cells.get(this.cells.size() - 1);
        attackingCell.setPositionRow(cell.getPositionRow());
        attackingCell.setPositionCol(cell.getPositionCol());
        this.cells.clear();
    }

    private int getCellsHealth() {
        return this.cells
                .stream()
                .map(Cell::getHealth)
                .reduce(0, (a, b) -> a + b);
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