package org.example;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GreyScaleGetter {

    public static void copyGreyScale(int[][] pixel, int i, int j, BufferedImage bufferedImage) {
        float red = new Color(bufferedImage.getRGB(i, j)).getRed();
        float green = new Color(bufferedImage.getRGB(i, j)).getGreen();
        float blue = new Color(bufferedImage.getRGB(i, j)).getBlue();
        int greyScale = (int) (red + green + blue) / 3;
        pixel[i][j] = greyScale;
    }
}
