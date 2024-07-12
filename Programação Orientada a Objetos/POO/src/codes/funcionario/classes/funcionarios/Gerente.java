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
public class Gerente extends Funcionario {

    private int senha;
    private int numFuncGerenciados;
    private int bonus = 1000;

    public Gerente(String nome, String cpf, double salario, int senha) {
        super(nome, cpf, salario);
        this.senha = senha;
        this.numFuncGerenciados = 0;
    }

    public double calcularBonificacao() {
        return  (this.bonus + (this.salario * 0.20));
    }

    public boolean validaSenha(int senha) {
        return senha == this.senha;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public int getNumFuncGerenciados() {
        return numFuncGerenciados;
    }

    public void setNumFuncGerenciados(int numFuncGerenciados) {
        this.numFuncGerenciados = numFuncGerenciados;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Gerente{" + "senha=" + senha + ", numFuncGerenciados=" + numFuncGerenciados + ", bonus=" + bonus + '}';
    }
    
    
}
