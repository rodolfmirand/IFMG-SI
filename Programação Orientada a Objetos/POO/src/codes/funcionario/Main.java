/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.funcionario;

import codes.funcionario.classes.funcionarios.Assistente;
import codes.funcionario.classes.funcionarios.Diretor;
import codes.funcionario.classes.Funcionario;
import codes.funcionario.classes.funcionarios.Gerente;
import codes.funcionario.classes.funcionarios.Secretaria;
import javax.swing.JOptionPane;

/**
 *
 * @author rodol
 */
public class Main {

    public static void main(String[] args) {
        Secretaria s1 = new Secretaria("Marcela", "11111111111", 1500);
        Gerente g1 = new Gerente("Eduardo", "22222222222", 7000, 123);
        Diretor d1 = new Diretor("Rodolfo", "33333333333", 15000, 123, 4);
        Diretor d2 = new Diretor("Jabaria", "44444444444", 15000, 123, 2);

        ControleBonificacao registro = new ControleBonificacao();

        registro.registrar(g1);
        registro.registrar(d1);

        Funcionario f2 = (Funcionario) g1;

        if (f2 instanceof Gerente) {
            JOptionPane.showMessageDialog(null,d1.getNome() + " " + d1.getCpf()
                    + "\n" + s1.getNome() + " " + s1.getCpf()
                    + "\n" + g1.getNome() + " " + g1.getCpf()
                    + "\n" + d2.getNome() + " " + d2.getCpf()
                    + "\n" + f2.calcularBonificacao()
                    + "\n" + g1.calcularBonificacao()
                    + "\n" + d1.calcularBonificacao()
                    + "\nBonificação Total: R$ " + registro.getBonificacaoTotal());
        } else {
            System.out.println("Erro");
        }
    }
}
