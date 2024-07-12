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
public class Assistente extends Funcionario {

    private int numeroMatricula;

    public Assistente(String nome, String cpf, double salario, int numeroMatricula) {
        super(nome, cpf, salario);
        this.numeroMatricula = numeroMatricula;

    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + this.nome + "\nCPF: " + this.cpf + "\nMatrícula: " + this.numeroMatricula + "\nSalário: R$" + this.salario);
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    @Override
    public String toString() {
        return "Assistente{" + "numeroMatricula=" + numeroMatricula + '}';
    }

    @Override
    public double calcularBonificacao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
