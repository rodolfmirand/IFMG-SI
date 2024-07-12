/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.listaexercicios;

import java.util.Scanner;

/**
 *
 * @author 0057149
 */
public class q2PlanoCartesiano {
    public static void main(String[] args) {
        int x, y;
        Scanner in = new Scanner(System.in);
        
        do {
            x = in.nextInt();
            y = in.nextInt();
            
            if(x > 0){
                if(y > 0){
                    System.out.println("Primeiro");
                }else{
                    System.out.println("Quarto");
                }
            }else{
                if(y > 0){
                    System.out.println("Segundo");
                }else{
                    System.out.println("Terceiro");
                }
            }
        } while (x != 0 || y != 0);
    }
}
