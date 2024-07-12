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
public class q3Pedrinho {
    public static void main(String[] args) {
        int mes, dia, diasFaltando;
        Scanner in = new Scanner(System.in);
        mes = in.nextInt();
        dia = in.nextInt();
        
        switch(mes){
            case 1:
                diasFaltando = 360 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 2:
                diasFaltando = 329 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 3:
                diasFaltando = 300 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 4:
                diasFaltando = 269 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 5:
                diasFaltando = 239 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;    
            case 6:
                diasFaltando = 207 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 7:
                diasFaltando = 178 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 8:
                diasFaltando = 147 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 9:
                diasFaltando = 116 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 10:
                diasFaltando = 86 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 11:
                diasFaltando = 55 - dia;
                System.out.println("Faltam " + diasFaltando + " dias");
                break;
            case 12:
                if(dia == 25){
                    System.out.println("Já é Natal!");
                }else if(dia == 24){
                    System.out.println("É vespera de Natal");
                }else if(dia > 25){
                    System.out.println("Já passou!");
                }else{
                    diasFaltando = 25 - dia;
                    System.out.println("Faltam " + diasFaltando + " dias");
                }
        }
    }
}
