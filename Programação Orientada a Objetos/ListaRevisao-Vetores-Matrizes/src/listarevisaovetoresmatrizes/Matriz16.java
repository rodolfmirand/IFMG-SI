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
public class Matriz16 {
    public static void main(String[] args) {
        int mat[][] = {
            {10,3,5,8},
            {9,2,4,5},
            {7,5,10,0},
            {9,3,5,8}
        };
        
        int prod = 1;
        Random rnd = new Random();
        
        for (int i = 0; i < mat.length; i++) {
            prod *= mat[i][mat.length - 1 - i]; 
        }
        
        System.out.println(prod);
    }
}
