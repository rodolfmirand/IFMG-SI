/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds;

/**
 *
 * @author 0057149
 */
public class SelectionSort {
    public static void main(String[] args) {
        int menorI, aux;
        int[] vet = {1,4,5,9,8,3,7};
        
        for (int i = 0; i < (vet.length - 1); i++) {
            menorI = i;
            for (int j = (i + 1); j < vet.length; j++) {
                if(vet[j] < vet[menorI]){
                    menorI = j;
                }
            }
            if(vet[i] != vet[menorI]){
                aux = vet[i];
                vet[i] = vet[menorI];
                vet[menorI] = aux;
            }
        }
        
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + ", ");
        }
    }
}
