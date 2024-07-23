package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelsReader {
    public static int[][] readPixels(File file) {

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(file);
            int width = bufferedImage.getWidth(null);
            int height = bufferedImage.getHeight(null);

            int[][] pixels = new int[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    copyGreyScale(pixels, i, j, bufferedImage);
                }
            }

            return pixels;
        } catch (IOException ex) {
            System.err.println("Erro no caminho indicado pela imagem");
        }
        return null;
    }
    private static void copyGreyScale(int[][] pixel, int i, int j, BufferedImage bufferedImage) {
        float red = new Color(bufferedImage.getRGB(i, j)).getRed();
        float green = new Color(bufferedImage.getRGB(i, j)).getGreen();
        float blue = new Color(bufferedImage.getRGB(i, j)).getBlue();
        int greyScale = (int) (red + green + blue) / 3;
        pixel[i][j] = greyScale;
    }
}
