/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_listadeexercicios;

import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class n3 {
    public static void main(String[] args) {
        int num = 4;
        if(verificarPrimo(num, num - 1)){
            System.out.println(num + "é primo");
        }else{
            System.out.println(num + " não é primo");
        }
    }
    
    static boolean verificarPrimo(int n, int contador){
        if(n <= 1){
            return true; 
        }
        
        if(contador == 1){
            return true;
        }
        
        if(n % contador == 0){
            return false;
        }
        
        return verificarPrimo(n, contador-1);
    }
}
