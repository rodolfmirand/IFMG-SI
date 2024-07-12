/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package listarevisaovetoresmatrizes;

/**
 *
 * @author rodol
 */
public class Vetor1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int vet[] = {4,6,9,2,0,12,2,10,7,3};
        int soma = 0;
        
        for(int i = 0; i < vet.length; i++){
            if(i % 2 == 0){
                soma += vet[i];
            }
        }
        
        System.out.println(soma);
    }
    
}
