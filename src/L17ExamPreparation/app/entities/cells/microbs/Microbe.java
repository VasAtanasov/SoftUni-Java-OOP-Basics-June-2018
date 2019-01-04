package L17ExamPreparation.app.entities.cells.microbs;

import L17ExamPreparation.app.entities.cells.Cell;

public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

    @Override
    public String toString() {
        return super.toString() +
                System.lineSeparator() +
                String.format("--------Health: %d | Virulence: %d | Energy: %d", super.getHealth(), this.getVirulence(), this.getEnergy());
    }
}