package org.example;

import java.util.ArrayList;
import java.util.List;

public class CorrectPixels {
    public static int[][] correctPixels(int[][] originalImage) throws InterruptedException {

        //Pegando os valores das linhas e colunas da matriz e gerando uma nova para guardar os pixels corrigidos
        int row = originalImage.length;
        int column = originalImage[0].length;
        int[][] correctedImage = new int[row][column];

        //Pegando a quantidade de threads disponíveis
        int numberOfThreads = Runtime.getRuntime().availableProcessors();

        //Criando uma Lista de threads
        List<ImageCorrector> threads = new ArrayList<>(numberOfThreads);

        //Dividindo o número de linhas para cada thread
        int chunkHeight = row / numberOfThreads;

        for (int i = 0; i < numberOfThreads; i++) {
            //Definindo os pontos de inicio e fim para cada thread
            int startX = i * chunkHeight;
            int endX = (i == numberOfThreads - 1) ? row : (i + 1) * chunkHeight;

            //Instanciando uma nova thread, adicionando-a na Lista de Threads e a iniciando
            ImageCorrector thread = new ImageCorrector(originalImage, correctedImage, startX, endX, 0, column);
            threads.add(thread);
            thread.start();
        }

        //Esperando todas as threads terminarem de corrigir os pixels
        for (ImageCorrector thread : threads) {
            thread.join();
        }

        //Retornando a matriz corrigida
        return correctedImage;
    }

    public static int correctPixel(int[][] originalImage, int i, int j) {
        //Soma dos valores dos pixels em volta do pixel a se corrigir
        int valuePixelsSum = 0;
        //Número de pixels em volta do pixel a se corrigir
        int pixelsNumb = 0;
        //Número de pixels pretos em volta do pixel a se corrigir
        int blackPixelsNumb = 0;

        //Percorrendo os pixels em volta do pixel a se corrgir
        for (int i1 = -1; i1 <= 1; i1++) {
            for (int j1 = -1; j1 <= 1; j1++) {
                if (j1 + j >= 0 && j1 + j < originalImage[i].length && i1 + i >= 0 && i1 + i < originalImage.length) {

                    //Caso a posição do pixel percorrido seja igual a posição do pixel a se corrigir é passado para o próximo pixel
                    if (i1 + i == i && j1 + j == j) continue;

                    //Caso o pixel percorrido tenha valor 0 (preto) é somado 1 ao número de pixels pretos
                    if (originalImage[i1 + i][j1 + j] == 0) blackPixelsNumb++;

                    //Somando o valor do pixel percorrido à soma dos valores dos pixels percorridos
                    valuePixelsSum += originalImage[i1 + i][j1 + j];

                    //Somando 1 ao número de pixels percorridos
                    pixelsNumb++;
                }
            }
        }

        //Caso o número de pixels pretos seja maior que a quantidade de pixels percorridos é retornado 0
        if (blackPixelsNumb > (pixelsNumb - blackPixelsNumb)) {
            return 0;
        }

        //Caso contrário, é feito a média dos valores dos pixels percorridos
        return valuePixelsSum / pixelsNumb;
    }
}
