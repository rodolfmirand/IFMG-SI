/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conversordebases;

import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class DecimalBinario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int decimal, dividendo, resto, quociente;
        String binario = "";
        
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o número na base decimal: ");
        decimal = in.nextInt();
        dividendo = decimal;
        
        do{
            resto = dividendo % 2;
            quociente = dividendo / 2;
            binario += resto;
            dividendo = quociente;
            if(dividendo == 1){
                binario += dividendo;
            }
        }while(dividendo != 1);
        
        String stringInvertida = new StringBuilder(binario).reverse().toString();//inverte a String
        System.out.println("Valor em binário: " + stringInvertida);
    }
}
