/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.funcionario.classes.funcionarios.assistentes;

import codes.funcionario.classes.funcionarios.Assistente;

/**
 *
 * @author rodol
 */
public class Tecnico extends Assistente {

    public Tecnico(String nome, String cpf, double salario, int numeroMatricula) {
        super(nome, cpf, salario, numeroMatricula);
    }

    public double ganhoAnual() {
        return (this.salario + (this.salario * 0.15)) * 12;
    }

}
