package cutting;

import java.util.List;

public interface CuttingStrategy {
    CuttingResult cut(Sheet sheet, List<Sheet> parts);
}
