/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.classes.model.psm;

import orçamentoDeMarketing.classes.abstracts.PacoteSocialMedia;
import orçamentoDeMarketing.classes.interfaces.Produto;

/**
 *
 * @author rodol
 */
public class PacoteStandard extends PacoteSocialMedia implements Produto{

    public PacoteStandard(String tipo, double preco, double investimento) {
        super(tipo, preco, investimento);
    }

    @Override
    public double calcularPreco() {
        return super.getPreco();
    }

    @Override
    public double calcularTempoEstimadoServico() {
        return 0;
    }
}
