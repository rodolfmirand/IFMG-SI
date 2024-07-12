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
public class Vetor3 {
    public static void main(String[] args) {
        int vet[] = {4,6,9,2,0,12,2,10,7,3};
        int vet2[] = new int[10];
        
        for(int i = 0; i < vet.length; i++){
            vet2[i] = 2 * vet[i];
        }
        System.out.println(Arrays.toString(vet));
        System.out.println(Arrays.toString(vet2));
        
    }
}
