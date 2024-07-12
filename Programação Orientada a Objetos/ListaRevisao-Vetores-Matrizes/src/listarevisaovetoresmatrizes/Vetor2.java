/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listarevisaovetoresmatrizes;

/**
 *
 * @author rodol
 */
public class Vetor2 {
    public static void main(String[] args) {
        int vet[] = {4,6,9,2,0,12,2,10,7,3};
        double soma = 0;
        int cont = 0;
        
        for(int i = 0; i < vet.length; i++){
            if(i % 2 == 1){
                soma += vet[i];
                cont++;
            }
        }
        
        System.out.println(soma/cont);
    }
}
