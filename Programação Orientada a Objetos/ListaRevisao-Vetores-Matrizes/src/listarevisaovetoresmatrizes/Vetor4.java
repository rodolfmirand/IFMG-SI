/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listarevisaovetoresmatrizes;

import java.util.Arrays;

/**
 *
 * @author rodol
 */
public class Vetor4 {
    public static void main(String[] args) {
        int vet[] = {4,6,9,2,0,12,2,10};
        int vet2[] = {6,3,8,5,1,0,8,4};
        int vet3[] = new int[8];
        
        for (int i = 0; i < 8; i++) {
            vet3[i] = vet[i];
            vet[i] = vet2[i];
            vet2[i] = vet3[i];
        }
        
        System.out.println(Arrays.toString(vet));
        System.out.println(Arrays.toString(vet2));
    }
}
