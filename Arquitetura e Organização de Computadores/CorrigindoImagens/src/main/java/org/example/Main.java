package org.example;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static int[][] lerPixels(String caminho) {

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File(caminho));
            int largura = bufferedImage.getWidth(null);
            int altura = bufferedImage.getHeight(null);

            int[][] pixels = new int[largura][altura];
            for (int i = 0; i < largura; i++) {
                for (int j = 0; j < altura; j++) {
                    //normalizando de forma simplificada para imagem escala de cinza (é esperado ocorrer "clareamento")
                    float vermelho = new Color(bufferedImage.getRGB(i, j)).getRed();
                    float verde = new Color(bufferedImage.getRGB(i, j)).getGreen();
                    float azul = new Color(bufferedImage.getRGB(i, j)).getBlue();
                    int escalaCinza = (int) (vermelho + verde + azul) / 3;

                    pixels[i][j] = escalaCinza;
                }
            }

            return pixels;
        } catch (IOException ex) {
            System.err.println("Erro no caminho indicado pela imagem");
        }

        return null;
    }

    public static void gravarPixels(String caminhoGravar, int pixels[][]) {

        caminhoGravar = caminhoGravar
                .replace(".png", "_modificado.png")
                .replace(".jpg", "_modificado.jpg");

        int largura = pixels.length;
        int altura = pixels[0].length;

        BufferedImage imagem = new BufferedImage(largura, altura, BufferedImage.TYPE_BYTE_GRAY);

        //transformando a mat. em um vetor de bytes
        byte bytesPixels[] = new byte[largura * altura];
        for (int x = 0; x < largura; x++) {
            for (int y = 0; y < altura; y++) {
                bytesPixels[y * (largura) + x] = (byte) pixels[x][y];
            }
        }

        //copiando todos os bytes para a nova imagem
        imagem.getRaster().setDataElements(0, 0, largura, altura, bytesPixels);

        //criamos o arquivo e gravamos os bytes da imagem nele
        File ImageFile = new File(caminhoGravar);
        try {
            ImageIO.write(imagem, "png", ImageFile);
            System.out.println("Nova Imagem dispon. em: " + caminhoGravar);
        } catch (IOException e) {
            System.err.println("Erro no caminho indicado pela imagem");
        }
    }


    public static int[][] corrigirImagem(int imgOriginal[][]) {

        //estemétodo você deve desenvolver e aprimorar para que tire proveito dos múltiplos núcleos de sua máquina
        int largura = imgOriginal.length;
        int altura = imgOriginal[0].length;
        int[][] imgCorrigida = new int[largura][altura];

        for (int i = 0; i < largura; i++) {
            for (int j = 0; j < altura; j++) {
                if(i == largura-1){
                    if(j == altura-1){

                    }
                }

                int[][] pixel1 = new int[i - 1][j - 1];
                int[][] pixel2 = new int[i][j - 1];
                int[][] pixel3 = new int[i + 1][j - 1];
                int[][] pixel4 = new int[i - 1][j];
                int[][] pixel6 = new int[i + 1][j];
                int[][] pixel7 = new int[i - 1][j - 1];
                int[][] pixel8 = new int[i][j + 1];
                int[][] pixel9 = new int[i + 1][j + 1];
            }
        }

        return null;
    }

    public static void main(String[] args) {

        File directory = new File("C:\\Users\\rodol\\Downloads\\projeto e arquivos para o problema de imagens\\Imagens\\modificadas");
        File imagesFile[] = directory.listFiles();

        //iamgens que precisam ser corrigidas
        for (File img : imagesFile) {
            int imgMat[][] = lerPixels(img.getAbsolutePath());


            //fica a seu critério modificar essa invocação
            imgMat = corrigirImagem(imgMat);


            //grava nova imagem com as correções
            if (imgMat != null) {
                gravarPixels(img.getAbsolutePath(), imgMat);
            }
        }
    }
}