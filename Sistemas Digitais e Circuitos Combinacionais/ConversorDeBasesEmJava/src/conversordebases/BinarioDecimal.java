/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversordebases;

import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class BinarioDecimal {
    public static void main(String[] args) {
        String binario;
        int decimal = 0;
        
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite o número na base binária: ");
        binario = in.nextLine();
        
        for (int i = 0; i < binario.length(); i++) {
            int num = Character.getNumericValue(binario.charAt(i));
       
            decimal += num * Math.pow(2, binario.length() -1 -i); //pega os números do vetor do indice maior para o menor (ao contrário)
            
        }
        
        System.out.println(decimal);
    }
}
