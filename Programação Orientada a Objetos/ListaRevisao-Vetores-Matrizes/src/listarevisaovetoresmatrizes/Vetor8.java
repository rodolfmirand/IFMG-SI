/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listarevisaovetoresmatrizes;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author rodol
 */
public class Vetor8 {
    public static void main(String[] args) {
        int vet[] = new int[30];
        int vetInvertido[] = new int[30];
        int cont = 0;
        
        Random rnd = new Random();
        for (int i = 0; i < vet.length; i++) {
            vet[i] = rnd.nextInt(30);
        }
        for (int i = 29; i >= 0 ; i--) {
            vetInvertido[cont] = vet[i];
            cont++;
        }
        System.out.println(Arrays.toString(vet));
        System.out.println(Arrays.toString(vetInvertido));
    }
}
