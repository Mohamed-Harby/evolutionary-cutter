package cutting;

import java.util.ArrayList;
import java.util.List;

public class NaiveCuttingStrategy implements CuttingStrategy {
    @Override
    public CuttingResult cut(Sheet sheet, List<Sheet> parts) {
        long x = 0;
        long y = 0;
        List<Position> positions = new ArrayList<>();

        for (Sheet part : parts) {
            if (x + part.getWidth() > sheet.getWidth()) {
                x = 0;
                y += part.getHeight();
            }
            if (y + part.getHeight() > sheet.getHeight()) {
                break; // Stop placing if it overflows
            }
            positions.add(new Position(part, x, y));
            x += part.getWidth();
        }

        return new CuttingResult(sheet, positions);
    }
}
