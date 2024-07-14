package org.example;

public class CorrectPixels {
    public static int[][] correctPixels(int imgOriginal[][]) {

        //este método você deve desenvolver e aprimorar para que tire proveito dos múltiplos núcleos de sua máquina
        int largura = imgOriginal.length;
        int altura = imgOriginal[0].length;
        int[][] imgCorrigida = new int[largura][altura];

        int pixelsValuesSum = 0;
        int pixelsValuesMean = 0;

        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                if (i == 0 && j == 0) {
                    System.out.println("topo esquerdo");
                    pixelsValuesSum += imgOriginal[i][j + 1]; //6
                    pixelsValuesSum += imgOriginal[i + 1][j];//8
                    pixelsValuesSum += imgOriginal[i + 1][j + 1];//9
                    pixelsValuesMean = pixelsValuesSum / 3;
                }
                if (j == largura - 1) {
                    System.out.println("topo direito");
                    pixelsValuesSum += imgOriginal[i][j - 1];//4
                    pixelsValuesSum += imgOriginal[i + 1][j - 1];//7
                    pixelsValuesSum += imgOriginal[i + 1][j];//8
                    pixelsValuesMean = pixelsValuesSum / 3;
                } else {
                    System.out.println("topo");
                    pixelsValuesSum += imgOriginal[i][j - 1];//4
                    pixelsValuesSum += imgOriginal[i][j + 1];//6
                    pixelsValuesSum += imgOriginal[i + 1][j - 1];//7
                    pixelsValuesSum += imgOriginal[i + 1][j];//8
                    pixelsValuesSum += imgOriginal[i + 1][j + 1];//9
                    pixelsValuesMean = pixelsValuesSum / 5;
                }
            
                if (i == altura - 1 && j == 0) {
                    System.out.println("baixo esquerdo");
                    pixelsValuesSum += imgOriginal[i - 1][j];//2
                    pixelsValuesSum += imgOriginal[i - 1][j + 1];//3
                    pixelsValuesSum += imgOriginal[i][j + 1];//6
                    pixelsValuesMean = pixelsValuesSum / 3;
                }
                if (j == largura - 1) {
                    System.out.println("baixo direito");
                    pixelsValuesSum += imgOriginal[i - 1][j - 1];//1
                    pixelsValuesSum += imgOriginal[i - 1][j];//2
                    pixelsValuesSum += imgOriginal[i][j - 1];//4
                    pixelsValuesMean = pixelsValuesSum / 3;
                } else {
                    System.out.println("baixo");
                    pixelsValuesSum += imgOriginal[i - 1][j - 1];//1
                    pixelsValuesSum += imgOriginal[i - 1][j];//2
                    pixelsValuesSum += imgOriginal[i - 1][j + 1];//3
                    pixelsValuesSum += imgOriginal[i - 1][j];//4
                    pixelsValuesSum += imgOriginal[i][j + 1];//6
                    pixelsValuesMean = pixelsValuesSum / 5;
                }

                if (j == largura - 1) {
                    System.out.println(("direito"));
                    pixelsValuesSum += imgOriginal[i - 1][j - 1];//1
                    pixelsValuesSum += imgOriginal[i - 1][j];//2
                    pixelsValuesSum += imgOriginal[i][j - 1];//4
                    pixelsValuesSum += imgOriginal[i + 1][j - 1];//7
                    pixelsValuesSum += imgOriginal[i + 1][j];//8
                    pixelsValuesMean = pixelsValuesSum / 5;
                } else if (j == 0) {
                    System.out.println("esquerdo");
                    pixelsValuesSum += imgOriginal[i - 1][j];//2
                    pixelsValuesSum += imgOriginal[i - 1][j + 1];//3
                    pixelsValuesSum += imgOriginal[i][j + 1];//6
                    pixelsValuesSum += imgOriginal[i + 1][j];//8
                    pixelsValuesSum += imgOriginal[i + 1][j + 1];//9
                    pixelsValuesMean = pixelsValuesSum / 5;
                } else {
                    System.out.println("meio");
                    pixelsValuesSum += imgOriginal[i - 1][j - 1];//1
                    pixelsValuesSum += imgOriginal[i - 1][j];//2
                    pixelsValuesSum += imgOriginal[i - 1][j + 1];//3
                    pixelsValuesSum += imgOriginal[i][j - 1];//4
                    pixelsValuesSum += imgOriginal[i][j + 1];//6
                    pixelsValuesSum += imgOriginal[i + 1][j - 1];//7
                    pixelsValuesSum += imgOriginal[i + 1][j];//8
                    pixelsValuesSum += imgOriginal[i + 1][j + 1];//9
                    pixelsValuesMean = pixelsValuesSum / 8;
                }

                imgCorrigida[i][j] = pixelsValuesMean;
            }
        }

        return null;
    }
}
