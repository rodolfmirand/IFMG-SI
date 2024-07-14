package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelsReader {
    public static int[][] readPixels(String path) {

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(path));
            int width = bufferedImage.getWidth(null);
            int height = bufferedImage.getHeight(null);

            int[][] pixels = new int[width][height];

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    GreyScaleGetter.copyGreyScale(pixels, i, j, bufferedImage);
                }
            }

            return pixels;
        } catch (IOException ex) {
            System.err.println("Erro no caminho indicado pela imagem");
        }
        return null;
    }
}
