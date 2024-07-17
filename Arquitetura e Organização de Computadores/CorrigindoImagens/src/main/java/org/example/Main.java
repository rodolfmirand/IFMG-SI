package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        File directory = new File("D:\\Download\\projeto e arquivos para o problema de imagens\\Imagens\\modificadas");
//        File[] imagesFile = directory.listFiles();

        String imagePath = "D:\\Download\\projeto e arquivos para o problema de imagens\\Imagens\\modificadas\\img (1).jpg";
        File image = new File(imagePath);
        int[][] imageMatrix = PixelsReader.readPixels(image);
        int[][] correctedImage = CorrectPixels.correctPixels(imageMatrix);
        PixelsRecorder.recordPixels(imagePath, correctedImage);
    }
}