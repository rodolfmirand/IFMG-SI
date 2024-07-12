/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.funcionario;

import codes.funcionario.classes.Funcionario;
import codes.funcionario.classes.funcionarios.Diretor;

/**
 *
 * @author rodol
 */
public class ControleBonificacao {

    private double bonificacaoTotal;

    public void registrar(Funcionario func) {
        if (!(func instanceof Diretor)) {
            this.bonificacaoTotal += func.calcularBonificacao();
        }
    }

    public double getBonificacaoTotal() {
        return bonificacaoTotal;
    }
}
