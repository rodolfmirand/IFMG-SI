package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PixelsRecorder {

    public static void recordPixels(String pathToRecord, int pixels[][]) {

        pathToRecord = pathToRecord
                .replace(".png", "_modificado.png")
                .replace(".jpg", "_modificado.jpg");

        int width = pixels.length;
        int height = pixels[0].length;

        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        byte[] bytesPixels = new byte[width * height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                bytesPixels[y * (width) + x] = (byte) pixels[x][y];
            }
        }

        image.getRaster().setDataElements(0, 0, width, height, bytesPixels);

        File ImageFile = new File(pathToRecord);
        try {
            ImageIO.write(image, "png", ImageFile);
            System.out.println("Nova Imagem dispon. em: " + pathToRecord);
        } catch (IOException e) {
            System.err.println("Erro no caminho indicado pela imagem");
        }
    }
}
