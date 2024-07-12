/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.classes.model.site;

import orçamentoDeMarketing.classes.abstracts.Site;

/**
 *
 * @author rodol
 */
public class Institucional extends Site {

    public Institucional(String tipo, int paginas) {
        super(tipo, paginas);
    }

    @Override
    public double calcularPreco() {
        return dominio + ((paginas - 1) * acrescimoPaginas) + construcaoSite;
    }

    @Override
    public double calcularTempoEstimadoServico() {
        return (paginas * 3);
    }
}
