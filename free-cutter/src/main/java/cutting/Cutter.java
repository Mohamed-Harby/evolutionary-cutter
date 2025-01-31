package cutting;

import visualize.CuttingVisualizer;

import java.util.List;

public class Cutter {
    private final CuttingStrategy strategy;

    public Cutter(CuttingStrategy strategy) {
        this.strategy = strategy;
    }

    public CuttingResult cut(Sheet sheet, List<Sheet> parts) {
        return strategy.cut(sheet, parts);
    }

    public static void main(String[] args) {
        Sheet metalSheet = new Sheet(100, 200);
        List<Sheet> parts = List.of(
                new Sheet(50, 50),
                new Sheet(30, 40),
                new Sheet(20, 30),
                new Sheet(10, 20)
        );

        Cutter cutter = new Cutter(new NaiveCuttingStrategy());
        CuttingResult cuttingResult = cutter.cut(metalSheet, parts);

        // Generate and save visualization
        CuttingVisualizer.drawCuttingResult(cuttingResult, "cutting_result.png");

    }
}
