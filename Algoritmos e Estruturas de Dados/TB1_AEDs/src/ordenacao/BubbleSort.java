/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ordenacao;

import java.util.Random;

/**
 *
 * @author 0057149
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] vet = new int[500000];
        Random rnd = new Random(17); // rnd.nextInt((max - min) + 1) + min;
        /*
        for (int i = 0; i < vet.length; i++) {
            vet[i] = rnd.nextInt();
        }
        
        for (int i = 0; i < vet.length; i++) {
            vet[i] = i;
        }
        */
        int r = 0;
        for (int i = 1000; i > 0; i--) {
            vet[r] = i;
        }
        
        int aux;
        long startTime = System.nanoTime();
        for (int i = (vet.length - 1); i > 0; i--) { //O(n)
            for (int j = 0; j < i; j++) { //O(n)
                if (vet[j] > vet[j + 1]) {
                    aux = vet[j];
                    vet[j] = vet[j + 1];
                    vet[j + 1] = aux;
                }
            }
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;

        
        System.out.println("\nTempo decorrido em nanosegundos: " + timeElapsed);
        System.out.println("Tempo decorrido em milisegundos: " + timeElapsed / 1000000);
    }

    //Complexidade: O(n) * O(n) -> O(n*n) --> O(n^2)
}
