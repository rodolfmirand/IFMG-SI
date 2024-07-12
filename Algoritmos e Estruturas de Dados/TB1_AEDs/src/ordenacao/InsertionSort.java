/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenacao;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author 0057149
 */
public class InsertionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] vet = new int[500000];
        Random rnd = new Random(17);
        
        for (int i = 0; i < vet.length; i++) {
            vet[i] = rnd.nextInt(10000000);
        }
        
        
        for (int i = 0; i < vet.length; i++) {
            vet[i] = i;
        }
         
        int r = 0;
        for (int i = 1000; i > 0; i--) {
            vet[r] = i;
        }
        
        

        long startTime = System.nanoTime();
        OrdenaVetor(vet, vet.length);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        System.out.println(timeElapsed);

    }

    static void OrdenaVetor(int[] vetor, int sizeVetor) {
        int i = 0;
        int j = 1;
        int aux = 0;
        while (j < sizeVetor) {
            aux = vetor[j];
            i = j - 1;
            while ((i >= 0) && (vetor[i] > aux)) {
                vetor[i + 1] = vetor[i];
                i -= 1;
            }
            vetor[i + 1] = aux;
            j += 1;
        }
    }

}
