/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aeds_listadeexercicios;

/**
 *
 * @author rodol
 */
public class n2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] vet = {7, 2, 5, 4};
        int maior = encontrarMaior(vet, 0);

        System.out.println(maior);
    }

    static int encontrarMaior(int[] v, int i) {
        if (i < v.length) {
            if (v[i] >= v[0]) {
                v[0] = v[i];
                return encontrarMaior(v, i + 1);
            }else{
                return v[0];
            }
        }else{
            return v[0];
        }      
    }
}
