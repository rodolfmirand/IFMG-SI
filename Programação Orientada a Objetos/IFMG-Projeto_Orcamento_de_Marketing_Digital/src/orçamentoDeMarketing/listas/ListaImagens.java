/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.listas;

import java.util.ArrayList;
import java.util.List;
import orçamentoDeMarketing.classes.model.imagem.Imagem;

/**
 *
 * @author rodol
 */
public class ListaImagens {

    public static ArrayList<Imagem> imagens = new ArrayList<Imagem>();

    public void adicionar(String formato, int nivelDePesquisa) {
        imagens.add(new Imagem(formato, nivelDePesquisa));
    }

    public double calcularPrecoTotal() {
        double total = 0;
        for (int i = 0; i < imagens.size(); i++) {
            total += imagens.get(i).getPrecoFinal();
        }
        return total;
    }
}
