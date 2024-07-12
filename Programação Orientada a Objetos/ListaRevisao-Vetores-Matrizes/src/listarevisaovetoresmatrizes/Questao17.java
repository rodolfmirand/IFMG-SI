/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listarevisaovetoresmatrizes;

import java.util.Scanner;

/**
 *
 * @author rodol
 */
public class Questao17 {
    public static void main(String[] args) {
        char prova[] = {'c','a','e','c','b','a','e','d','d','c'};
        Scanner in = new Scanner(System.in);
        int ra = 0, nota = 0;
        char quest;
        
        /*for (int i = 0; i < prova.length; i++) {
            System.out.println("Insira a resposta da questão ["+ (i+1) + "]: ");
            prova[i] = in.next().charAt(0);
        }*/
        
        do{
            System.out.println("RA: ");
            ra = in.nextInt();
            for (int i = 0; i < prova.length; i++) {
                System.out.println("Questão "+ (i+1) + "; " );
                quest = in.next().charAt(0);
                if(quest == prova[i]){
                    nota++;
                }
            }
            System.out.println("Aluno: " + ra + "\nNota: " + nota + "/10\n\n");
        }while(ra >= 0);
    }
}
