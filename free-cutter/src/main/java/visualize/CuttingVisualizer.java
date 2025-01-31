package visualize;

import cutting.CuttingResult;
import cutting.Position;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CuttingVisualizer {

    private static final int SCALE = 5; // Scale factor to make the image larger

    public static void drawCuttingResult(CuttingResult result, String filename) {
        int width = (int) result.getSheet().getWidth() * SCALE;
        int height = (int) result.getSheet().getHeight() * SCALE;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Enable anti-aliasing for better quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the main sheet (background)
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fillRect(0, 0, width, height);

        // Draw each part
        g2d.setColor(Color.DARK_GRAY);
        for (Position pos : result.getPositions()) {
            int x = (int) pos.getX() * SCALE;
            int y = (int) pos.getY() * SCALE;
            int partWidth = (int) pos.getSheet().getWidth() * SCALE;
            int partHeight = (int) pos.getSheet().getHeight() * SCALE;

            g2d.fillRect(x, y, partWidth, partHeight);
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.drawRect(x, y, partWidth, partHeight); // Border

            // Label each part
            g2d.setColor(Color.WHITE);
            g2d.drawString(partWidth / SCALE + "x" + partHeight / SCALE, x + 5, y + 15);
            g2d.setColor(Color.DARK_GRAY);
        }

        // Dispose graphics and save image
        g2d.dispose();

        try {
            ImageIO.write(image, "png", new File(filename));
            System.out.println("Cutting visualization saved as: " + filename);
        } catch (IOException e) {
            System.err.println("Error saving image: " + e.getMessage());
        }
    }
}
