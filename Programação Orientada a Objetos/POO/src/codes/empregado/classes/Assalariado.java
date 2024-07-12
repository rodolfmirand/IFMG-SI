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
public class Assalariado extends Empregado{
    
    private double salario;

    public Assalariado(double salario, String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.salario = salario;
    }
    
    @Override
    public double vencimento() {
        return salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
