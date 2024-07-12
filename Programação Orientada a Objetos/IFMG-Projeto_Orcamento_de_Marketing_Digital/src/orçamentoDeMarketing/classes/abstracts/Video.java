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
public abstract class Video implements Produto {

    private double precoFinal;
    protected double duracao;
    private double tempoEstimadoServico;
    private String tipo;

    public Video() {
        this.precoFinal = 0;
        this.duracao = 0;
        this.tempoEstimadoServico = 0;
    }

    public Video(double duracao, String tipo) {
        this.precoFinal = 0;
        this.duracao = duracao;
        this.tempoEstimadoServico = 0;
        this.tipo = tipo;
    }

    public double getPrecoFinal() {
        return this.calcularPreco();
    }

    public void setPrecoFinal(double precoFinal) {
        this.precoFinal = precoFinal;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public double getTempoEstimadoServico() {
        return tempoEstimadoServico;
    }

    public void setTempoEstimadoServico(double tempoEstimadoServico) {
        this.tempoEstimadoServico = tempoEstimadoServico;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
