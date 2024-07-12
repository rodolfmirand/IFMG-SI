/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.listas;

import java.util.ArrayList;
import orçamentoDeMarketing.classes.model.trafegoPago.TrafegoPago;

/**
 *
 * @author rodol
 */
public class ListaTrafegoPago {

    public static ArrayList<TrafegoPago> trafegos = new ArrayList<TrafegoPago>();

    public void adicionar(String nicho, double investimento) {
        trafegos.add(new TrafegoPago(investimento, nicho));
    }

    public double calcularPrecoTotal() {
        double total = 0;
        for (int i = 0; i < trafegos.size(); i++) {
            total += trafegos.get(i).getPrecoFinal();
        }
        return total;
    }
}
