/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package listarevisaovetoresmatrizes;

import java.util.Random;

/**
 *
 * @author rodol
 */
public class Matriz15 {
    public static void main(String[] args) {
        int mat[][] = new int[4][4];
        int soma = 0;
        Random rnd = new Random();
        
        
        for (int i = 0; i < mat.length; i++) {
            for (int o = 0; o < mat[0].length; o++) {
               mat[i][o] = rnd.nextInt(25);
               if(i == o){
                   soma+= mat[i][o];
               }
            }
        }
        
        System.out.println(soma);
    }
}
