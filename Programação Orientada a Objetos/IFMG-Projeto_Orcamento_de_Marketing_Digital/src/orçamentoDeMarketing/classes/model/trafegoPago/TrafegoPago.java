/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.classes.model.trafegoPago;

import orçamentoDeMarketing.classes.interfaces.Produto;

/**
 *
 * @author rodol
 */
public class TrafegoPago implements Produto{

    private double precoFinal;
    private String nicho;
    private double valorInvestido;

    public TrafegoPago(double valorInvestido, String nicho) {
        this.valorInvestido = valorInvestido;
        this.nicho = nicho;
    }
    
    @Override
    public double calcularPreco() {
        this.precoFinal = (this.valorInvestido * 1.3);
        return this.precoFinal;
    }

    @Override
    public double calcularTempoEstimadoServico() {
        return 0;
    }

    public double getPrecoFinal() {
        return this.calcularPreco();
    }

    public void setPrecoFinal() {
        this.precoFinal = this.calcularPreco();
    }

    public String getNicho() {
        return nicho;
    }

    public void setNicho(String nicho) {
        this.nicho = nicho;
    }

    public double getValorInvestido() {
        return valorInvestido;
    }

    public void setValorInvestido(double valorInvestido) {
        this.valorInvestido = valorInvestido;
    }

}
