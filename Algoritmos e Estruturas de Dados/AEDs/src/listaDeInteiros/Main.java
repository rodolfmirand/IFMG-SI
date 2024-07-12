/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listaDeInteiros;

import java.util.Arrays;

/**
 *
 * @author rodol
 */
public class Main {

    public static void main(String[] args) {
        int[] vetor = {1,2,3,4,5};
        int inicio = 0, fim = 5;
        
        inverterVetor(vetor, inicio, fim);
        System.out.println(Arrays.toString(vetor));
        
        
    }

    public static void inverterVetor(int[] vetor, int inicio, int fim) {
        if(inicio >= fim || fim <= 1){
            return;
        } 
        inverterVetor(vetor, inicio+1, fim-1);
        int aux = vetor[inicio];
        vetor[inicio] = vetor[fim-1];
        vetor[fim-1] = aux;
    }
}
