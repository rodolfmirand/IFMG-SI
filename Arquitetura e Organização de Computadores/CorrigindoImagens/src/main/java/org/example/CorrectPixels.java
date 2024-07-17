package org.example;

import java.util.ArrayList;
import java.util.List;

public class CorrectPixels {
    public static int[][] correctPixels(int[][] originalImage) throws InterruptedException {

        int row = originalImage.length;
        int column = originalImage[0].length;
        int[][] correctedImage = new int[row][column];

        int numberOfThreads = Runtime.getRuntime().availableProcessors();

        List<ImageCorrector> threads = new ArrayList<>(numberOfThreads);

        int chunkHeight = row / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            int startX = i * chunkHeight;
            int endX = (i == numberOfThreads - 1) ? row : (i + 1) * chunkHeight;
            ImageCorrector thread = new ImageCorrector(originalImage, correctedImage, startX, endX, 0, column);
            threads.add(thread);
            thread.start();
        }

        for (ImageCorrector thread : threads) {
            thread.join();
        }

        return correctedImage;
    }

    public static int correctPixel(int[][] originalImage, int i, int j) {
        int valuePixelsSum = 0;
        int pixelsNumb = 0;
        int blackPixelsNumb = 0;
        for (int i1 = -1; i1 <= 1; i1++) {
            for (int j1 = -1; j1 <= 1; j1++) {
                if (j1 + j >= 0 && j1 + j < originalImage[i].length && i1 + i >= 0 && i1 + i < originalImage.length) {
                    if (i1 + i == i && j1 + j == j) continue;
                    if (originalImage[i1 + i][j1 + j] == 0) blackPixelsNumb++;
                    valuePixelsSum += originalImage[i1 + i][j1 + j];
                    pixelsNumb++;
                }
            }
        }
        if (blackPixelsNumb > (pixelsNumb - blackPixelsNumb)) {
            return 0;
        }
        return valuePixelsSum / pixelsNumb;
    }
}
