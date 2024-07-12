/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacao;

import java.util.Random;

/**
 *
 * @author rodol
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] vet = new int[500000];
        Random rnd = new Random(17);
        
        for (int i = 0; i < vet.length; i++) {
            vet[i] = rnd.nextInt(10000000);
        }
        /*
        for (int i = 0; i < vet.length; i++) {
            vet[i] = i;
        }
         /*
        int r = 0;
        for (int i = 1000; i > 0; i--) {
            vet[r] = i;
        }
        */
        long startTime = System.nanoTime();
        mergeSort(0, vet.length, vet);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.println(timeElapsed);

    }

    static void mergeSort(int inicio, int fim, int[] vetor) {

        if (inicio < fim - 1) {
            int meio = (inicio + fim) / 2;
            mergeSort(inicio, meio, vetor);
            mergeSort(meio, fim, vetor);
            intercala(vetor, inicio, meio, fim);
        }
    }

    static void intercala(int[] vetor, int inicio, int meio, int fim) {
        int novoVetor[] = new int[fim - inicio];
        int i = inicio;
        int m = meio;
        int pos = 0;
        while (i < meio && m < fim) {
            if (vetor[i] <= vetor[m]) {
                novoVetor[pos] = vetor[i];
                pos = pos + 1;
                i = i + 1;
            } else {
                novoVetor[pos] = vetor[m];
                pos = pos + 1;
                m = m + 1;
            }
        }
        while (i < meio) {
            novoVetor[pos] = vetor[i];
            pos = pos + 1;
            i = i + 1;
        }
        while (m < fim) {
            novoVetor[pos] = vetor[m];
            pos = pos + 1;
            m = m + 1;
        }
        for (pos = 0, i = inicio; i < fim; i++, pos++) {
            vetor[i] = novoVetor[pos];
        }
    }
    //n + n + n + n
    //4n
    //n
}
