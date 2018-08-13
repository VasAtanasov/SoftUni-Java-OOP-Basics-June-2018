package L17ExamPreparation.app.factories;

import L17ExamPreparation.app.entities.cells.Cell;
import L17ExamPreparation.app.entities.cells.blood.RedBloodCell;
import L17ExamPreparation.app.entities.cells.blood.WhiteBloodCell;
import L17ExamPreparation.app.entities.cells.microbs.Bacteria;
import L17ExamPreparation.app.entities.cells.microbs.Fungi;
import L17ExamPreparation.app.entities.cells.microbs.Virus;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class CellFactory {
    private static Map<String, BiFunction<String, int[], Cell>> cellModels;

    static {
        cellModels = new HashMap<>() {{
            put("WhiteBloodCell", (id, params) -> new WhiteBloodCell(id, params[0], params[1], params[2], params[3]));
            put("RedBloodCell", (id, params) -> new RedBloodCell(id, params[0], params[1], params[2], params[3]));
            put("Bacteria", (id, params) -> new Bacteria(id, params[0], params[1], params[2], params[3]));
            put("Fungi", (id, params) -> new Fungi(id, params[0], params[1], params[2], params[3]));
            put("Virus", (id, params) -> new Virus(id, params[0], params[1], params[2], params[3]));
        }};
    }

    private CellFactory() {

    }

    public static Cell create(String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return cellModels.get(cellType).apply(cellId, new int[] {health, positionRow, positionCol, additionalProperty});
    }
}
