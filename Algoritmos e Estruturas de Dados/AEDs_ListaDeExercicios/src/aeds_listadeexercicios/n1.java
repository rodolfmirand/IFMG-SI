/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_listadeexercicios;

/**
 *
 * @author rodol
 */
public class n1 {
    public static void main(String[] args) {
        int vetor[] = {1, 2, 3, 4};
        
        imprimirVetor(vetor, 0);
    }
    
    static void imprimirVetor(int[] vetor, int indice){
        if(indice < vetor.length){
           System.out.print(vetor[indice] + " ");
           imprimirVetor(vetor, indice++);
        }
    }
}
