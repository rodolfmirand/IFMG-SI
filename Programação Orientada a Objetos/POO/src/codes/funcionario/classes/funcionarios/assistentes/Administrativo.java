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
public class Administrativo extends Assistente {

    private String turno;

    public Administrativo(String nome, String cpf, double salario, int numeroMatricula, String turno) {
        super(nome, cpf, salario, numeroMatricula);
        this.turno = turno;
    }

    public double ganhoAnual() {
        return this.turno == "noite" ? (this.salario + 100) * 12 : this.salario * 12;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

}
