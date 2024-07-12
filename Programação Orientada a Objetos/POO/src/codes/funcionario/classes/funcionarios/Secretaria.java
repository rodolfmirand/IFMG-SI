/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.funcionario.classes.funcionarios;

import codes.funcionario.classes.Funcionario;

/**
 *
 * @author rodol
 */
public class Secretaria extends Funcionario{

    public Secretaria(String nome, String cpf, double salario) {
        super(nome, cpf, salario);
    }
    
    @Override
    public double calcularBonificacao() {
        return this.salario * 0.1;
    }
    
}
