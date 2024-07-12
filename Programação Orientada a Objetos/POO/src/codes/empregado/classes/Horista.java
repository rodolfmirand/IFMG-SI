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
public class Horista extends Empregado {

    private double precoHora;
    private double horasTrabalhadas;

    public Horista(double precoHora, double horasTrabalhadas, String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.precoHora = precoHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double vencimento() {
        return (precoHora * horasTrabalhadas) * 22;
    }

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

}
