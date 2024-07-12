/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.listas;

import java.util.ArrayList;
import java.util.List;
import orçamentoDeMarketing.classes.abstracts.Site;

/**
 *
 * @author rodol
 */
public class ListaSites {
    public static ArrayList<Site> sites = new ArrayList<Site>();

    public void adicionar(Site site) {
        sites.add(site);
    }

    public double calcularPrecoTotal() {
        double total = 0;
        for (int i = 0; i < sites.size(); i++) {
            total += sites.get(i).getPrecoFinal();
        }
        return total;
    }
}
