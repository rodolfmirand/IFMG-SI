/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_listadeexercicios;

import java.util.ArrayList;

/**
 *
 * @author rodol
 */
public class n4 {

    static void imprimirParImpar(int min, int max, ArrayList<Integer> par, ArrayList<Integer> impar) {
        if(min <= max){
            if(min % 2 == 0){
                par.add(min);
                imprimirParImpar(min+1, max, par, impar);
            }else{
                impar.add(min);
                imprimirParImpar(min+1, max, par, impar);
            }
        }
    }

    public static void main(String[] args) {
        int min = 1;
        int max = 6;
        ArrayList<Integer> par = new ArrayList<>();
        ArrayList<Integer> impar = new ArrayList<>();

        imprimirParImpar(min, max, par, impar);
        System.out.println("Pares: " + par + "\nImpares: "+ impar);
    }
}
