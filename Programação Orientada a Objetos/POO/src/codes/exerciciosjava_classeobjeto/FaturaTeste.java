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
public class FaturaTeste {
    public static void main(String[] args) {
        Fatura fat = new Fatura();
        Scanner in = new Scanner(System.in);
        fat.numero = in.next();
        fat.descricao = in.next();
        fat.qntdItem = in.nextInt();
        fat.preco = in.nextDouble();
        
        fat.getFaturaTotal();
    }
}
