/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listapoo2;

import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class Main {
    static Scanner in = new Scanner(System.in);
    
    public static void main(String[] args) {
        e1_Contador();
    }
    
    public static void e1_Contador(){
        boolean out = false;
        Contador contador = new Contador();
        
        do {
            System.out.print("Funções:\n1. Incrementar um \n2. Incrementar quantidade \n3. Zerar \n4. Retornar valor \n5. Sair \nR: ");
            
            switch (in.nextInt()) {
                case 1:
                    contador.incrementarUm();
                    System.out.println("Incrementado um");
                    break;
                case 2: 
                    System.out.print("Valor a incrementar: ");
                    contador.incrementarQuantidade(in.nextInt());
                    System.out.println("Incrmentado valor");
                    break;
                case 3:
                    contador.zerar();
                    System.out.println("Zerado");
                    break;
                case 4:
                    System.out.println("Valor do contador: " + contador.getContador());
                    break;
                default:
                    out = true;
            }
        } while (!out);
    }
}
