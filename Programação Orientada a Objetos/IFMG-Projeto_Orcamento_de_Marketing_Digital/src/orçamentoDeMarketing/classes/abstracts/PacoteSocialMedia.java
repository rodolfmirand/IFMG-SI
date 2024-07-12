/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.classes.abstracts;

/**
 *
 * @author rodol
 */
public abstract class PacoteSocialMedia {

    private String tipo;
    private double preco;

    public PacoteSocialMedia(String tipo, double preco, double investimento) {
        this.tipo = tipo;
        this.preco = preco + investimento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
