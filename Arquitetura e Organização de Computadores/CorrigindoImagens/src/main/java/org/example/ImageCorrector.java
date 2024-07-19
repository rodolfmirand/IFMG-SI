package org.example;

public class ImageCorrector extends Thread{

    private final int[][] originalImage;
    private final int[][] correctedImage;
    private final int startX, endX, startY, endY;

    public ImageCorrector(int[][] originalImage, int[][] correctedImage, int startX, int endX, int startY, int endY) {
        this.originalImage = originalImage;
        this.correctedImage = correctedImage;
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    @Override
    public void run() {
        //Os pontos de inicio e fim foram definidos quando a thread foi instanciada
        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {
                //Verificando se o pixel possui valor 0 (preto) ou branco (255) para que seja corrigido
                //Caso verdadeiro, ele será corrigido
                //Caso falso, ele irá copiar o valor da matriz original
                if (originalImage[i][j] == 255 || originalImage[i][j] == 0) {
                    correctedImage[i][j] = CorrectPixels.correctPixel(originalImage, i, j);
                } else {
                    correctedImage[i][j] = originalImage[i][j];
                }
            }
        }
    }
}
