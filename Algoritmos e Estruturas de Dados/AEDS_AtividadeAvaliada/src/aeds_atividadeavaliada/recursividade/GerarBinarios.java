/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aeds_atividadeavaliada.recursividade;

/**
 *
 * @author rodol
 */
public class GerarBinarios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        gerarNumBinario(3);
    }

    public static void gerarNumBinario(int nBits) {
        int[] bin = new int[nBits];
        aux(bin, nBits - 1);
    }

    private static void aux(int[] bin, int posicao) {

        if (posicao < 0) {
            imprimirBinarios(bin);
        } else {
            bin[posicao] = 0;
            aux(bin, posicao - 1);
            bin[posicao] = 1;
            aux(bin, posicao - 1);
        }
    }

    private static void imprimirBinarios(int[] bin) {

        for (int i = 0; i < bin.length; i++) {
            System.out.print(bin[i] + "");
        }

        System.out.print("\n");
    }
}
