/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.empregado.classes;

import codes.empregado.classes.abstracts.Empregado;

/**
 *
 * @author rodol
 */
public class Comissionario extends Empregado {

    private double totalVendas;
    private double taxaComissao;

    public Comissionario(double totalVendas, double taxaComissao, String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.totalVendas = totalVendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double vencimento() {
        return totalVendas * (taxaComissao / 100);
    }

    public double getTotalVendas() {
        return totalVendas;
    }

    public void setTotalVendas(double totalVendas) {
        this.totalVendas = totalVendas;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }
}
