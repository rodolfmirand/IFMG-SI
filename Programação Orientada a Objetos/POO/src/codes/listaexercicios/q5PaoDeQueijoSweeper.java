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
public class q5PaoDeQueijoSweeper {
    public static void main(String[] args) {
        int linha, coluna;
        Scanner in = new Scanner(System.in);
        linha = in.nextInt();
        coluna = in.nextInt();
        int mat[][] = new int[linha][coluna];
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                mat[i][j] = in.nextInt();
                if(mat[i][j] == 1){
                    mat[i][j] = 9;
                }
            }
        }
        
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                if(mat[i][j] == 0){
                    if(i-1 >= 0 && mat[i-1][j] == 9){
                        mat[i][j]++;
                    }
                    if(i+1 < linha && mat[i+1][j] == 9){
                        mat[i][j]++;
                    }
                    if(j-1 >= 0 && mat[i][j-1] == 9){
                        mat[i][j]++;
                    }
                    if(j+1 < coluna && mat[i][j+1] == 9){
                        mat[i][j]++;
                    }
                }
            }
        }
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
