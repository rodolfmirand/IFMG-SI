package ordenacao;

import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[500000];
        Random rnd = new Random(17);
        /*
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(10000000);
        }
        
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
         */
        int r = 0;
        for (int i = 1000; i > 0; i--) {
            array[r] = i;
        }
         
        long startTime = System.nanoTime();

        quickSort(array, 0, array.length - 1);

        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println(timeElapsed);

    }

    public static void quickSort(int v[], int esq, int dir) {
        if (esq < dir) {
            int p = part(v, esq, dir);
            quickSort(v, esq, p);
            quickSort(v, p + 1, dir);
        }
    }

    public static int part(int v[], int esq, int dir) {
        int meio = (int) (esq + dir) / 2;
        int pivo = v[meio];
        int i = esq - 1;
        int j = dir + 1;
        while (true) {
            do {
                i++;
            } while (v[i] < pivo);
            do {
                j--;
            } while (v[j] > pivo);
            if (i >= j) {
                return j;
            }
            int aux = v[i];
            v[i] = v[j];
            v[j] = aux;
        }
    }
}
