/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds;

/**
 *
 * @author 0057149
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] vet = {5,1,2,9,7};
        int aux;
        
        for (int i = (vet.length - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(vet[j] > vet[j+1]){
                    aux = vet[j];
                    vet[j] = vet[j+1];
                    vet[j+1] = aux;
                }
            }
        }
        
        for (int i = 0; i < vet.length; i++) {
            System.out.print(vet[i] + ", ");
        }
    }
}
