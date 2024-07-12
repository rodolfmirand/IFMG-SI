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
public class Vetor6 {
    public static void main(String[] args) {
        int vet[] = {4,6,9,2,0,12,2,10,8,2};
        int vetPar[] = new int[5];
        int vetImpar[] = new int[5];
        int contPar = 0, contImpar = 0;
        
        for (int i = 0; i < vet.length ; i++) {
            if(i % 2 == 0){
                vetPar[contPar] = vet[i];
                contPar++;
            }else{
                vetImpar[contImpar] = vet[i];
                contImpar++;
            }
        }
        
        System.out.println(Arrays.toString(vetPar));
        System.out.println(Arrays.toString(vetImpar));
    }
}
