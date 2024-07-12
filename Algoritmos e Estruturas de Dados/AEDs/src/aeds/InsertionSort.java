/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aeds;

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
        int size;
        System.out.print("Tamanho do vetor: ");
        Scanner in = new Scanner(System.in);
        size = in.nextInt();
        int[] vet = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Posição " + i + ": ");
            vet[i] = in.nextInt();
        }

        OrdenaVetor(vet, size);
        
        for (int i = 0; i < size; i++) {
            System.out.print(vet[i] + ", ");
        }
    }

    static void OrdenaVetor(int[] v, int s) {
        int i = 0;
        int j = 1;
        int aux = 0;
        while (j < s) {
            aux = v[j];
            i = j - 1;
            while ((i >= 0) && (v[i] > aux)) {
                v[i + 1] = v[i];
                i -= 1;
            }
            v[i + 1] = aux;
            j += 1;
        }
    }

}


