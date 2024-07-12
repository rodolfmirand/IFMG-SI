/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aeds_atividadeavaliada.recursividade;

/**
 *
 * @author rodol
 */
public class ExisteSubconjunto {
    public static void main(String[] args) {

        int[] conjunto = {3, 5, 1, 8, -4};
        int alvo = 4;

        System.out.println("Existe subconjunto: " + existeSubconjunto(conjunto, alvo));

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
        if (aux(conjunto, alvo - conjunto[i], ++i)) {
            return true;
        }

        return aux(conjunto, alvo, ++i);
    }
}
