package cutting;

import java.util.List;

public class CuttingResult {
    private final Sheet sheet;
    private final List<Position> positions;

    public CuttingResult(Sheet sheet, List<Position> positions) {
        this.sheet = sheet;
        this.positions = List.copyOf(positions);
    }

    public Sheet getSheet() {
        return sheet;
    }

    public List<Position> getPositions() {
        return positions;
    }

    @Override
    public String toString() {
        return "cutting.CuttingResult{" + "sheet=" + sheet + ", positions=" + positions + '}';
    }
}
