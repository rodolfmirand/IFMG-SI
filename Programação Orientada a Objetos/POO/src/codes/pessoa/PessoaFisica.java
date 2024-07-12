/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codes.pessoa;

/**
 *
 * @author rodol
 */
public class PessoaFisica extends Pessoa {

    private String cpf;
    private final double imposto = 10; // valor em porcentagem

    public PessoaFisica(String nome, String endereco, double valorPagamento, String cpf) {
        super(nome, endereco, valorPagamento);
        this.cpf = cpf;
    }

    @Override
    public double realizarPagamento() {
        return super.getValorPagamento() - (super.getValorPagamento() * (imposto / 100));
    }

}
