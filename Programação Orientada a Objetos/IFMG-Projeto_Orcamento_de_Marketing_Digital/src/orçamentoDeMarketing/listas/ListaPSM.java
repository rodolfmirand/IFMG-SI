/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.listas;

import java.util.ArrayList;
import orçamentoDeMarketing.classes.abstracts.PacoteSocialMedia;

/**
 *
 * @author rodol
 */
public class ListaPSM {

    public static ArrayList<PacoteSocialMedia> pacotes = new ArrayList<>();

    public void adicionar(PacoteSocialMedia psm) {
        pacotes.add(psm);
    }
    
    public double calcularPrecoTotal(){
        double total = 0;
        for (int i = 0; i < pacotes.size(); i++) {
            total += pacotes.get(i).getPreco();
        }
    return total;
    }
}
