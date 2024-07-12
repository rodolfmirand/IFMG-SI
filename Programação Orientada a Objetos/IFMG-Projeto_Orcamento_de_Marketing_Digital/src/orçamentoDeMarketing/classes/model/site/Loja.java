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
public class Loja extends Site {

    private int qntdProdutos;
    private double valorPorProduto;
    private int tempoPorQntdProdutos;

    public Loja(String tipo, int paginas, int qntdProdutos) {
        super(tipo, paginas);
        this.qntdProdutos = qntdProdutos;
    }

    @Override
    public double calcularPreco() {
        if (qntdProdutos > 400) {
            valorPorProduto = 5;
        } else if (qntdProdutos > 250) {
            valorPorProduto = 12.5;
        } else if (qntdProdutos > 100) {
            valorPorProduto = 20;
        } else if (qntdProdutos > 20) {
            valorPorProduto = 27.5;
        } else if (qntdProdutos > 10) {
            valorPorProduto = 35;
        } else {
            valorPorProduto = 40;
        }
        return dominio + (qntdProdutos * valorPorProduto) + ((paginas - 1) * acrescimoPaginas) + construcaoSite;
    }

    @Override
    public double calcularTempoEstimadoServico() {
        if (qntdProdutos > 400) {
            tempoPorQntdProdutos = 20;
        } else if (qntdProdutos > 250) {
            tempoPorQntdProdutos = 16;
        } else if (qntdProdutos > 100) {
            tempoPorQntdProdutos = 12;
        } else if (qntdProdutos > 20) {
            tempoPorQntdProdutos = 8;
        } else if (qntdProdutos > 10) {
            tempoPorQntdProdutos = 4;
        } else {
            tempoPorQntdProdutos = 2;
        }
        return (paginas * 3) + tempoPorQntdProdutos;
    }

    public int getQntdProdutos() {
        return qntdProdutos;
    }

    public void setQntdProdutos(int qntdProdutos) {
        this.qntdProdutos = qntdProdutos;
    }
}
