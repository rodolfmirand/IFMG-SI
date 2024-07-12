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
public class q4Lampadas {
    public static void main(String[] args) {
        int num,qntd;
        String word = "";
        char alfb[] = new char[26];
        
        Scanner in = new Scanner(System.in);
        
        for (int i = 0; i < 26; i++) {
            alfb[i] = in.next().charAt(0);
        }
        
        qntd = in.nextInt();
        
        for (int i = 0; i < qntd; i++) {
            System.out.println("letra " + (i+1)) ;
            num = in.nextInt();
            word += "" + alfb[num - 1];
        }
        
        System.out.println(word);
    }
}
