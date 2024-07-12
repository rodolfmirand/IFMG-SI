/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.recursividade;

/**
 *
 * @author rodol
 */
public class ExisteSubconjuntoModificado {

    public static void main(String[] args) {
        
        int[] conjunto = {3, 5, 1, 8, -4};
        int alvo = 4;

        System.out.println("Existe subconjunto: " + existeSubconjunto(conjunto, alvo));

        imprimirSubconjunto(conjunto, alvo);
    }

    public static boolean existeSubconjunto(int[] conjunto, int alvo) {
        return aux(conjunto, alvo, 0);
    }

    private static boolean aux(int[] conjunto, int alvo, int i) {
        if (alvo == 0) {
            return true;
        }
        if (i == conjunto.length) {
            return false;
        }
        if (aux(conjunto, alvo - conjunto[i], i + 1)) {
            return true;
        }

        return aux(conjunto, alvo, i + 1);
    }

    public static void imprimirSubconjunto(int[] conjunto, int alvo) {
        imprimirAux(conjunto, alvo, 0, "");
    }

    private static void imprimirAux(int[] conjunto, int alvo, int i, String subconjunto) {
        if (alvo == 0) {
            System.out.println(subconjunto);
        }

        if (i == conjunto.length) {
            return;
        }

        imprimirAux(conjunto, alvo - conjunto[i], i + 1, subconjunto + conjunto[i] + " ");
        imprimirAux(conjunto, alvo, i + 1, subconjunto);
    }
}
