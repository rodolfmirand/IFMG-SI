/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacao;

/**
 *
 * @author rodol
 */
public class QuickSorte {
    public static void main(String[] args) {
        int[] vetor = {7,5,9,1,4,3,3,1,8,43,26};
        quickSort(vetor, 0, vetor.length-1);
        
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }
        
    }
    static void quickSort(int[] vetor, int inicio, int fim) {
        if (fim > inicio) {
            int indexPivo = dividir(vetor, inicio, fim);
            quickSort(vetor, inicio, indexPivo - 1);
            quickSort(vetor, indexPivo + 1, fim);
        }
    }

    static int dividir(int[] vetor, int inicio, int fim) {
        int pivo, pontEsq, pontDir = fim;
        pontEsq = inicio + 1;
        pivo = vetor[inicio];

        while (pontEsq <= pontDir) {
            while (pontEsq <= pontDir && vetor[pontEsq] <= pivo) {
                pontEsq++;
            }

            while (pontDir >= pontEsq && vetor[pontDir] > pivo) {
                pontDir--;
            }
            if (pontEsq < pontDir) {
                trocar(vetor, pontDir, pontEsq);
                pontEsq++;
                pontDir--;
            }
        }

        trocar(vetor, inicio, pontDir);
        return pontDir;
    }

    static void trocar(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
