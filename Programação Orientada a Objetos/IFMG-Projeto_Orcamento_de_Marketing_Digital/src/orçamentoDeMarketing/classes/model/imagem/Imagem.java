/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package orçamentoDeMarketing.classes.model.imagem;

import orçamentoDeMarketing.classes.interfaces.Produto;

/**
 *
 * @author rodol
 */
public class Imagem implements Produto {

    private String textoNivelDePesquisa;
    private double precoFinal;
    private String dimensao;
    private int nivelDePesquisa;
    private double taxaPesquisa;
    private double tempoPesquisa;
    private double tempoEstimadoServico;

    public Imagem() {
        this.precoFinal = 0;
        this.dimensao = "";
        this.nivelDePesquisa = 0;
        this.tempoEstimadoServico = 0;
    }

    public Imagem(String dimensionamento, int nivelDePesquisa) {
        this.precoFinal = 0;
        this.dimensao = dimensionamento;
        this.nivelDePesquisa = nivelDePesquisa;
        this.tempoEstimadoServico = 0;
    }

    public Imagem(double precoFinal, String dimensionamento, int nivelDePesquisa, double tempoEstimadoServico) {
        this.precoFinal = precoFinal;
        this.dimensao = dimensionamento;
        this.nivelDePesquisa = nivelDePesquisa;
        this.tempoEstimadoServico = tempoEstimadoServico;
    }

    @Override
    public double calcularPreco() {
        switch (this.nivelDePesquisa) {
            case 1:
                taxaPesquisa = 130;
                break;
            case 2:
                taxaPesquisa = 115;
                break;
            case 3:
                taxaPesquisa = 100;
                break;
        }
        //retorna valores em reais
        return switch (this.dimensao) {
            case "1:1" ->
                25 + (25 * (25 / taxaPesquisa));
            case "4:5" ->
                30 + (35 * (35 / taxaPesquisa));
            case "9:16" ->
                40 + (45 * (45 / taxaPesquisa));
            default ->
                0;
        };
    }

    @Override
    public double calcularTempoEstimadoServico() {
        switch (nivelDePesquisa) {
            case 1 -> {
                tempoPesquisa = 30;
                break;
            }
            case 2 -> {
                tempoPesquisa = 45;
                break;
            }
            case 3 -> {
                tempoPesquisa = 60;
                break;
            }
        }
        //retorna valores em minutos
        return switch (this.dimensao) {
            case "1:1" ->
                tempoPesquisa + 45;
            case "4:5" ->
                tempoPesquisa + 60;
            case "9:16" ->
                tempoPesquisa + 75;
            default ->
                0;
        };
    }

    public String getTextoNivelDePesquisa() {
        switch (this.nivelDePesquisa) {
            case 1:
                return "Baixo";
            case 2:
                return "Médio";
            case 3:
                return "Alto";
        }
        return null;
    }

    public void setTextoNivelDePesquisa() {
        this.textoNivelDePesquisa = this.getTextoNivelDePesquisa();
    }

    public double getPrecoFinal() {
        return this.calcularPreco();
    }

    public void setPrecoFinal() {
        this.precoFinal = this.calcularPreco();
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    public int getNivelDePesquisa() {
        return nivelDePesquisa;
    }

    public void setNivelDePesquisa(int nivelDePesquisa) {
        this.nivelDePesquisa = nivelDePesquisa;
    }

    public double getTempoPesquisa() {
        return tempoPesquisa;
    }

    public void setTempoPesquisa(double tempoPesquisa) {
        this.tempoPesquisa = tempoPesquisa;
    }

    public double getTempoEstimadoServico() {
        return calcularTempoEstimadoServico();
    }

    public void setTempoEstimadoServico(double tempoEstimadoServico) {
        this.tempoEstimadoServico = tempoEstimadoServico;
    }

    @Override
    public String toString() {
        return "Formato: " + this.dimensao + " / Nível de pesquisa: "
                + this.getTextoNivelDePesquisa();
    }

}
