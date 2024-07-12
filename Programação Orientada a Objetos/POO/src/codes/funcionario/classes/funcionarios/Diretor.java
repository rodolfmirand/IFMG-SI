/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.funcionario.classes.funcionarios;

/**
 *
 * @author rodol
 */
public class Diretor extends Gerente {

    private int numDepto;
    private int bonus = 2500;

    public Diretor(String nome, String cpf, double salario, int senha, int numDepto) {
        super(nome, cpf, salario, senha);
        this.numDepto = numDepto;
    }
    
    public double calcularBonificacao(){
        return super.calcularBonificacao() + this.bonus;
    }

    @Override
    public String toString() {
        return "Diretor{" + "numDepto=" + numDepto + ", bonus=" + bonus + '}';
    }
    
}
