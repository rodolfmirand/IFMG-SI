/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.exerciciosjava_classeobjeto;

import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class TelevisorMainControle {
    public static void main(String[] args) {
        int botao;
        Televisor tv = new Televisor();
        
        Scanner in = new Scanner(System.in);
        System.out.println("0. Mostrar status \n1. Ligar \n2. Desligar \n3. Subir canal \n4. Descer canal"
                + "\n5. Aumentar volume \n6. Diminuir volume");
        do {            
            botao = in.nextInt();
            switch(botao){
                case 0:
                    tv.mostrarStatus();
                    break;
                case 1:
                    tv.ligarTV();
                    break;
                case 2:
                    tv.desligarTV();
                    break;
                case 3:
                    tv.subirCanal();
                    break;
                case 4:
                    tv.descerCanal();
                    break;
                case 5:
                   tv.aumentarVolume();
                    break;
                case 6:
                    tv.diminuirVolume();
                    break;
                default:
                    System.out.println("Botão inexistente.");
            }
        } while (botao >= 0);
    }
}
