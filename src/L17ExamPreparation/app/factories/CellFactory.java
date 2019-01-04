package L17ExamPreparation.app.factories;

import L17ExamPreparation.app.entities.cells.Cell;
import L17ExamPreparation.app.entities.cells.blood.RedBloodCell;
import L17ExamPreparation.app.entities.cells.blood.WhiteBloodCell;
import L17ExamPreparation.app.entities.cells.microbs.Bacteria;
import L17ExamPreparation.app.entities.cells.microbs.Fungi;
import L17ExamPreparation.app.entities.cells.microbs.Virus;


import static L17ExamPreparation.app.utilities.Constants.*;

public final class CellFactory {

    private CellFactory() {

    }

    public static Cell create(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        switch (cellType) {
            case WHITE_BLOOD_CELL:
                return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case RED_BLOOD_CELL:
                return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
            case BACTERIA:
                return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
            case VIRUS:
                return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
            case FUNGI:
                return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
        }
        return null;
    }
}
