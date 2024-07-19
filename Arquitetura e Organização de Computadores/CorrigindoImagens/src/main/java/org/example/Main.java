package org.example;

import java.io.File;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Extraindo os arquivos do diretório definido
        File directory = new File("D:\\Download\\projeto e arquivos para o problema de imagens\\Imagens\\modificadas");

        //Dividindo os arquivos em um vetor
        File[] imagesFile = directory.listFiles();

        //Para cada arquivos, será feitos o seguintes métodos
        for (File image : imagesFile) {

            //Pegando o diretório da imagem
            String imagePath = image.getAbsolutePath();

            //Lendo os pixels da imagem e guardando-os em uma matriz de inteiros com os valores de cada pixel
            int[][] imageMatrix = PixelsReader.readPixels(image);

            //Corrigindo os pixels defeituosos e os guardando em uma nova matriz
            int[][] correctedImage = CorrectPixels.correctPixels(imageMatrix);

            //Gravando no disco a matriz corrigida da imagem
            PixelsRecorder.recordPixels(imagePath, correctedImage);
        }
    }
}