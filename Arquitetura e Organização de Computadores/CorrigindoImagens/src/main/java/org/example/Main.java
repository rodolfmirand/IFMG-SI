package org.example;

import java.io.File;

public class Main {

    public static int[][] correctPixels(int[][] imgOriginal) {

        int row = imgOriginal.length;
        int column = imgOriginal[0].length;
        int[][] imgCorrigida = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (imgOriginal[i][j] == 255 || imgOriginal[i][j] == 0) {
                    imgCorrigida[i][j] = correctPixel(imgOriginal, i, j);
                    continue;
                }
                imgCorrigida[i][j] = imgOriginal[i][j];
            }
        }
        return imgCorrigida;
    }

    private static int correctPixel(int[][] imgOriginal, int i, int j) {
        int valuePixelsSum = 0;
        int pixelsNumb = 0;
        int blackPixelsNumb = 0;
        for (int i1 = -1; i1 <= 1; i1++) {
            for (int j1 = -1; j1 <= 1; j1++) {
                if (j1 + j >= 0 && j1 + j < imgOriginal[i].length && i1 + i >= 0 && i1 + i < imgOriginal.length) {
                    if (i1 + i == i && j1 + j == j) continue;
                    if(imgOriginal[i1 + i][j1 + j] < 100) blackPixelsNumb++;
                    valuePixelsSum += imgOriginal[i1 + i][j1 + j];
                    pixelsNumb++;
                }
            }
        }
        if(blackPixelsNumb > (pixelsNumb-blackPixelsNumb)){
            return 0;
        }
        return valuePixelsSum / pixelsNumb;
    }

    public static void main(String[] args) {

        //File directory = new File("C:\\Users\\rodol\\Downloads\\projeto e arquivos para o problema de imagens\\Imagens\\modificadas");
        //File imagesFile[] = directory.listFiles();

        File image = new File("D:\\Download\\projeto e arquivos para o problema de imagens\\Imagens\\modificadas\\img (1).jpg");
        int[][] imageMatrix = PixelsReader.readPixels(image.getAbsolutePath());

        assert imageMatrix != null;
        int[][] correctedImage = correctPixels(imageMatrix);

        PixelsRecorder.recordPixels(image.getAbsolutePath(), correctedImage);

        //iamgens que precisam ser corrigidas
//        for (File img : imagesFile) {
//            int imageMatrix[][] = PixelsReader.readPixels(img.getAbsolutePath());
//
//            //fica a seu critério modificar essa invocação
//            imageMatrix = correctPixels(imageMatrix);
//
//            //grava nova imagem com as correções
//            if (imageMatrix != null) {
//                PixelsRecorder.recordPixels(img.getAbsolutePath(), imageMatrix);
//            }
//        }
    }
}