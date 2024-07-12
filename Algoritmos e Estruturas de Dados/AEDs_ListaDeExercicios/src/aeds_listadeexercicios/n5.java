    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_listadeexercicios;

/**
 *
 * @author rodol
 */
public class n5 {
    public static void main(String[] args) {
        int n = 5;
        int e = 5;
        System.out.println(potencia(n, e, n));
    }
    
    static int potencia(int n, int e, int aux){
        if(e == 0){
           return 1; 
        }
        
        if(e != 1){
            n = n * aux;
            return potencia(n, e-1, aux);
        }
        return n;
    }
}
