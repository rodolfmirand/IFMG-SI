/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.classes.abstracts;

import orçamentoDeMarketing.classes.interfaces.Produto;

/**
 *
 * @author rodol
 */
public abstract class Site implements Produto{
    
    private double precoFinal;
    protected int paginas;
    private String tipo;
    
    protected int construcaoSite = 1000;
    protected int acrescimoPaginas = 200;
    protected double manutençãoHospedagem;
    protected double dominio = 60;
    
    public Site(String tipo, int paginas){
        this.tipo = tipo;
        this.paginas = paginas;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }
    
    public double getPrecoFinal() {
        return calcularPreco();
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
